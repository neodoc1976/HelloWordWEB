package org.george.labyrynth;

import java.io.PrintWriter;

import static org.george.labyrynth.Walker.*;


/**
 * Created by Yulya on 01.04.2016.
 */
public class Field {

    Cell[][] cells;
    Walker walker = new Walker();

    public static final char R= '*'; //Список констант (символів),що відображають тип поля.
    public static final char W = '#';
    public static final char T = 'X';
    public static final char M = '+';
    public static final char P = 'O';

    public void setCells(Cell[][] c) {
        cells = c;

    }

    public void setWalker(Walker w) {
        walker = w;
    }

    public void printField(PrintWriter writer) {


        int a = walker.getX();
        int b = walker.getY();
        String d = walker.getDirection();

        writer.println("<pre>");

        printGorizontaLine(cells[0].length + 2, writer);
        writer.println();

        for (int y = 0; y < cells.length; y++) {
            writer.print("<a style=color:#B22222><big><big><big><strong><b>|</b></strong></big></big></big></a>");
            for (int x = 0; x < cells[y].length; x++) {
                if (a == x && b == y) {
                    switch (d) {
                        case RIGHT:
                            writer.print ("<a style=color:#FFFFE0><big><big><big><strong><b>&#9658;</b></strong></big></big></big></a>");
                            break;
                        case LEFT:
                            writer.print("<a style=color:#FFFFE0><big><big><big><strong><b>&#9668;</b></strong></big></big></big></a>");
                            break;
                        case UP:
                            writer.print("<a style=color:#FFFFE0><big><big><big><strong><b>&#9650;</b></strong></big></big></big></a>");
                            break;
                        case DOWN:
                            writer.print("<a style=color:#FFFFE0><big><big><big><strong><b>&#9660;</b></strong></big></big></big></a>");
                    }


                } else {

                    if (cells[y][x].getVisible() == true) {

                        writer.print(cells[y][x].getType());
                    }else{
                        writer.print(" ");
                    }

                    writer.print(" ");
                }
            }
            writer.println("<a style=color:#B22222><big><big><big><strong><b> |</b></strong></big></big></big></a>");
        }
        printGorizontaLine(cells[0].length + 2, writer);
        writer.println("</pre>");



    }

    private void printGorizontaLine(int length, PrintWriter writer) {
        for (int c = 0; c < length; c++) {
            writer.print("<a style=color:#B22222><b> &mdash;</b></a>");
        }

    }

    private void showMedCitHelp(PrintWriter writer) {
        walker.applyMedkit();
        writer.println("Found Medkit!"+"<a style=color:#FF0000><big><big><big><strong><b>+</b></strong></big></big></big></a>");
        checkHealth(writer);
    }

    private void showTrapDamage(PrintWriter writer) {
        walker.lossLargePartHP();
        writer.println("<a style=color:#FF0000>BOOM!</a>Robot hit a mine. Lost a large part of HP.");
        checkHealth(writer);
    }

    private void showHealthDecrease(PrintWriter writer) {
        printMessageNotMove(writer);
        walker.decreaseHp();
        checkHealth(writer);
    }

    private void printMessageNotMove(PrintWriter writer) {
        writer.println("I can not move in a given direction!");
        writer.println("Hit the wall! Lost of health!");


    }

    public void printMessageHpLevel(PrintWriter writer) {
        writer.println("Robot HP" + walker.getHp()  +"%");
    }

    private void checkHealth(PrintWriter writer) {
        if (walker.getHp() <= 25 && walker.getHp() > 0) {
        } else if (walker.getHp() <= 0) {
            writer.println("Robot is DEAD ! :(");
            writer.println("Final position, X: " + (walker.getX() + 1) + " , Y: " + (walker.getY() + 1));
            writer.println("GAME OVER");
            printField(writer);
            walker.teleport();
            walker.restoreHealth();
            writer.println();
            writer.println("NEW GAME");
        }

        printMessageHpLevel(writer);
    }

    private Cell getNextCell(String d) {
        int x = walker.getX();
        int y = walker.getY();
        switch (d) {
            case RIGHT:
                x = x + 1;
                if (x >= cells[0].length) {
                    return new Cell(W);
                }
                break;

            case LEFT:
                x = x - 1;
                if (x < 0) {
                    return new Cell(W);
                }
                break;

            case UP:
                y = y - 1;
                if (y < 0) {
                    return new Cell(W);
                }
                break;

            case DOWN:
                y = y + 1;
                if (y >= cells.length) {
                    return new Cell(W);
                }
                break;

        }
        return cells[y][x];
    }

    public void move(String d, PrintWriter writer) {
        int x = walker.getX();
        int y = walker.getY();
        cells [y][x].setVisible();

        Cell nextCell = getNextCell(d);


        if (nextCell.getType() == W) {
            walker.turn(d);
            showHealthDecrease(writer);
        } else if (nextCell.getType() == T) {

            walker.go(d);
            showTrapDamage(writer);
            cells[walker.getY()][walker.getX()] = new Cell(R);
        } else if (nextCell.getType() == M) {

            walker.go(d);
            showMedCitHelp(writer);
            cells[walker.getY()][walker.getX()] = new Cell(R);
        } else if (nextCell.getType() == P) {

            walker.go(d);
            walker.teleport();
            writer.println("Teleports to the starting position !");
            printMessageHpLevel(writer);

        } else {

            walker.go(d);
            printMessageHpLevel(writer);


        }
        Cell t = getNextCell(walker.getDirection());
        t.setVisible();


    }


    public void turningPoint(String d,PrintWriter writer){
        walker.turn(d);
        Cell t = getNextCell(walker.getDirection());
        t.setVisible();
        printMessageHpLevel(writer);



    }


}








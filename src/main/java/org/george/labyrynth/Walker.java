package org.george.labyrynth;

/**
 * Created by Yulya on 01.04.2016.
 */
public class Walker {

    public static final String UP = "u";// Список констант для case,що вказують на напрямок
    public static final String DOWN = "d";
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    public static final String TURN="t";
    public static final String STEP="s";

    private int hp = 100;
    private int x;
    private int y;
    private String direction = RIGHT;


    public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }


    public void teleport(){
        x=0;
        y=0;
        direction=RIGHT;
    }

    public void applyMedkit() {
        hp = hp + 25;
    }

    public void lossLargePartHP() {
        hp = hp - 25;
    }

    public void decreaseHp() {
        hp = hp - 10;
    }

    public void turn(String d){
        direction=d;

    }

    public void go(String d){
        switch(d){
            case UP:
                direction=UP;
                y--;
                break;
            case DOWN:
                direction=DOWN;
                y++;
                break;
            case RIGHT:
                direction=RIGHT;
                x++;
                break;
            case LEFT:
                direction=LEFT;
                x--;
                break;
        }
    }
    public void restoreHealth(){
        hp=100;
    }

    public void rotate (){
        switch (direction){
            case UP:
                direction=RIGHT;
                break;
            case RIGHT:
                direction=DOWN;
                break;
            case DOWN:
                direction=LEFT;
                break;
            case LEFT:
                direction=UP;
                break;



        }

    }




}


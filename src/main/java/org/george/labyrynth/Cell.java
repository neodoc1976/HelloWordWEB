package org.george.labyrynth;

/**
 * Created by Yulya on 02.04.2016.
 */
public class Cell {
    private char type;
    private boolean visible;
    Cell t;

    public char getType() {
        return type;
    }
    public boolean getVisible(){
        return visible;
    }
    public Cell(char t) {  // Конструктор
        type = t;


    }
    public void setVisible (){
        visible=true;


    }





}
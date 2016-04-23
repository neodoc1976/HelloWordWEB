package org.george;

/**
 * Created by Yulya on 12.04.2016.
 */
public class Field {
    public void printField(){
           // int a = walker.getX();
           // int b = walker.getY();
           // String d = walker.getDirection();

            printGorizontaLine(10);
            System.out.println();

            for (int y = 0; y < 5; y++) {
                System.out.print("| ");

                for (int x = 0; x < 10; x++) {



                        System.out.print("0");
                        System.out.print(" ");
                    }
                }

                System.out.println("|");

            }



    private void printGorizontaLine(int length) {
        for (int c = 0; c < length; c++) {
            System.out.print("- ");
        }

    }
}

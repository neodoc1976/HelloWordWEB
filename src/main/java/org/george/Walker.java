package org.george;

/**
 * Created by Yulya on 09.04.2016.
 */
public class Walker {

        private int position;

        public void stepForward() {
            position++;

        }

        public void stepBackward() {
            position = position - 1;

        }

        public int getPosition() {

            return position;
        }

        public void walkForward(int a) {
            position = position + a;

        }

        public void walkBackward(int a) {
            position = position - a;
        }

        public void comeBack() {
            position = 0;
        }


    }




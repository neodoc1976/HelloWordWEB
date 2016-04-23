package org.george.labyrynth.test;

import org.george.labyrynth.Walker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.george.labyrynth.Walker.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yulya on 23.04.2016.
 */
public class WalkerTest {
    Walker walker;
    @Before
    public void init(){
        walker=new Walker();
        assertEquals(walker.getX(), 0);
        assertEquals(walker.getY(), 0);
        assertEquals(walker.getDirection(),RIGHT);
        assertEquals(walker.getHp(),100);
    }

    @Test
    public void turnWalkerTest(){
        walker.turn(UP);
        assertEquals(UP,walker.getDirection());
        walker.turn(RIGHT);
        assertEquals(RIGHT,walker.getDirection());
        walker.turn(LEFT);
        assertEquals(LEFT,walker.getDirection());
        walker.turn(DOWN);
        assertEquals(DOWN,walker.getDirection());

    }
    @Test
    public void rotateTest (){
        walker.rotate();
        assertEquals(DOWN,walker.getDirection());
        walker.rotate();
        assertEquals(LEFT,walker.getDirection());
        walker.rotate();
        assertEquals(UP,walker.getDirection());
        walker.rotate();
        assertEquals(RIGHT,walker.getDirection());


    }
    @Test
    public void goTest (){
        int xstep=walker.getX();
        int ystep=walker.getY();
        walker.go(RIGHT);
        assertEquals(RIGHT,walker.getDirection());
        assertEquals(walker.getX(),xstep+1);
        walker.go(LEFT);
        assertEquals(LEFT,walker.getDirection());
        assertEquals(walker.getX(),xstep);
        walker.go(DOWN);
        assertEquals(DOWN,walker.getDirection());
        assertEquals(walker.getY(),ystep+1);
        walker.go(UP);
        assertEquals(UP,walker.getDirection());
        assertEquals(walker.getY(),ystep);
    }

}

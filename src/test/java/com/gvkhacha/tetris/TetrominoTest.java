package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;
import java.awt.Point;
/**
 * Unit test for general Tetomino cases
 */
public class TetrominoTest {
    @Test
    public void tetrominoCopyConstructor(){
    	Tetromino first = new Tetromino(0); // using IBlock
    	Tetromino second = new Tetromino(first);

    	Assert.assertNotSame(first, second);
    	Assert.assertArrayEquals(first.getTiles(), second.getTiles());


    	second.update();
    	Point[] expectedFirst = {new Point(0, 3), new Point(0, 4), new Point(0, 5), new Point(0, 6)};
    	Point[] expectedSecond = {new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(1, 6)};

    	Assert.assertArrayEquals(expectedFirst, first.getTiles());
    	Assert.assertArrayEquals(expectedSecond, second.getTiles());
    }

    @Test
    public void getTypeIntFromFaller(){
    	Tetromino tester = new Tetromino(3);
    	Assert.assertEquals(3, tester.getIntType());
    }
}

package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.awt.*;

/**
 * Unit test for Tetrominos.
 */
public class TBlockTetrominoTest {
    private void testTiles(int[][] expected, Point[] actual){
        for(int i=0; i<4; i++){
            Assert.assertEquals(new Point(expected[i][0], expected[i][1]), actual[i]);
        }
    }
    private static final int MID = Tetris.NUM_COLUMNS / 2;
    @Test
    public void defaultTilesUpright() {
        Tetromino tester = new Tetromino(1);
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID-1},{0, MID},{0, MID+1},{-1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateLeftIsFacesLeft() {
        Tetromino tester = new Tetromino(1);
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-1,MID},{0, MID},{1, MID},{0, MID-1}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateRightIsVerticalLine() {
        Tetromino tester = new Tetromino(1);
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-1,MID},{0, MID},{1, MID},{0, MID+1}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateRightTwiceForUpsideDown(){
        Tetromino tester = new Tetromino(1);
        tester.rotateRight();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0, MID-1}, {0, MID}, {0, MID+1}, {1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateBackToOriginal(){
        Tetromino t1 = new Tetromino(1);
        t1.rotateRight();
        t1.rotateLeft();

        Tetromino t2 = new Tetromino(1);
        t2.rotateLeft();
        t2.rotateLeft();
        t2.rotateLeft();
        t2.rotateLeft();

        Tetromino t3 = new Tetromino(1);
        t3.rotateRight();
        t3.rotateRight();
        t3.rotateRight();
        t3.rotateRight();

        int[][] expected = {{0,MID-1},{0, MID},{0, MID+1},{-1, MID}};
        testTiles(expected, t1.getTiles());
        testTiles(expected, t2.getTiles());
        testTiles(expected, t3.getTiles());
    }

    @Test
    public void moveDown() {
        Tetromino tester = new Tetromino(1);
        tester.update();
        int[][] expected = {{1,MID-1},{1, MID},{1, MID+1},{0, MID}};
        testTiles(expected, tester.getTiles());
    }


}

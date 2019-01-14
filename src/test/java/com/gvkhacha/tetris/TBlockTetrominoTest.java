package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.awt.*;

/**
 * Unit test for TBlocks.
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
        TBlock tester = new TBlock();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID-1},{0, MID},{0, MID+1},{-1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateLeftIsFacesLeft() {
        TBlock tester = new TBlock();
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-1,MID},{0, MID},{1, MID},{0, MID-1}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateRightIsVerticalLine() {
        TBlock tester = new TBlock();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-1,MID},{0, MID},{1, MID},{0, MID+1}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateRightTwiceForUpsideDown(){
        TBlock tester = new TBlock();
        tester.rotateRight();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0, MID-1}, {0, MID}, {0, MID+1}, {1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateBackToOriginal(){
        TBlock t1 = new TBlock();
        t1.rotateRight();
        t1.rotateLeft();

        TBlock t2 = new TBlock();
        t2.rotateLeft();
        t2.rotateLeft();
        t2.rotateLeft();
        t2.rotateLeft();

        TBlock t3 = new TBlock();
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
        TBlock tester = new TBlock();
        tester.update();
        int[][] expected = {{1,MID-1},{1, MID},{1, MID+1},{0, MID}};
        testTiles(expected, tester.getTiles());
    }


}

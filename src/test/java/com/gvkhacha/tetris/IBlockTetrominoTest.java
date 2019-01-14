package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Unit test for all IBlock Tetrominoes
 */
public class IBlockTetrominoTest {
    private void testTiles(int[][] expected, Point[] actual){
        for(int i=0; i<4; i++){
            Assert.assertEquals(new Point(expected[i][0], expected[i][1]), actual[i]);
        }
    }
    private static final int MID = Tetris.NUM_COLUMNS / 2;
    @Test
    public void defaultIsHorizontalLine() {
        IBlock tester = new IBlock();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID-2},{0, MID-1},{0, MID},{0, MID+1}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateLeftIsVerticalLine() {
        IBlock tester = new IBlock();
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-2,MID},{-1, MID},{0, MID},{1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void rotateRightIsVerticalLine() {
        IBlock tester = new IBlock();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-2,MID},{-1, MID},{0, MID},{1, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void moveDown() {
        IBlock tester = new IBlock();
        tester.update();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{1,MID-2},{1, MID-1},{1, MID},{1, MID+1}};
        testTiles(expected, tiles);
    }

    @Test
    public void downRotateLeftDown() {
        IBlock tester = new IBlock();
        tester.update();
        tester.rotateLeft();
        tester.update();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID},{1, MID},{2, MID},{3, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void moveRight(){
        IBlock tester = new IBlock();
        tester.moveRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID-1},{0, MID},{0, MID+1},{0, MID+2}};
        testTiles(expected, tiles);
    }

    @Test
    public void moveLeft(){
        IBlock tester = new IBlock();
        tester.moveLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,MID-3},{0, MID-2},{0, MID-1},{0, MID}};
        testTiles(expected, tiles);
    }

    @Test
    public void moveLeftAndRotate(){
        IBlock tester = new IBlock();
        tester.moveLeft();
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{-2,MID-1},{-1, MID-1},{0, MID-1},{1, MID-1}};
        testTiles(expected, tiles);
    }
}

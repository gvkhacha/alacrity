package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Unit test for all Tetrominos
 */
public class TetrominoTest {
    void testTiles(int[][] expected, Point[] actual){
        for(int i=0; i<4; i++){
            Assert.assertEquals(new Point(expected[i][0], expected[i][1]), actual[i]);
        }
    }

    @Test
    public void allTetrominosStartNotFrozen(){
        Tetromino[] tester = {new IBlock()};
        for(int i=0; i<tester.length; i++){
            Assert.assertFalse(tester[i].frozen);
        }
    }
    @Test
    public void defaultIBlockIsVerticalLine() {
        IBlock tester = new IBlock();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,0},{0, 1},{0, 2},{0, 3}};
        testTiles(expected, tiles);
    }

    @Test
    public void IBlockRotatedLeftIsHorizontal() {
        IBlock tester = new IBlock();
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,0},{1,0},{2,0},{3,0}};
        testTiles(expected, tiles);
    }

    @Test
    public void IBlockRotatedRightIsHorizontal() {
        IBlock tester = new IBlock();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,0},{1,0},{2,0},{3,0}};
        testTiles(expected, tiles);
    }

    @Test
    public void IBlockDown() {
        IBlock tester = new IBlock();
        tester.update();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,1},{0,2},{0,3},{0,4}};
        testTiles(expected, tiles);
    }

    @Test
    public void IBlockDownLeftDown() {
        IBlock tester = new IBlock();
        tester.update();
        tester.rotateLeft();
        tester.update();
        Point[] tiles = tester.getTiles();
        int[][] expected = {{0,2},{1,2},{2,2},{3,2}};
        testTiles(expected, tiles);
    }

    @Test
    public void IBlockMoveRight(){
        IBlock tester = new IBlock();
        tester.moveRight();
        int[][] expected = {{1,0},{1,1},{1,2},{1,3}};
    }
}

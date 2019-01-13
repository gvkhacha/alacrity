package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Unit test for all Tetrominos
 */
public class TetrominoTest {
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
        Assert.assertEquals(new Point(0, 0), tiles[0]);
        Assert.assertEquals(new Point(0, 1), tiles[1]);
        Assert.assertEquals(new Point(0, 2), tiles[2]);
        Assert.assertEquals(new Point(0, 3), tiles[3]);
    }

    @Test
    public void IBlockRotatedLeftIsHorizontal() {
        IBlock tester = new IBlock();
        tester.rotateLeft();
        Point[] tiles = tester.getTiles();
        Assert.assertEquals(new Point(0, 0), tiles[0]);
        Assert.assertEquals(new Point(1, 0), tiles[1]);
        Assert.assertEquals(new Point(2, 0), tiles[2]);
        Assert.assertEquals(new Point(3, 0), tiles[3]);
    }

    @Test
    public void IBlockRotatedRightIsHorizontal() {
        IBlock tester = new IBlock();
        tester.rotateRight();
        Point[] tiles = tester.getTiles();
        Assert.assertEquals(new Point(0, 0), tiles[0]);
        Assert.assertEquals(new Point(1, 0), tiles[1]);
        Assert.assertEquals(new Point(2, 0), tiles[2]);
        Assert.assertEquals(new Point(3, 0), tiles[3]);
    }
    
}

package com.gvkhacha.tetris;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Tetris Game Logic
 */
public class TetrisTest {
    @Test
    public void createTetrisGameWithEmptyBoard() {
        Tetris game = new Tetris();
        for(int r=0; r<game.NUM_ROWS; r++){
            for(int c=0; c<game.NUM_COLUMNS; c++){
                Assert.assertEquals(Block.EMPTY, game.tileAt(r, c));
            }
        }
    }
}

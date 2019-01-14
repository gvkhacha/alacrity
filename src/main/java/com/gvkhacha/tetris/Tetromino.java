/**
 * Tetrominos represent the blocks in a Tetris game. They can either be I, O, T, J, L, S, or Z blocks.
 * https://en.wikipedia.org/wiki/Tetromino
 * The Point is the basis of these blocks, and each Point represents the (row, column) pair of the piece
 *    of the tetromino.
 */
package com.gvkhacha.tetris;

import java.awt.*;

abstract class Tetromino {
    static final int SIZE = 4;
    boolean frozen;
    int row;
    int column;

    Tetromino(){
        frozen = false;
        column = Tetris.NUM_COLUMNS / 2;
        row = 0;
    }

    boolean isFrozen(){
        return this.frozen;
    }

    void update(){
        row++;
    }

    void moveLeft(){
        if(column > 0)
            column--;
    }

    void moveRight(){
        if(column < Tetris.NUM_ROWS)
            column++;
    }

    abstract void rotateLeft();

    abstract void rotateRight();

    abstract Point[] getTiles();
}

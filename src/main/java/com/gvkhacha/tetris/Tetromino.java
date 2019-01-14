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
        if(row < Tetris.NUM_ROWS)
            row++;
    }

    abstract void rotateLeft();

    abstract void rotateRight();

    abstract Point[] getTiles();
}

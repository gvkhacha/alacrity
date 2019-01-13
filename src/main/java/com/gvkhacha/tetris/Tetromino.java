package com.gvkhacha.tetris;

import java.awt.*;

abstract class Tetromino {
    static final int SIZE = 4;
    boolean frozen;
    int row;
    int column;
    Point[] tiles;

    Tetromino(){
        frozen = false;
        row = Tetris.NUM_ROWS / 2;
        column = 0;
        tiles = new Point[4];
    }

    boolean isFrozen(){
        return this.frozen;
    }

    Point[] getTiles() { return this.tiles; }

    abstract void update();

    abstract void rotateLeft();

    abstract void rotateRight();


}

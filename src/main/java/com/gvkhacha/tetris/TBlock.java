package com.gvkhacha.tetris;

import java.awt.*;

class TBlock extends Tetromino {
    private static final Point[][] tileConfig = {
            {new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, -1)},
            {new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(-1, 0)},
            {new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1)},
            {new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(1, 0)},
    };
    // index starts at 1 to allow for both rotating left/right clearly.
    private int index = 1;
    TBlock(){
        super();
    }

    @Override
    void rotateRight(){
        // add by 1, unless at 3, loop back to 0.
        index = index == 3 ? 0 : index + 1;
    }

    @Override
    void rotateLeft(){
        // Subtract by 1, unless at 0, loop back to 3
        index = index == 0 ? 3: index - 1;
    }

    @Override
    Point[] getTiles(){
        Point[] tiles = new Point[4];
        for(int i=0; i<4; i++){
            tiles[i] = new Point(tileConfig[index][i]);
            tiles[i].translate(row, column);
        }
        return tiles;
    }
}

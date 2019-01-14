package com.gvkhacha.tetris;

import java.awt.*;

class IBlock extends Tetromino {
    private static final Point[][] tileConfig = {
            {new Point(0, 0), new Point(0,1), new Point(0, 2), new Point(0, 3)},
            {new Point(0, 0), new Point(1,0), new Point(2, 0), new Point(3, 0)}
    };
    private int index = 0;
    IBlock(){
        super();
    }

    @Override
    void rotateRight(){
        rotate();
    }

    @Override
    void rotateLeft(){
        rotate();
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

    private void rotate(){
        index = index == 0 ? 1 : 0;
    }
}

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
        this.tiles = tileConfig[index];
    }

    /**
     * Drops the relative positions for the tetronimo.
     * Tetris Game will have to consider collisions after update.
     */
    @Override
    void update(){
        for(int i=0; i<SIZE; i++){
            this.tiles[i].translate(0, 1);
        }
    }

    @Override
    void rotateRight(){
        rotate();
    }

    @Override
    void rotateLeft(){
        rotate();
    }

    private void rotate(){
        index = index == 0 ? 1 : 0;
        this.tiles = tileConfig[index];
    }
}

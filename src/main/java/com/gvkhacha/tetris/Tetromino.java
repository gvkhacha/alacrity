/**
 * Tetrominos represent the blocks in a Tetris game. They can either be I, O, T, J, L, S, or Z blocks.
 * https://en.wikipedia.org/wiki/Tetromino
 * The Point is the basis of these blocks, and each Point represents the (row, column) pair of the piece
 *    of the tetromino.
 */
package com.gvkhacha.tetris;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;
import java.awt.Point;

enum Type{
    IBlock,
    TBlock,
}

class Tetromino {
    static final int SIZE = 4;
    boolean frozen;
    int row;
    int column;
    private int index;
    private Type type;
    //
    private static final List<Type> BLOCK_TYPES = Collections.unmodifiableList(Arrays.asList(Type.values()));
    private static final int TYPES_SIZE = BLOCK_TYPES.size();
    private static final Random rand = new Random();
    // All tile configs for each block lies here. Index is corresponding to Type enum.
    private static final int[][][][] tileConfig = {
        {
            {{0, -2}, {0, -1}, {0, 0}, {0, 1}},
            {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}},
            {{0, -2}, {0, -1}, {0, 0}, {0, 1}},
            {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}}
        },
        {
            {{0, -1}, {0, 0}, {0, 1}, {-1, 0}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {1, 0}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, -1}}
        }
    };

    /**
      * Default constructor will make a tetormino in the middle of the board,
      * on the first row, and of random type. 
      */
    Tetromino(){
        frozen = false;
        column = Tetris.NUM_COLUMNS / 2;
        row = 0;
        type = BLOCK_TYPES.get(rand.nextInt(2));
        index = 0;
    }

    Tetromino(int t){
        frozen = false;
        column = Tetris.NUM_COLUMNS / 2;
        row = 0;
        type = BLOCK_TYPES.get(t);
        index = 0;   
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

    void rotateRight(){
        // add by 1, unless at 3, loop back to 0.
        index = index == 3 ? 0 : index + 1;
    }

    void rotateLeft(){
        // Subtract by 1, unless at 0, loop back to 3
        index = index == 0 ? 3: index - 1;
    }

    Point[] getTiles(){
        Point[] tiles = new Point[4];
        for(int i=0; i<4; i++){
            tiles[i] = new Point(tileConfig[type.ordinal()][index][i][0],
                tileConfig[type.ordinal()][index][i][1]);
            tiles[i].translate(row, column);
        }
        return tiles;
    }
}

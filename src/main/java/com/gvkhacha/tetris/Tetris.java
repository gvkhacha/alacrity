package com.gvkhacha.tetris;

enum Block{
    EMPTY, RED, GREEN, BLUE;
}


public class Tetris {
    static int NUM_ROWS = 20;
    static int NUM_COLUMNS = 10;
    private Block[][] board;

    Tetris(){
        this.board = new Block[NUM_ROWS][NUM_COLUMNS];
        for(int r=0; r<NUM_ROWS; r++){
            for(int c=0; c<NUM_COLUMNS; c++){
                this.board[r][c] = Block.EMPTY;
            }
        }
    }

    /**
     * Retrieves a single block from the two dimensional board
     * @param r row number on board
     * @param c column number on board
     * @return Single Block at location
     */
    Block tileAt(int r, int c){
        return this.board[r][c];
    }
}

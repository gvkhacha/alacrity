package com.gvkhacha.tetris;
import java.awt.Point;

// Blocks are in same order as tetromino types enum
enum Block{
    EMPTY, CYAN, YELLOW, PURPLE, BLUE, ORANGE, GREEN, RED;
}


public class Tetris {
    static int NUM_ROWS = 20;
    static int NUM_COLUMNS = 10;
    private Block[][] board;
    private Tetromino faller;

    Tetris(){
        this.board = new Block[NUM_ROWS][NUM_COLUMNS];
        for(int r=0; r<NUM_ROWS; r++){
            for(int c=0; c<NUM_COLUMNS; c++){
                this.board[r][c] = Block.EMPTY;
            }
        }
        this.faller = new Tetromino();
    }

    /**
      * Continue one tick of the game model
      * if the next tick of the faller will collide with any block on the board
      * the blocks are frozen and placed in the board, and a new faller is made. 
      */
    void update(){
        if(checkCollisions()){
            Block fallerColor = Block.values()[1 + faller.getIntType()];
            for(Point p : tiles){
                this.board[(int)p.getX()][(int)p.getY()] = fallerColor;
            }
            this.faller = new Tetromino();
        }else{
            this.faller.update();
        }
    }

    /**
      * Creates a copy of the faller, moves it down one tick
      * if that faller collides with the board, the original faller is frozen.
      * @return true if there is a collision
      */
    private boolean checkCollisions(){
        Tetromino nextFaller = new Tetromino(faller);
        nextFaller.update();
        Point[] tiles = nextFaller.getTiles();
        for(Point p : tiles){
            if(this.board[(int)p.getX()][(int)p.getY()] != Block.EMPTY){
                return true;
            }
        }
        return false;
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

package com.gvkhacha.tetris;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public class Tetris {
    public static int NUM_ROWS = 20;
    public static int NUM_COLUMNS = 10;
    private Block[][] board;
    private Tetromino faller;

    public Tetris() {
        this.board = new Block[NUM_ROWS][NUM_COLUMNS];
        for(int r = 0; r < NUM_ROWS; r++) {
            for(int c = 0; c < NUM_COLUMNS; c++) {
                this.board[r][c] = Block.EMPTY;
            }
        }
        this.faller = new Tetromino();
    }

    /**
      * Continue one tick of the game model
      * if the next tick of the faller will collide with any block on the board
      * the blocks are frozen and placed in the board, and a new faller is made.
      * @return true if a new faller is made
      */
    public boolean update() {
        boolean flag = false;
        if(checkCollisions()) {
            Block fallerColor = Block.values()[1 + faller.getIntType()];
            Point[] tiles = this.faller.getTiles();
            for(Point p : tiles) {
                int x = (int) p.getX();
                int y = (int) p.getY();
                if(x < 0){
                    // Game over!
                }
                this.board[x][y] = fallerColor;
            }
            this.faller = new Tetromino();
            flag = true;
        } else {
            this.faller.update();
        }
        checkRowClear();
        return flag;
    }

    /**
      * Creates a copy of the faller, moves it down one tick
      * if that faller collides with the board, the original faller is frozen.
      * @return true if there is a collision
      */
    private boolean checkCollisions() {
        Tetromino nextFaller = new Tetromino(faller);
        nextFaller.update();
        Point[] tiles = nextFaller.getTiles();
        for(Point p : tiles) {
            int x = (int) p.getX();
            int y = (int) p.getY();
            if(x == Tetris.NUM_ROWS || (x >= 0 && this.board[x][y] != Block.EMPTY))
                return true;
        }
        return false;
    }

    /**
     * Retrieves a single block from the two dimensional board
     * @param r row number on board
     * @param c column number on board
     * @return Single Block at location
     */
    public Block tileAt(int r, int c) {
        for(Point p : this.faller.getTiles()) {
            if(r == p.getX() && c == p.getY())
                return Block.values()[1 + faller.getIntType()];
        }
        return this.board[r][c];
    }

    public void moveLeft(){
        for(Point p : this.faller.getTiles()) {
            if((int) p.getY() <= 0)
                return;
        }
        this.faller.moveLeft();
    }

    public void moveRight(){
        for(Point p : this.faller.getTiles()) {
            if((int) p.getY() >= NUM_COLUMNS - 1)
                return;
        }
        this.faller.moveRight();
    }

    public void rotateLeft(){
        this.faller.rotateLeft();
    }

    public void rotateRight(){
        this.faller.rotateRight();
    }

    public void hardDrop(){
        while(true){
            if(update())
                return;
        }
    }

    private void checkRowClear(){
        List<Integer> moveDownRows = new ArrayList<Integer>();
        for(int r=0; r<NUM_ROWS; r++){
            if(clearRowAt(r))
                moveDownRows.add(r);
        }

        for(int row : moveDownRows){
            System.out.println(row);
            moveDownFromRow(row);
        }
    }

    private boolean clearRowAt(int r){
        for(int c=0; c<NUM_COLUMNS; c++){
            if(this.board[r][c] == Block.EMPTY)
                return false;
        }
        for(int c=0; c<NUM_COLUMNS; c++){
            this.board[r][c] = Block.EMPTY;
        }
        return true;
    }

    private void moveDownFromRow(int row){
        for(int r = row; r>1; r--){
            for(int c=0; c<NUM_COLUMNS; c++){
                this.board[r][c] = this.board[r-1][c];
            }
        }
    }

    // private void checkSideCollisions(Callable func){
    //     Tetromino nextFaller = new Tetromino(this.faller);
    //     nextFaller.
    // }
}

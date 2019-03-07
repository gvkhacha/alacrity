package gvkhacha.alacrity.engine;

import java.util.List;
import java.util.ArrayList;

/**
  * Board is a wrapper for a two-dimensional 
  * List from collections to simulate a grid based board
  */
public class Board{
	private List<List<Piece>> data;
	private final int numRows;
	private final int numCols;

	Board(int numRows, int numCols){
		this.numRows = numRows;
		this.numCols = numCols;
		data = new ArrayList<List<Piece>>(numRows);
		for(int r=0; r<numRows; r++){
			data.add(new ArrayList<Piece>(numCols));
		}
		resetBoard();
	}

	/**
	  * Removes all Pieces in the board, and re-fills the board with 
	  * empty pieces. Does not change the size of the board.
	  */
	void resetBoard(){
		for(List l : data){
			l.clear();
			for(int i=0; i<numCols; i++){
				l.add(new Piece());
			}
		}
	}

	/**
	  * Replaces the tile at given row/column with a new piece. By default,
	  * all pieces are empty pieces.
	  * @param r the selected row of board
	  * @param c the selected column of the board
	  * @param newPiece Piece to replace the current.
	  * @return the Piece that was on the board before replacing.
	  */
	Piece replacePieceAt(int r, int c, Piece newPiece){

	}
}
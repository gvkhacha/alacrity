package gvkhacha.alacrity.engine;

import java.util.List;
import java.util.ArrayList;

/**
  * GameState is the most basic manager of game data
  * which should hold at least one Player.
  */
public class GameState{
	private int numPlayers;
	private List<Player> players;

	GameState(){
		this.numPlayers = 1;
		players = new ArrayList<Player>();
		players.add(new Player());
	}

	public int getNumPlayers(){
		return this.numPlayers;
	}

	public Player getPlayer(int index){
		return this.players.get(index);
	}

	public Player getPlayer(String name) throws PlayerNotFound{
		for(Player p : this.players){
			if(p.getName().equals(name)){
				return p;
			}
		}
		throw new PlayerNotFound();
	}
}


/**
  * GridGameState is the data manager for games that revolve around a grid-based
  * board. i.e. tic tac toe, checkers, chess, etc.
  * Even things without physical boards, such as Tetris, can use this.
  */
class GridGameState extends GameState{
	private static final int DEFAULT_NUM_ROWS = 8;
	private static final int DEFAULT_NUM_COLS = 8;

	private int numRows;
	private int numCols;
	private Piece[][] grid;

	GridGameState(){
		this(DEFAULT_NUM_ROWS, DEFAULT_NUM_COLS);
	}

	GridGameState(int rows, int cols){
		this.numRows = rows;
		this.numCols = cols;
		this.createEmptyGrid();
	}

	private void createEmptyGrid(){
		this.grid = new Piece[this.numRows][this.numCols];

	}

}
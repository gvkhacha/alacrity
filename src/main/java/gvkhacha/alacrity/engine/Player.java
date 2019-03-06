package gvkhacha.alacrity.engine;

class PlayerNotFound extends Exception {

}


/**
  * Represents a Player in any single game.
  * A Player should not be a part of more than one game. 
  * Though a player has a score, it is up to the game to decide
  * representation (points, # of pieces, $, etc.)
  */
public class Player {
	private String name;
	private double score = 0.0;
	Player(){
		this.name = "Unnamed";
	}

	Player(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public double getScore(){
		return this.score;
	}

	public void increase(double amount){
		this.score += amount;
	}

	public void decrease(double amount){
		this.score -= amount;
	}

	public void setScore(double amount){
		this.score = amount;
	}
}

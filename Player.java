//****************************************************************************
// Sean Liu
// sl3497
// 10/19/2013
// file: Player.java
//
// Objects of this class manage player functions in the Dice Game.
//****************************************************************************

import java.util.Arrays;
import java.util.Scanner;

public class Player {
	
	private Dice roller = new Dice(4, 6);
	private int[] player1 = new int[4];
	private int[] player2 = new int[4];
	private String move;
	private Scanner input = new Scanner(System.in);
	
	// Initializes the object.
	public Player(){
	}
	
	// Draws the line for the computer player.
	// Strategy 1: returns number between 24 and 32.
	// Strategy 2: returns median value 28.
	public int compLine(int x){
		if (x==1)
			return (int)(24 + Math.random() * 8);
		else
			return 28;
	}
	
	// Initializes the dice rolls of the two players.
	public void initialize(){
		player1 = roller.roll();
		player2 = roller.roll();
	}
	
	// Prints player's dice rolls.
	public void printRolls(){
		System.out.println("You rolled: " + Arrays.toString(player1));
	}
	
	// Presents computer's line and returns the player's move.
	public String playerMove(int compGuess){
		printRolls();
		System.out.println("Computer guess: " + compGuess);
		System.out.println("Your guess? over/under");
		move = input.nextLine();
		System.out.println();
		return move;
	}
	
	// Determines who is the winner.
	public boolean win(String guess, int line){
		int sum = roller.rollSum(player1);
		sum += roller.rollSum(player2);
		if (guess.equals("over"))
			if (sum > line)
				return true;
			else
				return false;
		else
			if (sum < line)
				return true;
			else
				return false;
	}
	
	// Determines whether the computer will pick "over" or "under."
	public String guess(int me, int him){
		// If opponent's line is greater, guess "under."
		if (me < him)
			return "under";
		// If opponent's line is smaller, guess "over."
		else if (me > him)
			return "over";
		// If opponent's line is the same, randomly guess.
		else{
			double x = Math.random();
			if (x < 0.5)
				return "under";
			else
				return "over";
		}
	}
	
}
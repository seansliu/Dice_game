//****************************************************************************
// Sean Liu
// sl3497
// 10/19/2013
// file: Game.java
//
// Objects of this class either simulate or play the Dice game.
//****************************************************************************

public class Game {

	private int mode, line1, line2, winScore = 10;
	private int wins1, wins2, trials = 1000, record1= 0, record2 = 0;
	private String playerChoice;
	private Player players = new Player();
	
	// Initializes the object with which mode to perform.
	// mode = 1: interactive
	// mode = 2: simulation
	public Game(int n){
		mode = n;
	}
	
	// Resets the game scores.
	private void reset(){
		wins1 = 0;
		wins2 = 0;
	}
	
	// Determines whether player scores, notifies player, and updates record.
	private void intEvaluate(String playerChoice, int line){
		if (players.win(playerChoice, line)){
			wins1 += 1; // Player's score
			System.out.println("You're right!");
		}
		else{
			wins2 += 1; // Computer's score
			System.out.println("You're wrong!");
		}
		System.out.println("Your score: " + wins1);
		System.out.println("Computer score: " + wins2);
		System.out.println();
	}
	
	// Plays one round of the interactive game.
	private void intRound(){
		players.initialize();
		line1 = players.compLine(1);
		playerChoice = players.playerMove(line1);
		intEvaluate(playerChoice, line1);
	}
	
	// Plays the interactive game.
	private void interactive(){
		reset();
		while (wins1 < winScore && wins2 < winScore)
			intRound();
	}
	
	// Prints whether user wins or loses the game.
	private void intResult(){
		if (wins1 == winScore)
			System.out.println("Congratulations, you win!");
		else
			System.out.println("Boo, you lose.");
	}
	
	// Determines whether given strategy succeeds and updates score.
	private void score(String playerChoice, int line, int guesser){
		// Line-drawer wins if guesser loses. (line belongs to line-drawer.)
		if (players.win(playerChoice, line)){
			if (guesser == 1)
				wins1 += 1;
			else
				wins2 += 1;
		}
		else{
			if (guesser == 1)
				wins2 += 1;
			else
				wins1 += 1;
		}
	}	
	
	// Prints results of strategy simulation.
	private void simResult(){
		System.out.println(trials + " games simulated.");
		System.out.println("Cannon's Strategy: " + record1 + " wins");
		System.out.println("My Strategy: " + record2 + " wins");
	}
	
	// Updates the win/loss record between two players.
	private void record(){
		if (wins1 == winScore)
			record1 += 1;
		else
			record2 += 1;
	}
	
	// Initiates the round and draws the lines for the simulation.
	private void simLines(){
		players.initialize();
		line1 = players.compLine(1);
		line2 = players.compLine(2);	
	}

	// Simulates one round of the game, and
	// evaluates the winner, given the strategy.
	private void simRound(int strategy){
		simLines();
		if (strategy == 1){
			playerChoice = players.guess(line1, line2);
			score(playerChoice, line2, 1);
		}
		else{
			playerChoice = players.guess(line2, line1);
			score(playerChoice, line1, 2);
		}
	}
	
	// Simulates the game given the strategy.
	private void simGame(int strategy){
		reset();
		while (wins1 < winScore && wins2 < winScore)	
			simRound(strategy);
		record();
	}

	// Simulates the game for however many trials specified.
	private void simulation(){
		// Play 2 games per loop, one per strategy.
		for (int i = 0; i < trials; i += 2){
			simGame(1);
			simGame(2);
		}
	}
	
	// Plays the game or runs the simulation.
	public void play(){
		if (mode==1){
			interactive();
			intResult();
		}
		else if (mode==2){
			simulation();
			simResult();
		}
	}
	
}
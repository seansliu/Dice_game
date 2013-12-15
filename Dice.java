//****************************************************************************
// Sean Liu
// sl3497
// 10/19/2013
// file: Dice.java
//
// Objects of this class perform the Dice operations useful for the Dice game.
//****************************************************************************

public class Dice {

	private int sides;
	private int dice;
	
	// Initializes the number of dice and number of sides per die.
	public Dice(int m, int n){
		dice = m;
		sides = n;
	}
	
	// Rolls each die and returns an array of rolled values.
	public int[] roll(){
		int[] rolls = new int[dice];
		for (int i = 0; i < dice; i++)
			rolls[i] = (int)(Math.random() * sides + 1);
		return rolls;
	}
	
	// Returns the sum of the integer elements in an input array.
	public int rollSum(int[] rolls){
		int size = rolls.length;
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += rolls[i];
		return sum;
	}
	
}
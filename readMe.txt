Sean Liu
sl3497

1. How to use this program.
With 'Dice.java', 'Player.java', 'Game.java', and 'DiceTest.java' in the same directory, compile all above the files and run 'DiceTest'. Then, just follow the instructions.

2. Design decisions.
I followed the instructions and wrote four classes.
'Dice.java' contained all the methods concerned with dice. I created two private integer variables, sides and dice, so that the user could decide how many dice to roll and how many sides each dice would have. roll() returns a an array of the desired number of dice rolls. rollSum() takes an array and returns the sum of the elements in that array. Both would come 
'Player.java' contained all the methods that dealt with the players, human, computer, and simulators. I declared all the variables as private so that they could be easily edited. I decided to save dice rolls as arrays, because they save the dice rolls in a clear way. I wrote methods that would help the computer decide a line, print the human player's rolls, take and return the player's input whether to go over or under, evaluate whether the player has won (through a series of if loops), and help the computer player decide whether to go over or under (using if loops to compare its line to the other line). 
'Game.java' contained all the methods that played both the interactive game and the simulation. I saved the mode, winning score, lines, game wins, trials, simulation record, player's decision, and Player object as private variables, because I would reuse them multiple times for the game and they would be easily to edited. The methods I wrote all utilized the methods in the Player class to implement the game.
'DiceTest.java' was given for the assignment.

For my own strategy, I decided to have my computer player pick 28 as its line every time, because 28 should be the median value for dice rolls, and therefore the most probably line. When simulated with Cannon's strategy, my strategy won around 75% of the time.
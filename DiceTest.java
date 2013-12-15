//****************************************************************************
// Sean Liu
// sl3497
// 10/19/2013
// file: DiceTest.java
//
// This program tests the Dice game and its strategy simulations.
//****************************************************************************

import java.util.Scanner;

public class DiceTest{

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        //Display greeting and menu
        System.out.println("Welcome to Programming Project 3!");
        System.out.println("Please choose: ");
        System.out.println();
        System.out.println("Interactive mode: \t Press 1");
        System.out.println("Simulation mode: \t Press 2");
	
        //get mode of play
        int mode=input.nextInt();
        
        //create and play the game or simulation
        Game g = new Game(mode);
        g.play();

	}
}

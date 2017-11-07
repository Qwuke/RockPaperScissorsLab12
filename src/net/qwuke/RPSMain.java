package net.qwuke;

import java.util.HashMap;
import java.util.Scanner;



public class RPSMain {
	
	public static void finalScorePrint(HashMap<Player,int[]> scores, Player p1, Player p2, Player p3) {
			
		
			System.out.printf("%-10s %-10s %-10s %-10s\n", "Player", "Draws", "Wins", "Losses");
			System.out.printf("%-10s %-10s %-10s %-10s\n", p1.getName(), Integer.toString(scores.get(p1)[0]), Integer.toString(scores.get(p1)[1]), Integer.toString(scores.get(p1)[2]));
			System.out.printf("%-10s %-10s %-10s %-10s\n", p2.getName(), Integer.toString(scores.get(p2)[0]), Integer.toString(scores.get(p2)[1]), Integer.toString(scores.get(p2)[2]));
			System.out.printf("%-10s %-10s %-10s %-10s\n", p3.getName(), Integer.toString(scores.get(p3)[0]), Integer.toString(scores.get(p3)[1]), Integer.toString(scores.get(p3)[2]));

	}
	
	public static void duelPOnePTwo(Player p1, Player p2, HashMap<Player,int[]> scores) {	
		
		Roshambo player1Choice = p1.generateRoshambo();
		System.out.println(p1.getName()+" chose " + player1Choice);
		Roshambo player2Choice = p2.generateRoshambo();
		System.out.println(p2.getName()+" chose " + player2Choice);
		
		if (player1Choice == player2Choice) {
			System.out.println("AAAAAAAAA It's a draw! Both players chose "+player1Choice+"!");
			scores.get(p1)[0]++;
			scores.get(p2)[0]++;
			
		} else if (p1WinCondition(player1Choice,player2Choice)) {
			System.out.println(p1.getName() + " beats " + p2.getName() +"'s " + player2Choice + " with their " + player1Choice + "! The crowd goes wild!");
			scores.get(p1)[1]++;
			scores.get(p2)[2]++;

		} else {
			System.out.println(p2.getName() + " utterly annihilates " + p1.name + "! The crowd is starting to lose it!");
			scores.get(p1)[2]++;
			scores.get(p2)[1]++;

		}
	}
	
	public static boolean p1WinCondition(Roshambo p1Choice, Roshambo p2Choice) {
		if (( p1Choice == Roshambo.ROCK && p2Choice == Roshambo.SCISSORS) || (p1Choice == Roshambo.SCISSORS && p2Choice == Roshambo.PAPER) || (p1Choice == Roshambo.PAPER && p2Choice == Roshambo.ROCK)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valid = "y"; // String for validating whether or not to continue based on y or n
		System.out.println("Hello human! Welcome to the Grand Circus Roshambo Masters Tournament!");
		System.out.println("Whether you want to or not, human, you are going to play at least one game with us!");
		System.out.println("Resistance will only delay the inevitable!");
		System.out.println();
		//Initialize players and the scoreboard
		Player megaDog = new Megadog();
		Player tristan = new Tristan();
		Player human = new Human(sc);
		
		HashMap<Player,int[]> pScores = new HashMap<Player, int[]>();
		pScores.put(tristan, new int[3]);
		pScores.put(megaDog, new int[3]);
		pScores.put(human, new int[3]);
		
		
		while (valid.equalsIgnoreCase("y")) {

			//Validate user input on whether 
			System.out.println("Do you want to duel the Megadog or Tristan?");
			System.out.println("Type M for the Megadog or T for Tristan");
			String oppChoice = sc.nextLine();
			
			while (!(oppChoice.equalsIgnoreCase("m") || oppChoice.equalsIgnoreCase("t"))) {
				System.out.println("That wasn't a valid input! Type M to duel the Megadog or T to duel Tristan");
				oppChoice = sc.nextLine();
			}
			
			if(oppChoice.charAt(0) =='T'||oppChoice.charAt(0) =='t') {
				duelPOnePTwo(human,tristan,pScores);
			} else {
				duelPOnePTwo(human,megaDog,pScores);
			}
			
			//Print current score for player
			System.out.println(human.getName() + "! You currently have " + pScores.get(human)[0] + " draws, "+ pScores.get(human)[1] + " wins, and "+ pScores.get(human)[2] + " losses...");
			
			System.out.println("\nType y to continue or n to end the program");
			valid = sc.nextLine();
			while (!(valid.equalsIgnoreCase("y") || valid.equalsIgnoreCase("n"))) {
				System.out.println("That wasn't a valid input! Type y to continue or n to stop");
				valid = sc.nextLine();
			}
		} // If y, rerun the program
		System.out.println("FINAL SCORE\n");

		finalScorePrint(pScores,megaDog,tristan,human);	
	}

}

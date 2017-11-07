package net.qwuke;

import java.util.Scanner;



public class RPSMain {
	
	public int checkIfPlayer1Wins(Player p1, Player p2) {
		Roshambo player1Choice = p1.generateRoshambo();
		Roshambo player2Choice = p2.generateRoshambo();
		if(player1Choice == player2Choice) {
			return 2;
		} else if (p1WinCondition(player1Choice,player2Choice)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static boolean p1WinCondition(Roshambo p1Choice, Roshambo p2Choice) {
		if (( p1Choice == Roshambo.ROCK && p2Choice == Roshambo.SCISSORS)||(p1Choice == Roshambo.SCISSORS && p2Choice == Roshambo.PAPER)||(p1Choice == Roshambo.PAPER && p2Choice == Roshambo.ROCK)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		Player megaDog = new Megadog();
		Player tristan = new Tristan();
		Player human = new Human(sc);
		System.out.print(human.getName());
	}

}

package net.qwuke;

import java.util.Scanner;

public class Human extends Player {

	Scanner scan;
	
	public Human(Scanner scan) {
		super();
		this.scan = scan;
		System.out.println("Human! What is your name?");
		String humanName = scan.nextLine();
		this.name = humanName;
	}
	
	public void setName() {
		System.out.println("What is your name again?");
		this.name = scan.nextLine();
	}

	@Override
	public Roshambo generateRoshambo() {
		System.out.println("Type R to choose rock, P to choose paper, or S to choose scissors: ");
		String valid = scan.nextLine();
		while (!( valid.equalsIgnoreCase("r") || valid.equalsIgnoreCase("p") || valid.equalsIgnoreCase("s") )) {
			System.out.println("That wasn't a valid input!");
			System.out.println("Type R to choose rock, P to choose paper, or S to choose scissors: ");
			valid = scan.nextLine();
		}
		
		switch (valid.charAt(0)) {
		case 'r':
		case 'R':
			return Roshambo.ROCK;
		case 'p':
		case 'P':
			return Roshambo.PAPER;
		case 's':
		case 'S':
			return Roshambo.SCISSORS;
		}
		return null;
	}

}

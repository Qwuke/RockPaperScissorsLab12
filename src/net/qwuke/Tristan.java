package net.qwuke;

public class Tristan extends Player {
	
	public Tristan() {
		super("Tristan");
	}
	
	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		int randomizedRoshambo = (int) ((Math.random()*3));
		switch(randomizedRoshambo) {
			case 0:
				return Roshambo.ROCK;
			case 1:
				return Roshambo.PAPER;
			case 2:
				return Roshambo.SCISSORS;
		}
		return Roshambo.ROCK;
	}

}

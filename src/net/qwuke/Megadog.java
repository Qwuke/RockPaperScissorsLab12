package net.qwuke;

public class Megadog extends Player {

	Megadog(){
		super("Megadog");
	}
	
	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}

}

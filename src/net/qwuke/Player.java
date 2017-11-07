package net.qwuke;

public abstract class Player {
	
	String name;//Place holder for name of player
	public Player() {
	}
	public Player(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public abstract Roshambo generateRoshambo();
	
	
}

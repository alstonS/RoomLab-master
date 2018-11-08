package People;

import Game.Runner;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	String firstName, Inventory;
	int xLoc, yLoc, hp;


	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	public void setHitP(int hp)
	{
		this.hp = hp;
		if(hp <= 0 )
		{
			Runner.gameOff();
		}
	}
	public int getHitP()
	{
		return hp;
	}
	public void setInventory(String Inventory)
	{
		this.Inventory = Inventory;
	}



	public Person (String firstName, int xLoc, int yLoc, int hp, String Inventory)
	{
		this.firstName = firstName;

		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.Inventory = Inventory;
		this.hp = hp;
	}




}

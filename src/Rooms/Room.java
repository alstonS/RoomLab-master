package Rooms;

import People.Person;

public class Room {
	Person occupant;
	int xLoc,yLoc,totalHP;
	String Inventory;
	
	public Room(int x, int y, String Item, int HP)
	{
		xLoc = x;
		yLoc = y;
		Inventory = Item;
		totalHP = HP;
	}



	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
	}

	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
	
}

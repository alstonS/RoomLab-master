package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room
{

	public WinningRoom(int x, int y)
	{
		super(x, y);

	}

	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x) {

		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		if(Inventory.length() >= 4) {
			System.out.println("You found the winning room!");
			Runner.gameOff();
		}
		else
		{
			System.out.println("You found the winning room, but you need to collect more artifacts before you can advance.");
		}
	}
	

}

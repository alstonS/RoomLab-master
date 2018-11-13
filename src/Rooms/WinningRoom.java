//Alston Shi Period 2/3
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
		if(x.Inventory2[0] != null && x.Inventory2[1] != null && x.Inventory2[2] != null && x.Inventory2[3] != null  )
		{
			System.out.println("You found the winning room!");
			Runner.gameOff();
		}
		else
		{
			System.out.println("You found the winning room, but you need to collect more artifacts before you can advance.");
		}
	}
	

}

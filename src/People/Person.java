//Alston Shi Period 2/3
package People;

import Game.Runner;
import Items.Consumable;
import Items.Items;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
	String firstName;
	int xLoc, yLoc, hp;
	public Consumable[] Inventory = new Consumable[5];
	public Items[] Inventory2 = new Items[3];


	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}
	public int getLengthInventory2()
	{
		return Inventory2.length;
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
	public void printOutInventory()
	{
		String item = "";
		for(int i=0; i<Inventory.length; i++)
		{
			if(Inventory[i]== null)
			{
				item += "Empty";
			}
			else
			{
				item += Inventory[i];
			}
		}
		System.out.println(item);
	}
	public void printOutInventory2()
	{
		String item2 = "";
		for(int i=0; i<Inventory2.length; i++)
		{
			if(Inventory2[i]== null)
			{
				item2 += "Empty";
			}
			else
			{
				item2 += Inventory2[i];
			}
		}
		System.out.println(item2);
	}
	public void consume(int num)
	{
		Inventory[num].consume(this);
		Inventory[num]= null;
		
	}
	public void addConsume(Consumable consume)
	{
		for(int i = 0; i < Inventory.length; i++)
		{
			if(Inventory[i] == null)
			{
				Inventory[i]= consume;
				break;
			}
		}
	}
	public void use(int num)
	{
		Inventory2[num].use(this);
		Inventory2[num]=null;

	}
	public void addItem(Items item)
	{
		for(int i =0; i<Inventory2.length; i++)
		{
			if(Inventory2[i]==null)
			{
				Inventory2[i] = item;
				break;
			}

		}

	}

	public Person (String firstName, int xLoc, int yLoc, int hp)
	{
		this.firstName = firstName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.hp = hp;
	}




}

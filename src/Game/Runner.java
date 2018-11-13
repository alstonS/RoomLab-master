//Alston Shi Period 2/3
package Game;

import People.Person;
import Rooms.*;


import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	public static Person x;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome. You wake up in a unfamiliar place. You realize that you are in a haunted and spooky house. You must find a way out of here without getting killed by the ghost behind you!");
		System.out.println("The goal is to find all 5 items and reach the final/winning door");
		System.out.println("You may select the difficulty of this adventure. Type in 'easy/medium/hard' to select your desired difficulty.");
		Scanner input = new Scanner(System.in);
		double difficulty;
		while(true)
		{
			if(input.nextLine().toLowerCase().trim().equals("easy"))
			{
				difficulty = 1;
				break;
			}
			else if(input.nextLine().toLowerCase().trim().equals("medium"))
			{
				difficulty = 1.5;
				break;
			}
			else if(input.nextLine().toLowerCase().trim().equals("hard"))
			{
				difficulty = 2;
				break;
			}
			else
			{
				System.out.println("Enter a a difficulty(easy, medium, hard");
			}
		}

		int difficulty1 = (int) Math.round(difficulty);
		Room[][] building = new Room[6*difficulty1][6*difficulty1];



		int e = (int)(Math.random()*difficulty*2);

		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);

		building[0][0] = new StartingRoom(x,y);


		for(int a=0; a < 1; a++) //This is a room with the lock item for final door.(player will go into the room and have the item in his or her inventory).
		{
			while(building[x][y] != null)
			{
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if(building[x][y] == null) {
				building[x][y] = new lockItem(x, y);
			}

		}
		for(int a=0; a < 1; a++) //This is a room with the pumpkin item for final door.(player will go into the room and have the item in his or her inventory).
		{
			while(building[x][y] != null)
			{
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if(building[x][y] == null) {
				building[x][y] = new pumpkinItem(x, y);
			}

		}
		for(int a=0; a < 1; a++) //This is a room with the sword item for final door. (player will go into the room and have the item in his or her inventory).
		{
			while(building[x][y] != null)
			{
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if(building[x][y] == null) {
				building[x][y] = new swordItem(x, y);
			}

		}
		for(int a=0; a < 1; a++) //This is a room with the skull item for final door.(player will go into the room and have the item in his or her inventory).
		{
			while(building[x][y] != null)
			{
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if(building[x][y] == null) {
				building[x][y] = new skullItem(x, y);
			}

		}

		for(int a=0; a < e + 1; a++) //Fills the building with empty rooms depending on difficulty.
		{
			while(building[x][y] != null)
			{
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if(building[x][y] == null) {
				building[x][y] = new emptyRoom(x, y);
			}

		}
		for(int a = 0; a < e * 2; a++) //Fills the building with scary rooms depending on difficulty.
		{
			while (building[x][y] != null) {
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}

			if (building[x][y] == null) {
				building[x][y] = new scaryRoom(x, y);
			}
		}
		for(int a = 0; a < 1 ; a++) //One Winning room.
		{
			while (building[x][y] != null) {
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}
			if (building[x][y] == null) {
				building[x][y] = new WinningRoom(x, y);
			}
		}


		//Fill the building with normal rooms
		for (x = 0; x<building.length; x++)
		{
			for (y = 0; y < building[x].length; y++)
			{
				if(building[x][y] == null)
				building[x][y] = new Room(x,y);

			}
		}




/////////////////////////////////////////////////////////////////////////////////////////////////



	//Setup player 1 and the input scanner
		String[] Inventory = new String[4];
		Person player1 = new Person("FirstName", 0, 0,100);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose W, A, S, D, item [1-4], use [1-4]");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				System.out.println("Your current health is " + player1.getHitP() +".");
			}
			else {
				System.out.println("You have reached the limits of the map. Please choose a valid move.");
			}
			
			
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}
			case "d":
				if (p.getyLoc() < map[p.getyLoc()].length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
					return true;
				} else {
					return false;
				}

			case "a":
				if (p.getyLoc() > 0) {
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
					return true;
				}
			case "item 1": {
				if (p.Inventory2[0] == null)
					System.out.println("Select an item that you have");
				else {
					System.out.println("You have activated " + p.Inventory2[0] + " and added to the final key!");
					p.use(0);
				}
				return true;
			}
			case "item 2": {
				if (p.Inventory2[1] == null)
					System.out.println("Select an item that you have");
				else {
					System.out.println("You have activated " + p.Inventory2[1] + " and added to the final key!");
					p.use(1);
				}
				return true;
			}
			case "item 3": {
				if (p.Inventory2[2] == null)
					System.out.println("Select an item that you have");
				else {
					System.out.println("You have activated " + p.Inventory2[2] + " and added to the final key!");
					p.use(2);
				}
				return true;
			}
			case "item 4": {
				if (p.Inventory2[3] == null)
					System.out.println("Select an item that you have");
				else {
					System.out.println("You have activated " + p.Inventory2[3] + " and added to the final key!");
					p.use(3);
				}
				return true;
			}
			case "consume 1":
			{
				if(p.Inventory[0]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[0]+ " and gained 10 health!");
					p.consume(0);
				}

			}
			case "consume 2":
			{
				if(p.Inventory[1]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[1]+ " and gained 10 health!");
					p.consume(1);
				}

			}
			case "consume 3":
			{
				if(p.Inventory[2]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[2]+ " and gained 10 health!");
					p.consume(2);
				}


			}
			case "consume 4":
			{
				if(p.Inventory[3]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[3]+ " and gained 10 health!");
					p.consume(3);
				}

			}
			case "consume 5":
			{
				if(p.Inventory[4]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[4]+ " and gained 10 health!");
					p.consume(4);
				}

			}
			case "consume 6":
			{
				if(p.Inventory[5]==null)
					System.out.println("Select an consumable that you have");
				else
				{
					System.out.println("You ate " + p.Inventory[5]+ " and gained 10 health!");
					p.consume(5);
				}

			}
			default:
				break;
					
		}
		return true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	


}

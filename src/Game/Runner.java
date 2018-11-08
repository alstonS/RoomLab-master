package Game;

import People.Person;
import Rooms.*;


import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome. You wake up in a unfamiliar place. You realize that you are in a haunted and spooky house. You must find a way out of here without getting killed by the ghost behind you!");
		System.out.println("The goal is to find all 5 items and reach the final/winning door");
		Scanner input = new Scanner(System.in);

		System.out.println("You may select the difficulty of this adventure. Type in 'easy/medium/hard' to select your desired difficulty.");
		int difficulty;
		while(true)
		{
			if(input.nextLine().toLowerCase().trim().equals("easy"))
			{
				difficulty = 1;
				break;
			}
			else if(input.nextLine().toLowerCase().trim().equals("medium"))
			{
				difficulty = 2;
				break;
			}
			else if(input.nextLine().toLowerCase().trim().equals("hard"))
			{
				difficulty = 3;
				break;
			}
			else
			{
				System.out.println("Enter a a difficulty(easy, medium, hard");
			}
		}
		Room[][] building = new Room[4*difficulty][4*difficulty];
		int e = (int)(Math.random()*difficulty*2);

		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);




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

		for(int a=0; a < e; a++) //Fills the building with empty rooms depending on difficulty.
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
		for(int a = 0; a < e + 1; a++) //Fills the building with scary rooms depending on difficulty.
		{
			while (building[x][y] != null) {
				x = (int) (Math.random() * building.length);
				y = (int) (Math.random() * building.length);
			}
			if (building[x][y] == null) {
				building[x][y] = new scaryRoom(x, y);
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
		Person player1 = new Person("FirstName", 0, 0,0, "");
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose W, A, S, D)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
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
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
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

package Rooms;

import People.Person;


public class StartingRoom extends Room {
    public StartingRoom(int x, int y, String Inventory, int totalHP)
    {
        super(x,y, Inventory, totalHP);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("This is where you wake up.");
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


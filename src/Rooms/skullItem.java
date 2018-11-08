package Rooms;

import People.Person;


public class skullItem extends Room {
    public skullItem(int x, int y)
    {
        super(x,y);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("Congrats you have found the Skull item(one of the 4 items needed to win the game).");
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


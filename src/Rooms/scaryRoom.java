package Rooms;

import People.Person;




public class scaryRoom extends Room{
    public scaryRoom(int x, int y)
    {
        super(x,y);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        System.out.println("BOO! Unlucky you. You just stepped into a haunted room. You just lost 20 Health.");
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



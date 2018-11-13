//Alston Shi Period 2/3
package Rooms;

import Items.Pumpkin;
import People.Person;

public class pumpkinItem extends Room{
    public pumpkinItem(int x, int y)
    {
        super(x,y);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        x.addItem(new Pumpkin());
        System.out.println("Congrats you have found the pumpkin(one of the 4 items needed to win the game).");
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
    @Override
    public String toString()
    {
        if(occupant ==null){
            return ("PT");

        }
        else
            return("P");

    }

}

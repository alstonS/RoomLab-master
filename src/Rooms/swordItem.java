package Rooms;
//Alston Shi Period 2/3
import Items.Sword;
import People.Person;

public class swordItem extends Room{
    public swordItem(int x, int y)
    {
        super(x,y );

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        x.addItem(new Sword());
        System.out.println("Congrats you have found the sword(one of the 4 items needed to win the game).");
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
            return ("SWT");

        }
        else
            return("P");

    }

}


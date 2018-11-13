package Rooms;
//Alston Shi Period 2/3
import People.Person;


public class StartingRoom extends Room {
    public StartingRoom(int x, int y)
    {
        super(x,y);

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
    @Override
    public String toString()
    {
        if(occupant ==null){
            return ("SR");

        }
        else
            return("P");

    }

}


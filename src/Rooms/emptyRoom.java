package Rooms;
import Game.Runner;
import People.Person;

public class emptyRoom extends Room{



    public emptyRoom(int x, int y, String Inventory, int totalHP)
    {
        super(x,y, Inventory, totalHP);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        if(Math.random()>.5) {
            System.out.println("Haha, you entered a room with nothing in it! You have wasted time here. You do find yourself an apple and you gain 10 health.");
            x.setHitP(x.getHitP()+10);
        }
        else
        {
            System.out.println("You entered an empty room, but the lights were off and you tripped yourself. You lose 5 health");
            x.setHitP(x.getHitP()-5);
        }
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

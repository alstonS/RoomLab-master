package Rooms;
import Game.Runner;
import Items.CandyCorn;
import People.Person;

public class emptyRoom extends Room{



    public emptyRoom(int x, int y)
    {
        super(x,y);

    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterRoom(Person x)
    {
        if(Math.random()>.5) {
            System.out.println("Haha, you entered a room with nothing in it! You have wasted time here. You do find yourself candy corn and you can consume it for 10 health.");
            x.addConsume(new CandyCorn());
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

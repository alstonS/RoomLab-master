package Rooms;

import People.Person;
import Game.Runner;

public class CandyItem extends Room{


    public CandyItem(int x, int y)
    {
        super(x,y);

    }


    public void enterRoom(Person x)
    {
        System.out.println("You enter a plain old room");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void leaveRoom(Person x)
    {
        occupant = null;
    }

}

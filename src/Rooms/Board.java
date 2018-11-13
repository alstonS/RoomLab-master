//Alston Shi Period 2/3
package Rooms;

import Items.Consumable;
import Items.Items;
import Rooms.Room;


public class Board {

    public Room[][] map;
    public Board(Room[][] map)
    {
        this.map = map;

    }
    public Board(int row, int column)
    {
        this.map = new Room[row][column];
    }

    public void addRoom(Room room, int row, int col)
    {

        map[row][col] = room;
    }


    @Override
    public String toString()
    {
        String mapBoard = "\n";
        for(int i = 0; i < map.length; i++);
        {
            for(int j = 0; j < map[i].length; j++)
            {
                mapBoard += "{ " + map[i][j] + " }";


            }
            mapBoard += "\n";
        }
            mapBoard += "Legend \nP=You \neR=EmptyRoom \nLT=LockItemRoom \nPT=PumpkinItemRoom \nSKT=SkullItemRoom \nSWT=SwordItemRoom \nSR=ScaryRoom ";
            return(mapBoard);
    }
}

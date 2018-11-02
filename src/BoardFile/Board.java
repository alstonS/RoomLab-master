package BoardFile;


import Rooms.Room;

public class Board {

private Room[][] map;
public Board(Room[][] Map)
{
    this.map = map;


}
public Board(int height, int width)
{

    map = new Room[height][width];

}
public void addRoom(Room room, int row, int col)
{

    map[row][col] = room;
}

}

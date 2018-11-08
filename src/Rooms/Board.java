package Rooms;



public class Board {

    private Room[][] map;
    public Board(Room[][] map)
    {
        this.map = map;

    }
    public Board(int x, int y)
    {
        this.map = new Room[x][y];
    }

    public void addRoom(Room room, int row, int col)
    {

        map[row][col] = room;
    }

}

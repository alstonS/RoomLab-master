package People;

public class GhostChaser extends Person {
private String firstName;
private int xLoc;
private int yLoc;
private int hp;
public GhostChaser(String firstName, int xLoc, int yLoc, int hp, String Inventory)
{
    super(firstName, xLoc, yLoc, hp, Inventory);
    this.firstName=firstName;
    this.xLoc = xLoc;
    this.yLoc = yLoc;
    this.hp = hp;
}

}

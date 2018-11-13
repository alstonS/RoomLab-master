package Items;
import People.Person;
public class CandyCorn implements Consumable{
    public void consume(Person x)
    {
        x.setHitP(x.getHitP()+ 10);
        System.out.println("You are healed 10 hit points. You found candy corn on the floor.");
    }
    public String toString()
    {
        return "Candy Corn";
    }
}

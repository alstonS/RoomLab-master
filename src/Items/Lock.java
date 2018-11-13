package Items;
import People.Person;
public class Lock implements Items{
    public void use(Person x)
    {
        System.out.println("Congrats you have found a lock. This is one of the 4 items you need to collect inorder to exit the house");
        boolean Lock = true;
    }

}

//strategy design patterm

interface SwimBehaviour
{
    void swim();
}
interface FlyBehaviour
{
    void fly();
}
class CanSwim implements SwimBehaviour
{
    public void swim()
    {
        System.out.println("Can Swim");
    }

}
class CannotSwim implements SwimBehaviour
{
    public void swim()
    {
        System.out.println("Cannot Swim");
    }

}
abstract class Animal{      //hum nhi cahahte animal ka object bne islyi abstrat or yaha abstrat methods islti nhi h kyuki humnhe wo har baar phir class me likhna padta

    private SwimBehaviour swimBehaviour;
    
    public void setSwimBehaviour(SwimBehaviour swimBehaviour)
    {
        this.swimBehaviour=swimBehaviour;
    }
    public void performSwim()
    {
        this.swimBehaviour.swim();
    }
    public void eat()
    {
        System.out.println("Eating...");
    }
    public void drink()
    {
        System.out.println("Drinking...");
    }
    public void sleep()
    {
        System.out.println("Sleeping...");
    }
    abstract public void show();
}

class Dog extends Animal
{
    public void show()
    {
        System.out.println("Kutta");
    }

}
class Cat extends Animal
{
    public void show()
    {
        System.out.println("Billi");
    }
}

public class StrategyDemo
{
    public static void main(String[] args) {

        Dog d=new Dog();
        d.setSwimBehaviour(new CanSwim());
        d.show();
        d.performSwim();
        Cat c=new Cat();
        c.setSwimBehaviour(new CannotSwim());
        c.show();
        c.performSwim();
        c.setSwimBehaviour(new CanSwim());
        c.performSwim();
        
        
    }
}
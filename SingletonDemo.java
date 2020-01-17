class Singleton
{
                            // Singleton()
                            // {
                            //     this(10);
                            // }
                            // Singleton(int x)
                            // {
                            //     System.out.print(x);
                            // }
    static Singleton obj;
    private Singleton()
    {
        super(); 
    }
    public static Singleton getSingleton()
    {
        if(obj==null)
        {
            obj=new Singleton();
        }
        return obj;
    }
}
public class SingletonDemo
{
        public static void main(String... args) {  //... is var args
        Singleton obj=Singleton.getSingleton();
        Singleton obj1=Singleton.getSingleton();
        if(obj==obj1) //check ref
        {
            System.out.println("True");

        }
        else
        {
            System.out.println("False"); 
        }
    }
}
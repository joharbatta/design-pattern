import java.util.*;

class Sender{

    private List<Subscriber> subs=new ArrayList<>();    //total susbcribers ki list

    private String message;

    public void subscribe(Subscriber s)  // add ho rha list ch obj subscriber
    {
        subs.add(s);
    }
    public void unsubscribe(Subscriber s)
    {
        subs.remove(s);
    }

    public void sendMessage()
    {
        for(Subscriber s:subs)
        {
            s.update(this.message);
        }

    }
    public void publishMessage(String message)  //isch apa message pass krya new
    {
        this.message=message;
        sendMessage();
    }
}
// Sender ytGaming=new Sender("yt gaming"); //subscriber particular channel
// Subscriber s1=new Subscriber("A");
// s1.subscribeSender(ytGaming);
class Subscriber{

    private String name;
    private Sender sd; //is ref se ptta lagega ki sub kisko kra

    Subscriber(String name)
    {
        this.name=name;
    }
    public void subscribeSender(Sender sd)   //btaega kisko krna
    {
        this.sd=sd; //is channel ko sub kr chuke hai
        this.sd.subscribe(this);  //subscriber jo h wo apni list me obj add krdega
    }
    public void update(String mess) 
    {
        System.out.println(this.name+": Message Published "+mess);
    }

}

public class ObserverDemo{
    public static void main(String... x) {

        Sender sd=new Sender();

        Subscriber s1=new Subscriber("A");
        Subscriber s2=new Subscriber("B");
        Subscriber s3=new Subscriber("C");
// bidirectional relation
        sd.subscribe(s1); //sender ch subsciber di info
        sd.subscribe(s2);
        sd.subscribe(s2);

        //eh islyi comment kri bcz oh ek upper hi krta apa link
        // s1.subscribeSender(sd);  //subscriber de andr sender di info  
        // s2.subscribeSender(sd);
        // s3.subscribeSender(sd);

        sd.publishMessage("Hello Babes!");
        sd.publishMessage("NEW VIDEO!");
          
        
    }

}
import java.util.*;
//adaptive design pattern    VGA CABLE-->-HDMIADAPTER---->HDMI PORT

//Task--> projector display
// displayscreen--->HDMI-->Projector
// we used interface as without when we got new version we need to change code acc to that but as we implements inteface in that class so it has to be same function i.e is in interface
//HDMI just make obj in main class are we are good to go so it sAVES TIME IT IS LOOSE COUPLING 
//this provides flexibility as in future if hdmi version comes we dont need to change code again //loose coupling easy to maintain
//as if another developer made hdmithree cable just implement inteface good to go no need to call in display screen and all all good

// vga cable in hdmi port we use adapter 
interface HDMI{    
    void display();
}
interface VGA{
    void show();
}
// class HDMICable implements HDMI
// {
//     public void display()
//     {
//         System.out.println("Display Content VER 1");
//     }
// }
class VGACable implements VGA{
    public void show()
    {
        System.out.println("VGA VER 1 Content displayed");
    }
}

class HDMIAdapter implements HDMI{    //vga to hdmi adapter

    private VGACable cable=new VGACable(); //vga cable obj
    public void display()  //wrapped in HDMI 
    {
        cable.show(); //vga ka show

    }
} 
// class HDMItwoCable implements HDMI
// {
//     public void display()
//     {
//         System.out.println("ver 2 CABLE WOHI SOCH NAYE");
//     }
// }
class DisplayScreen    //display
{
    private HDMI cable;

    public void setCable(HDMI cable)
    {
        this.cable=cable;
    }
    public void project()
    {
        this.cable.display();
    }

}
public class AdapterDemo
{
    public static void main(String[] args) {
        DisplayScreen ds=new DisplayScreen();
        HDMIAdapter cable=new HDMIAdapter();
        // VGACable cable=new VGACable();
        ds.setCable(cable);
        ds.project();
        // HDMICable hCable=new HDMICable();
        // HDMItwoCable hCable2=new HDMItwoCable();
        // ds.setCable(hCable);
        // ds.project();
        // ds.setCable(hCable2);
        // ds.project();

    }
}


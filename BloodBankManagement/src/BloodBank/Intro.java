package BloodBank;

import javax.swing.*;
import java.awt.*;

public class Intro extends JFrame {
    public Intro(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./Assests/intro.gif"));
        Image i2=i1.getImage().getScaledInstance(600,350, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,350);
        add(img);



        setSize(600,350);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
        try{
            Thread.sleep(8700);
            setVisible(false);
            new menu();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Intro();
    }
}

package BloodBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class menu extends JFrame {
    JButton BloodAvail,BloodReq,BloodDonate;

    public menu(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./Assests/hosp.png"));
        Image i2=i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel img=new JLabel(i3);
        img.setBounds(0,0,800,700);
        add(img);

        BloodAvail=new JButton("Check Availability");
        BloodAvail.setBounds(300,295,150,25);
      BloodAvail.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                            new show();
                                            setVisible(false);
                                       }
                                   });
              img.add(BloodAvail);

        BloodReq=new JButton("Blood Request");
        BloodReq.setBounds(300,387,150,25);
      BloodReq.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                        new del();
                                        setVisible(false);
                                     }
                                 });
              img.add(BloodReq);


        BloodDonate=new JButton("Blood Donate");
        BloodDonate.setBounds(300,478,150,25);
        BloodDonate.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                                new Add();
                                                setVisible(false);
                                          }
                                      });

                img.add(BloodDonate);



        setSize(800,700);
        setLocation(450,70);
        setLayout(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        new menu();
    }
}

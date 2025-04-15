package BloodBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JFrame  implements  ActionListener{
    JLabel n,id,qn,ty;
    JTextField na,uid,uqn,uty;
    JButton sub,back;

    public Add(){
        JLabel h=new JLabel("Blood Bank Management");
        h.setBounds(300,10,600,40);
        h.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(h);

        n=new JLabel("Name");
        n.setBounds(150,120,100,25);
        n.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(n);

        na=new JTextField();
        na.setBounds(320,120,100,25);
        //na.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(na);

        id=new JLabel("user id");
        id.setBounds(150,180,100,25);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        uid=new JTextField();
        uid.setBounds(320,180,100,25);
        //na.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(uid);

        qn=new JLabel("Quantity");
        qn.setBounds(150,240,100,25);
        qn.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(qn);

        uqn=new JTextField();
        uqn.setBounds(320,240,100,25);
        //na.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(uqn);

        ty=new JLabel("Type");
        ty.setBounds(150,300,100,25);
        ty.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(ty);
        uty=new JTextField();
        uty.setBounds(320,300,100,25);
        //na.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(uty);

        sub=new JButton("Submit");
        sub.setBounds(200,450,100,25);
       sub.addActionListener(this);
        add(sub);

        back=new JButton("Back");
        back.setBounds(400,450,100,25);
        back.addActionListener(this);
        add(back);






        setSize(900,600);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub){
            String  name,id,type,quan;
            name=na.getText();
            id=uid.getText();
            type=uty.getText();
            quan=uqn.getText();
            try{
                conn c=new conn();
                String q2="insert into Details values('"+id+"','"+type+"','"+name+"','"+quan+"')";
                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new menu();

            }
            catch (Exception ev){
                ev.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new menu();
        }
    }

    public static void main(String[] args) {
        new Add();
    }


}

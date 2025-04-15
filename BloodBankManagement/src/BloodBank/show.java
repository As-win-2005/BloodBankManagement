package BloodBank;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class show extends JFrame implements ActionListener {
    JButton back;
    public show(){

        JTable t=new JTable();
        try{

            conn c=new conn();
            String q1="Select * from  Details";
            ResultSet r=c.s.executeQuery(q1);
            t.setModel(DbUtils.resultSetToTableModel(r));


            }
        catch (Exception eb){
            eb.printStackTrace();

            }
        JScrollPane jp = new JScrollPane(t);
        jp.setBounds(0,100,900,250);
        add(jp);

        JLabel h=new JLabel("Blood Avalibility");
        h.setBounds(350,10,600,40);
        h.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(h);

        back=new JButton("Back");
        back.setBounds(400,350,100,20);
        back.addActionListener(this);
        add(back);


        setSize(900,450);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new menu();
        }
    }

    public static void main(String[] args) {
        new show();
    }
}

package BloodBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class del extends JFrame implements ActionListener {
    JButton back;
    Choice c;
    //JTextField typ;

    public del(){
        JLabel h=new JLabel("Blood Bank Management");
        h.setBounds(300,10,600,40);
        h.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(h);

        JLabel ty=new JLabel("Choose Blood Type");
        ty.setBounds(250,100,200,25);
        ty.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(ty);



        c=new Choice();
        c.setBounds(460,105,100,20);
        add(c);

        try{
            conn co=new conn();
            ResultSet re=co.s.executeQuery("Select * from Details");
            while (re.next()){
                c.add(re.getString("BType"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel labelName = new JLabel("Name");
        labelName.setBounds(250,150,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(460,150,100,30);
        add(textName);


        JLabel labelemail = new JLabel("user id");
        labelemail.setBounds(250,200,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelemail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(460,200,100,30);
        add(textEmail);

        JLabel bt = new JLabel("Blood  Type");
        bt.setBounds(250,250,100,30);
        bt.setFont(new Font("Tahoma", Font.BOLD,15));
        add(bt);

        JLabel btt = new JLabel();
        btt.setBounds(460,250,100,30);
        add(btt);

        JLabel qn = new JLabel("Quantity avail.");
        qn.setBounds(250,300,100,30);
        qn.setFont(new Font("Tahoma", Font.BOLD,15));
        add(qn);

        JLabel qnn = new JLabel();
        qnn.setBounds(460,300,100,30);
        add(qnn);

        try {
            conn coo = new conn();
            ResultSet resultSet = coo.s.executeQuery("select * from Details where BType = '"+c.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("Dname"));

                textEmail.setText(resultSet.getString("Did"));
                btt.setText(resultSet.getString("BType"));

               qnn.setText(resultSet.getString("quan"));



            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn coo = new conn();
                    ResultSet resultSet = coo.s.executeQuery("select * from Details where BType= '"+c.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("Dname"));

                        textEmail.setText(resultSet.getString("Did"));
                        btt.setText(resultSet.getString("BType"));

                        qnn.setText(resultSet.getString("quan"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        back=new JButton("Back");
        back.setBounds(375,400,100,20);
        back.addActionListener(this);
        add(back);

                setSize(900,600);
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
        new del();
    }
}

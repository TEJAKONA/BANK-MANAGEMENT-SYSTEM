package bank.management.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Fash_Cash extends JFrame implements ActionListener
{



        String pin;

        JButton b1,b2,b3,b4,b5,b6,b7;

        Fash_Cash(String pin)
        {

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,18));
        l1.setBounds(355,150,400,35);
        img1.add(l1);


        b1=new JButton("Rs.100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,230,155,30);
        b1.addActionListener(this);
        img1.add(b1);

        b2=new JButton("Rs.1000");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(340,265,155,30);
        b2.addActionListener(this);
        img1.add(b2);

        b3=new JButton("Rs.5000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,300,155,30);
        b3.addActionListener(this);
        img1.add(b3);

        b4=new JButton("Rs.500");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(560,230,155,30);
        b4.addActionListener(this);
        img1.add(b4);

        b5=new JButton("Rs.2000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(560,265,155,30);
        b5.addActionListener(this);
        img1.add(b5);

        b6=new JButton("Rs.10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(560,300,155,30);
        b6.addActionListener(this);
        img1.add(b6);

        b7=new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(560,335,155,30);
        b7.addActionListener(this);
        img1.add(b7);

        setLayout(null);
        setSize(1450,680);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b7)
        {
            setVisible(false);
            new main_class(pin);
        }
        else
        {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Con c=new Con();
            Date date=new Date();
            try
            {
                int balance=0;
                ResultSet rs=c.statement.executeQuery("select * from bank where pin='"+pin+"'");

                while (rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                String num="17";

                if(e.getSource()!=b7 && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"'");
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited Successfully");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            setVisible(false);
            new main_class(pin);
        }

    }

    public static void main(String[] args)
    {
        new Fash_Cash("");
    }

}

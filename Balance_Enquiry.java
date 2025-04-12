package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_Enquiry extends JFrame implements ActionListener
{
    String pin;
    JLabel l2;

    JButton back;

    Balance_Enquiry(String pin)
    {
        this.pin=pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("Your Current Balance is Rs.");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(380,150,400,35);
        img1.add(l1);

        l2=new JLabel("");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(380,180,400,35);
        img1.add(l2);

        back =new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65,125,128));
        back.setBounds(590,302,120,25);
        back.addActionListener(this);
        img1.add(back);

        int balance=0;

        try
        {
            Con c=new Con();
            ResultSet rs=c.statement.executeQuery("select * from bank where pin='"+pin+"'");

            while (rs.next())
            {
                if(rs.getString("type").trim().equalsIgnoreCase("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }

            Math.abs(balance);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        l2.setText(""+balance);


        setLayout(null);
        setSize(1450,680);
        setLocation(0,0);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new main_class(pin);

    }

    public static void main(String[] args)
    {
        new Balance_Enquiry("");

    }

}

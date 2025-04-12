package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener
{

    String pin;

    JButton b1,b2,b3,b4,b5,b6,b7;

    main_class(String pin)
    {
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("PLEASE SELECT YOUR TRANSACTION");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,18));
        l1.setBounds(355,150,400,35);
        img1.add(l1);


        b1=new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,230,155,30);
        b1.addActionListener(this);
        img1.add(b1);

        b2=new JButton("FAST CASH");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(340,265,155,30);
        b2.addActionListener(this);
        img1.add(b2);

        b3=new JButton("PIN CHANGE");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,300,155,30);
        b3.addActionListener(this);
        img1.add(b3);

        b4=new JButton("CASH WITHDRAWAL");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(560,230,155,30);
        b4.addActionListener(this);
        img1.add(b4);

        b5=new JButton("MINI STATEMENT");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(560,265,155,30);
        b5.addActionListener(this);
        img1.add(b5);

        b6=new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(560,300,155,30);
        b6.addActionListener(this);
        img1.add(b6);

        b7=new JButton("EXIT");
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
        try
        {
            if(e.getSource()==b1)
            {
                new Deposit(pin);
                setVisible(false);
            }
            else if(e.getSource()==b7)
            {
                System.exit(0);
            }
            else if (e.getSource()==b4)
            {
                new Withdrawal(pin);
                setVisible(false);
            } else if (e.getSource()==b6)
            {
                new Balance_Enquiry(pin);
                setVisible(false);
            } else if (e.getSource()==b2)
            {
                new Fash_Cash(pin);
                setVisible(false);
            }
            else if(e.getSource()==b3)
            {
                setVisible(false);
                new Change_PIN(pin);
            } else if (e.getSource()==b5)
            {
             setVisible(false);
             new Mini_Statement(pin);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new main_class("");

    }


}

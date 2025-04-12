package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener
{

    JLabel l1,l2,l3;

    JTextField tf;

    JPasswordField pass;

    JButton b1,b2,b3;


    Login()
    {
        super("BANK MANAGEMENT");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i12=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i13=new ImageIcon(i12);
        JLabel img1=new JLabel(i13);
        img1.setBounds(300,10,100,100);
        add(img1);

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image i21=i2.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(i21);
        JLabel img2=new JLabel(i22);
        img2.setBounds(550,265,100,100);
        add(img2);



        l1=new JLabel("WELCOME TO ATM");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("AvantGarde",Font.BOLD,38));
        l1.setBounds(200,125,450,38);
        add(l1);


        l2=new JLabel("Card No :");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Ralway",Font.BOLD,28));
        l2.setBounds(100,175,450,40);
        add(l2);

        tf=new JTextField(15);
        tf.setFont(new Font("Arial",Font.BOLD,14));
        tf.setBounds(245,182,230,30);
        add(tf);


        l3=new JLabel("PIN :");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Ralway",Font.BOLD,28));
        l3.setBounds(162,230,450,40);
        add(l3);

        pass=new JPasswordField(15);
        pass.setFont(new Font("Arial",Font.BOLD,14));
        pass.setBounds(245,238,230,30);
        add(pass);

        b1=new JButton("SIGN IN");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBounds(243,280,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CLEAR");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(376,280,100,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("SIGN UP");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(243,325,233,30);
        b3.addActionListener(this);
        add(b3);







        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image i31=i3.getImage().getScaledInstance(720,400,Image.SCALE_DEFAULT);
        ImageIcon i32=new ImageIcon(i31);
        JLabel img3=new JLabel(i32);
        img3.setBounds(0,0,720,400);
        add(img3);

        setLayout(null);
        setSize(720,400);
        setLocation(450,200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource()==b1)
            {
                Con c=new Con();
                String cardno=tf.getText();
                String pin=pass.getText();
                String q="select * from login where card_number='"+cardno+"' and pin='"+pin+"'";
                ResultSet rs=c.statement.executeQuery(q);

                if(rs.next())
                {
                    new main_class(pin);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            else if(e.getSource()==b2)
            {
                tf.setText("");
                pass.setText("");
            }
            else if(e.getSource()==b3)
            {
                new SignUp();
                setVisible(false);
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new Login();
    }
}
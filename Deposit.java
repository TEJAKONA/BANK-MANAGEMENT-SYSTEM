package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener
{
    String pin;

    JTextField textDepo;

    JButton depo,back;

    Deposit(String pin)
    {
        this.pin=pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(390,150,400,35);
        img1.add(l1);

        textDepo=new JTextField();
        textDepo.setForeground(Color.WHITE);
        textDepo.setBackground(new Color(65,125,128));
        textDepo.setFont(new Font("Raleway",Font.BOLD,14));
        textDepo.setBounds(390,190,280,20);
        img1.add(textDepo);


        depo=new JButton("DEPOSIT");
        depo.setForeground(Color.WHITE);
        depo.setBackground(new Color(65,125,128));
        depo.setBounds(590,302,120,25);
        depo.addActionListener(this);
        img1.add(depo);

        back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65,125,128));
        back.setBounds(590,337,120,25);
        back.addActionListener(this);
        img1.add(back);

        setLayout(null);
        setSize(1450,680);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        String amount = textDepo.getText();
        Date date = new Date();


        try
        {

            if(e.getSource()==depo)
            {
                if (amount.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter the amount yoy want to deposit");
                }
                else
                {
                    Con c=new Con();
                    String query="INSERT INTO bank(pin,date,type,amount) values (?,?,?,?)";

                    PreparedStatement pstmt=c.connection.prepareStatement(query);

                    pstmt.setString(1,pin);
                    pstmt.setString(2, String.valueOf(date));
                    pstmt.setString(3,"Deposit");
                    pstmt.setString(4,amount);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited Succesfully");
                    new main_class(pin);

                }
            }
            else if(e.getSource()==back)
            {
                new main_class(pin);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Deposit("");
    }


}

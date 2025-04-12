

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener
{
    String formno;

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;

    SignUp3(String formno)
    {
        this.formno=formno;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i12 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel img1 = new JLabel(i13);
        img1.setBounds(30, 10, 100, 100);
        add(img1);

        JLabel l1 = new JLabel("Page 3 ");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(340, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details ");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(300, 50, 600, 40);
        add(l2);

        JLabel laccounttype = new JLabel("Account Type:");
        laccounttype.setFont(new Font("Raleway", Font.BOLD, 14));
        laccounttype.setBounds(150, 130, 300, 30);
        add(laccounttype);

        r1 = new JRadioButton("Savings Account");
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 10));
        r1.setBounds(150, 160, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 10));
        r2.setBounds(300, 160, 200, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.BOLD, 10));
        r3.setBounds(150, 190, 150, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(new Color(222, 255, 228));
        r4.setFont(new Font("Raleway", Font.BOLD, 10));
        r4.setBounds(300, 190, 200, 20);
        add(r4);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JLabel l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.setBounds(150, 230, 300, 30);
        add(l3);

        JLabel l4 = new JLabel("(Your 16-digit Card Number)");
        l4.setFont(new Font("Raleway", Font.BOLD, 10));
        l4.setBounds(150, 250, 300, 30);
        add(l4);

        JLabel l5 = new JLabel("XXXX-XXXX-0907");
        l5.setFont(new Font("Raleway", Font.BOLD, 14));
        l5.setBounds(330, 230, 350, 30);
        add(l5);

        JLabel l6 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l6.setFont(new Font("Raleway", Font.BOLD, 10));
        l6.setBounds(330, 250, 300, 30);
        add(l6);

        JLabel l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 14));
        l7.setBounds(150, 290, 300, 30);
        add(l7);

        JLabel l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 14));
        l8.setBounds(330, 290, 350, 30);
        add(l8);

        JLabel l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 10));
        l9.setBounds(150, 310, 300, 30);
        add(l9);

        JLabel l10 = new JLabel("Service Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 14));
        l10.setBounds(150, 350, 300, 30);
        add(l10);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(222, 255, 228));
        c1.setFont(new Font("Raleway", Font.BOLD, 10));
        c1.setBounds(150, 380, 150, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(222, 255, 228));
        c2.setFont(new Font("Raleway", Font.BOLD, 10));
        c2.setBounds(330, 380, 150, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(222, 255, 228));
        c3.setFont(new Font("Raleway", Font.BOLD, 10));
        c3.setBounds(150, 410, 150, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(222, 255, 228));
        c4.setFont(new Font("Raleway", Font.BOLD, 10));
        c4.setBounds(330, 410, 150, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(222, 255, 228));
        c5.setFont(new Font("Raleway", Font.BOLD, 10));
        c5.setBounds(150, 440, 150, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(222, 255, 228));
        c6.setFont(new Font("Raleway", Font.BOLD, 10));
        c6.setBounds(330, 440, 150, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setBackground(new Color(222, 255, 228));
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(150, 470, 500, 30);
        add(c7);

        JLabel lfn = new JLabel("Form No : " + formno);
        lfn.setFont(new Font("Raleway", Font.BOLD, 14));
        lfn.setBounds(500, 10, 150, 30);
        add(lfn);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 520, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400, 520, 100, 30);
        cancel.addActionListener(this);
        add(cancel);




        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(700, 600);
        setLocation(450, 50);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String accounttype = r1.isSelected() ? "Savings Account" : r2.isSelected() ? "Fixed Deposit Account" : r3.isSelected() ? "Current Account":r4.isSelected() ? "Recurring deposit Account" : "";

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        StringBuilder fac = new StringBuilder();
        if (c1.isSelected()) fac.append("ATM CARD");
        if (c2.isSelected()) fac.append(" , Internet Banking");
        if (c3.isSelected()) fac.append(" , Mobile Banking");
        if (c4.isSelected()) fac.append(" , EMAIL Alerts");
        if (c5.isSelected()) fac.append(" , Cheque Book");
        if (c6.isSelected()) fac.append(" , E-Statement");
        String service_required = fac.toString();



        try {
            if (e.getSource()==submit)
            {
                if (accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else
                {
                    Con c=new Con();

                    String query = "INSERT INTO signupthree(form_no,account_type, card_no,pin, service_required) VALUES (?, ?, ?, ?,?)";
                    PreparedStatement pstmt = c.connection.prepareStatement(query);

                    pstmt.setString(1, formno);
                    pstmt.setString(2, accounttype);
                    pstmt.setString(3,cardno);
                    pstmt.setString(4, pin);
                    pstmt.setString(5, service_required);
                    pstmt.executeUpdate();


                    String q = "INSERT INTO login(card_number,pin) VALUES (?, ?)";
                    PreparedStatement p = c.connection.prepareStatement(q);

                    p.setString(1, cardno);
                    p.setString(2, pin);
                    p.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    new Deposit(pin);
                    setVisible(false);
                }
            }
            else if (e.getSource()==cancel)
            {
                System.exit(0);
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }


    public static void main(String[] args)
    {
       new SignUp3("");
    }

}

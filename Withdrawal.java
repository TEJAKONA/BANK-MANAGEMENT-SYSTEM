
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener
{


    String pin;

    JTextField textWithdrawal;

    JButton withdraw,back;

    Withdrawal(String pin)
    {
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("MINIMUM WITHDRAWAL AMOUNT IS RS.10000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(380,150,400,35);
        img1.add(l1);

        JLabel l2=new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(380,180,400,35);
        img1.add(l2);

        textWithdrawal=new JTextField();
        textWithdrawal.setForeground(Color.WHITE);
        textWithdrawal.setBackground(new Color(65,125,128));
        textWithdrawal.setFont(new Font("Raleway",Font.BOLD,14));
        textWithdrawal.setBounds(380,220,300,20);
        img1.add(textWithdrawal);



        withdraw =new JButton("WITHDRAWAL");
        withdraw.setForeground(Color.WHITE);
        withdraw.setBackground(new Color(65,125,128));
        withdraw.setBounds(590,302,120,25);
        withdraw.addActionListener(this);
        img1.add(withdraw);

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

        String amount=textWithdrawal.getText();
        Date date=new Date();
        try
        {
            if(e.getSource()==withdraw) {
                if (textWithdrawal.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "PLease Enter the Amount");
                } else {
                    Con c = new Con();
                    ResultSet rs = c.statement.executeQuery("select * from bank where pin='" + pin + "'");
                    int balance = 0;

                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdrawal','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + amount + " Debited Successfully");
                    setVisible(false);
                    new main_class(pin);
                }
            }
            else if(e.getSource()==back)
            {
                setVisible(false);
                new main_class(pin);

            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args)
    {
        new Withdrawal("");
    }

}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Change_PIN extends JFrame implements ActionListener
{
    String pin;

    JButton change,back;

    JPasswordField tf1,tf2;

    Change_PIN(String pin)
    {
        this.pin=pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,620,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img1 = new JLabel(i3);
        img1.setBounds(0,0,1300,680);
        add(img1);

        JLabel l1=new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setBounds(360,150,400,35);
        img1.add(l1);

        JLabel l2=new JLabel("NEW PIN:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(360,180,400,35);
        img1.add(l2);

        tf1=new JPasswordField();
        tf1.setForeground(Color.WHITE);
        tf1.setBackground(new Color(65,125,128));
        tf1.setFont(new Font("Raleway",Font.BOLD,14));
        tf1.setBounds(505,189,100,20);
        img1.add(tf1);


        JLabel l3=new JLabel("RE-ENTER NEW PIN:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,14));
        l3.setBounds(360,210,400,35);
        img1.add(l3);

        tf2=new JPasswordField();
        tf2.setForeground(Color.WHITE);
        tf2.setBackground(new Color(65,125,128));
        tf2.setFont(new Font("Raleway",Font.BOLD,14));
        tf2.setBounds(505,219,100,20);
        img1.add(tf2);




        change =new JButton("CHANGE");
        change.setForeground(Color.WHITE);
        change.setBackground(new Color(65,125,128));
        change.setBounds(590,302,120,25);
        change.addActionListener(this);
        img1.add(change);

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
        try
        {
            String pin1=String.valueOf(tf1.getPassword());
            String pin2=String.valueOf(tf2.getPassword());


            if(e.getSource()==change)
            {

                if(pin1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                    return;
                }
                if(pin2.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter New Pin");
                    return;
                }
                if(!(pin1.equals(pin2)))
                {
                    JOptionPane.showMessageDialog(null,"Entered Pin Doesn't Match");
                    return;
                }

                Con c=new Con();

                String q1="update bank set pin='"+pin1+"' where pin='"+pin+"'";
                String q2="update login set pin='"+pin1+"' where pin='"+pin+"'";
                String q3="update signupthree set pin='"+pin1+"' where pin='"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                setVisible(false);
                new main_class(pin1);

            }
            else if (e.getSource()==back)
            {
                setVisible(false);
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
        new Change_PIN("");
    }

}

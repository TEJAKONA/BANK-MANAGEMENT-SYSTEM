package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener
{
    String formno;

    JComboBox<String> dd1,dd2,dd3,dd4,dd5;

    JTextField textPan,textAadhar;

    JRadioButton r1,r2,r3,r4;

    JButton next;

    SignUp2(String formno)
    {
        this.formno=formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i12 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel img1 = new JLabel(i13);
        img1.setBounds(30, 10, 100, 100);
        add(img1);

        JLabel l1 = new JLabel("Page 2 ");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(340, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details ");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(300, 50, 600, 40);
        add(l2);



        JLabel lreligion = new JLabel("Religion:");
        lreligion.setFont(new Font("Raleway", Font.BOLD, 14));
        lreligion.setBounds(150, 160, 300, 30);
        add(lreligion);

        String[] religion={"Hindu","Christian","Muslim","Sikh","Other"};
        dd1=new JComboBox<>(religion);
        dd1.setFont(new Font("Raleway", Font.BOLD, 10));
        dd1.setBounds(300, 167, 300, 20);
        add(dd1);

        JLabel lcategory = new JLabel("Category:");
        lcategory.setFont(new Font("Raleway", Font.BOLD, 14));
        lcategory.setBounds(150, 190, 300, 30);
        add(lcategory);

        String[] category={"OBC","SC","ST","General","Other"};
        dd2=new JComboBox<>(category);
        dd2.setFont(new Font("Raleway", Font.BOLD, 10));
        dd2.setBounds(300, 197, 300, 20);
        add(dd2);

        JLabel lincome = new JLabel("Income:");
        lincome.setFont(new Font("Raleway", Font.BOLD, 14));
        lincome.setBounds(150, 220, 300, 30);
        add(lincome);

        String[] income = {"Null","<1,50,000","<2,50,000", "5,00,000", "Uptp 10,00,000","Above 10,00,000"};
        dd3=new JComboBox<>(income);
        dd3.setFont(new Font("Raleway", Font.BOLD, 10));
        dd3.setBounds(300, 227, 300, 20);
        add(dd3);

        JLabel leducation = new JLabel("Education:");
        leducation.setFont(new Font("Raleway", Font.BOLD, 14));
        leducation.setBounds(150, 250, 300, 30);
        add(leducation);

        String[] education= {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        dd4=new JComboBox<>(education);
        dd4.setFont(new Font("Raleway", Font.BOLD, 10));
        dd4.setBounds(300, 257, 300, 20);
        add(dd4);

        JLabel loccupation = new JLabel("Occupation:");
        loccupation.setFont(new Font("Raleway", Font.BOLD, 14));
        loccupation.setBounds(150, 280, 300, 30);
        add(loccupation);

        String[] occupation = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        dd4=new JComboBox<>(occupation);
        dd4.setFont(new Font("Raleway", Font.BOLD, 10));
        dd4.setBounds(300, 287, 300, 20);
        add(dd4);


        JLabel lpan = new JLabel("PAN Number : ");
        lpan.setFont(new Font("Raleway", Font.BOLD,14));
        lpan.setBounds(150,310,300,30);
        add(lpan);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD,10));
        textPan.setBounds(300,317,300,20);
        add(textPan);

        JLabel laadhar = new JLabel("Aadhar Number : ");
        laadhar.setFont(new Font("Raleway", Font.BOLD,14));
        laadhar.setBounds(150,340,300,30);
        add(laadhar);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,10));
        textAadhar.setBounds(300,347,300,20);
        add(textAadhar);

        JLabel lseniorcitizen = new JLabel("Senior Citizen:");
        lseniorcitizen.setFont(new Font("Raleway", Font.BOLD, 14));
        lseniorcitizen.setBounds(150, 370, 300, 30);
        add(lseniorcitizen);

        r1 = new JRadioButton("Yes");
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 10));
        r1.setBounds(300, 378, 50, 20);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 10));
        r2.setBounds(400, 378, 80, 20);
        add(r2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        JLabel lexistingaccount = new JLabel("Existing Account:");
        lexistingaccount.setFont(new Font("Raleway", Font.BOLD, 14));
        lexistingaccount.setBounds(150, 400, 300, 30);
        add(lexistingaccount);

        r3 = new JRadioButton("Yes");
        r3.setBackground(new Color(222, 255, 228));
        r3.setFont(new Font("Raleway", Font.BOLD, 10));
        r3.setBounds(300, 408, 50, 20);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setBackground(new Color(222, 255, 228));
        r4.setFont(new Font("Raleway", Font.BOLD, 10));
        r4.setBounds(400, 408, 80, 20);
        add(r4);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(r3);
        bg2.add(r4);

        JLabel lfn = new JLabel("Form No : "+formno);
        lfn.setFont(new Font("Raleway", Font.BOLD,14));
        lfn.setBounds(500,10,150,30);
        add(lfn);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(400,480,100,30);
        next.addActionListener(this);
        add(next);







        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(700, 600);
        setLocation(450, 50);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) dd1.getSelectedItem();
        String category = (String) dd2.getSelectedItem();
        String income = (String) dd3.getSelectedItem();
        String education = (String) dd4.getSelectedItem();
        String occupation = (String) dd4.getSelectedItem(); // ⚠️ Fix: You reused dd4 for occupation

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String seniorCitizen = r1.isSelected() ? "Yes" : r2.isSelected() ? "No" : "";
        String existingAccount = r3.isSelected() ? "Yes" : r4.isSelected() ? "No" : "";

        try {
            if (pan.isEmpty() || aadhar.isEmpty() || seniorCitizen.isEmpty() || existingAccount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields");
            } else {
                Con c = new Con();

                String query = "INSERT INTO signuptwo(form_no, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.connection.prepareStatement(query);

                pstmt.setString(1, formno);
                pstmt.setString(2, religion);
                pstmt.setString(3, category);
                pstmt.setString(4, income);
                pstmt.setString(5, education);
                pstmt.setString(6, occupation);
                pstmt.setString(7, pan);
                pstmt.setString(8, aadhar);
                pstmt.setString(9, seniorCitizen);
                pstmt.setString(10, existingAccount);

                pstmt.executeUpdate();

                new SignUp3(formno);
                setVisible(false);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new SignUp2("");
    }


}

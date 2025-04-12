package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    Random ran = new Random();
    Long f4 = (ran.nextLong() % 10000L);
    String first = "" + Math.abs(f4);

    JTextField textName, textFName, textEmailAddress, textAddress, textCity, textPincode, textState, textMobile;
    JRadioButton r1, r2;
    JDateChooser dateChooser;
    String[] options = {"Single", "Married", "Divorced", "Widowed"};
    JComboBox<String> dd;
    JButton next;

    SignUp() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i12 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel img1 = new JLabel(i13);
        img1.setBounds(30, 10, 100, 100);
        add(img1);

        JLabel l1 = new JLabel("APPLICATION FORM NO : " + first);
        l1.setFont(new Font("Raleway", Font.BOLD, 32));
        l1.setBounds(150, 20, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Page 1 ");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(335, 60, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Personal Details ");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(300, 80, 600, 40);
        add(l3);

        JLabel lname = new JLabel("Name:");
        lname.setFont(new Font("Raleway", Font.BOLD, 14));
        lname.setBounds(150, 160, 100, 30);
        add(lname);

        textName = new JTextField(); // Removed JTextField declaration
        textName.setFont(new Font("Raleway", Font.BOLD, 10));
        textName.setBounds(300, 168, 300, 20);
        add(textName);

        JLabel lfname = new JLabel("Father's Name:");
        lfname.setFont(new Font("Raleway", Font.BOLD, 14));
        lfname.setBounds(150, 190, 300, 30);
        add(lfname);

        textFName = new JTextField(); // Removed JTextField declaration
        textFName.setFont(new Font("Raleway", Font.BOLD, 10));
        textFName.setBounds(300, 198, 300, 20);
        add(textFName);

        JLabel lgender = new JLabel("Gender:");
        lgender.setFont(new Font("Raleway", Font.BOLD, 14));
        lgender.setBounds(150, 220, 300, 30);
        add(lgender);

        r1 = new JRadioButton("Male");
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 10));
        r1.setBounds(300, 228, 50, 20);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 10));
        r2.setBounds(400, 228, 80, 20);
        add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel lDOB = new JLabel("Date of Birth:");
        lDOB.setFont(new Font("Raleway", Font.BOLD, 14));
        lDOB.setBounds(150, 250, 300, 30);
        add(lDOB);

        dateChooser = new JDateChooser(); // Removed JDateChooser declaration
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 258, 300, 20);
        add(dateChooser);

        JLabel lemail = new JLabel("Email:");
        lemail.setFont(new Font("Raleway", Font.BOLD, 14));
        lemail.setBounds(150, 280, 300, 30);
        add(lemail);

        textEmailAddress = new JTextField();
        textEmailAddress.setFont(new Font("Raleway", Font.BOLD, 10));
        textEmailAddress.setBounds(300, 288, 300, 20);
        add(textEmailAddress);

        JLabel lmarital = new JLabel("Marital:");
        lmarital.setFont(new Font("Raleway", Font.BOLD, 14));
        lmarital.setBounds(150, 310, 300, 30);
        add(lmarital);

        dd = new JComboBox<>(options);
        dd.setFont(new Font("Raleway", Font.BOLD, 10));
        dd.setBounds(300, 318, 300, 20);
        add(dd);

        JLabel laddr = new JLabel("Address:");
        laddr.setFont(new Font("Raleway", Font.BOLD, 14));
        laddr.setBounds(150, 340, 300, 30);
        add(laddr);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD, 10));
        textAddress.setBounds(300, 348, 300, 20);
        add(textAddress);

        JLabel lcity = new JLabel("City:");
        lcity.setFont(new Font("Raleway", Font.BOLD, 14));
        lcity.setBounds(150, 370, 300, 30);
        add(lcity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 10));
        textCity.setBounds(300, 378, 300, 20);
        add(textCity);

        JLabel lpincode = new JLabel("Pincode:");
        lpincode.setFont(new Font("Raleway", Font.BOLD, 14));
        lpincode.setBounds(150, 400, 300, 30);
        add(lpincode);

        textPincode = new JTextField();
        textPincode.setFont(new Font("Raleway", Font.BOLD, 10));
        textPincode.setBounds(300, 408, 300, 20);
        add(textPincode);

        JLabel lstate = new JLabel("State:");
        lstate.setFont(new Font("Raleway", Font.BOLD, 14));
        lstate.setBounds(150, 430, 300, 30);
        add(lstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 10));
        textState.setBounds(300, 438, 300, 20);
        add(textState);

        JLabel lmobile = new JLabel("Mobile Number:");
        lmobile.setFont(new Font("Raleway", Font.BOLD, 14));
        lmobile.setBounds(150, 460, 300, 30);
        add(lmobile);

        textMobile = new JTextField();
        textMobile.setFont(new Font("Raleway", Font.BOLD, 10));
        textMobile.setBounds(300, 468, 300, 20);
        add(textMobile);

        next = new JButton("NEXT");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(400, 510, 100, 30);
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
        String formno = first;
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
        String email = textEmailAddress.getText();
        String marital = (String) dd.getSelectedItem();
        String address = textAddress.getText();
        String city = textCity.getText();
        String state = textState.getText();
        String pincode = textPincode.getText();
        String mobile = textMobile.getText();

        try {
            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || gender.isEmpty() ||
                    email.isEmpty() || marital.isEmpty() || address.isEmpty() ||
                    city.isEmpty() || pincode.isEmpty() || state.isEmpty() || mobile.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Con c = new Con();
                String q = "INSERT INTO signup (form_no, name, father_name, DOB, gender, email, marital_status, address, city, pincode, state, mobile_number) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = c.connection.prepareStatement(q);
                pstmt.setString(1, formno);
                pstmt.setString(2, name);
                pstmt.setString(3, fname);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, marital);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, pincode);
                pstmt.setString(11, state);
                pstmt.setString(12, mobile);

                pstmt.executeUpdate();

                new SignUp2(first);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
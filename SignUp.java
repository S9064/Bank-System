package Management;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUp extends JFrame {
    Random ran = new Random();
    int firstFour = ran.nextInt(0, 999);
    String first = Integer.toString(firstFour);
    JTextField text1, text2, text3, text4,eml;
    JPasswordField passwordField;
    JDateChooser date;
    JRadioButton rbtn1, rbtn2;
    int account=ran.nextInt(10000,99999);

    SignUp() {
        super("Application Form");

        // Setting the bank image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 150, 150);
        add(image);

        JLabel label1 = new JLabel("Application Form NO. " + first);
        label1.setBounds(200, 20, 300, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 20));
        label1.setForeground(Color.BLACK);
        add(label1);

        JLabel label2 = new JLabel("Page 1 ");
        label2.setFont(new Font("Arial", Font.BOLD, 17));
        label2.setBounds(290, 60, 600, 30);
        label2.setForeground(Color.BLACK);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Arial", Font.BOLD, 17));
        label3.setBounds(250, 90, 600, 30);
        label3.setForeground(Color.BLACK);
        add(label3);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 17));
        name.setBounds(100, 140, 70, 30);
        name.setForeground(Color.BLACK);
        add(name);

        text1 = new JTextField();
        text1.setBounds(190, 140, 150, 30);
        text1.setFont(new Font("Arial", Font.BOLD, 17));
        add(text1);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Arial", Font.BOLD, 17));
        address.setBounds(100, 190, 100, 30);
        address.setForeground(Color.BLACK);
        add(address);

        text2 = new JTextField();
        text2.setBounds(190, 190, 150, 30);
        text2.setFont(new Font("Arial", Font.BOLD, 17));
        add(text2);

        JLabel phone = new JLabel("Contact:");
        phone.setFont(new Font("Arial", Font.BOLD, 17));
        phone.setBounds(100, 240, 100, 30);
        phone.setForeground(Color.BLACK);
        add(phone);

        text3 = new JTextField();
        text3.setBounds(190, 240, 150, 30);
        text3.setFont(new Font("Arial", Font.BOLD, 17));
        add(text3);

        JLabel branch = new JLabel("Branch:");
        branch.setFont(new Font("Arial", Font.BOLD, 17));
        branch.setBounds(100, 290, 100, 30);
        branch.setForeground(Color.BLACK);
        add(branch);

        text4 = new JTextField();
        text4.setBounds(190, 290, 150, 30);
        text4.setFont(new Font("Arial", Font.BOLD, 17));
        add(text4);

        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Arial", Font.BOLD, 17));
        email.setBounds(100, 340, 100, 30);
        email.setForeground(Color.BLACK);
        add(email);

        eml =new JTextField();
        eml.setBounds(190, 340, 150, 30);
        eml.setFont(new Font("Arial", Font.BOLD, 17));
        add(eml);

        JLabel pass=new JLabel("Password:");
        pass.setFont(new Font("Arial", Font.BOLD, 17));
        pass.setBounds(100, 390, 100, 30);
        pass.setForeground(Color.BLACK);
        add(pass);

        passwordField=new JPasswordField();
        passwordField.setBounds(190, 390, 150, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 17));
        add(passwordField);


        JLabel dob = new JLabel("DOB:");
        dob.setFont(new Font("Arial", Font.BOLD, 17));
        dob.setBounds(100, 440, 70, 30);
        dob.setForeground(Color.BLACK);
        add(dob);

        date = new JDateChooser();
        date.setForeground(new Color(105, 105, 105));
        date.setBounds(190, 440, 150, 30);
        date.setForeground(Color.BLACK);
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 490, 100, 30);
        gender.setFont(new Font("Arial", Font.BOLD, 17));
        gender.setForeground(Color.BLACK);
        add(gender);

        rbtn1 = new JRadioButton("Male");
        rbtn1.setFont(new Font("Arial", Font.BOLD, 17));
        rbtn1.setBackground(new Color(222, 255, 228));
        rbtn1.setBounds(190, 490, 60, 30);
        rbtn1.setForeground(Color.BLACK);
        add(rbtn1);

        rbtn2 = new JRadioButton("Female");
        rbtn2.setFont(new Font("Arial", Font.BOLD, 17));
        rbtn2.setBackground(new Color(222, 255, 228));
        rbtn2.setBounds(270, 490, 100, 30);
        rbtn2.setForeground(Color.BLACK);
        add(rbtn2);

        // For selecting only one gender at a time.
        ButtonGroup btngrp = new ButtonGroup();
        btngrp.add(rbtn1);
        btngrp.add(rbtn2);

        JButton btn = new JButton("Submit");
        btn.setFont(new Font("Arial", Font.BOLD, 17));
        btn.setBounds(550, 600, 100, 30);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        add(btn);

        JLabel label=new JLabel();
        label.setBounds(50,670,650,25);
        label.setFont(new Font("Arial",Font.BOLD,15));
        label.setForeground(Color.GREEN);
        add(label);
        
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); 
        Image iii2=iii1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2); 
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,800,800);
        add(iiimage);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username1 = text1.getText();
                String address = text2.getText();
                String contact = text3.getText();
                String Branch = text4.getText();
                String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
                String gender = null;
                if (rbtn1.isSelected()) {
                    gender = "Male";
                } else if (rbtn2.isSelected()) {
                    gender = "Female";
                }
                String el=eml.getText();
                String passwrd=new String(passwordField.getPassword());
                String accnt=Integer.toString(account);
                int amount=0;
                try {
                    if (text1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the Fields");
                    } else {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnksystm", "root", "Su9064@");
                            String query = "Insert into user values(?,?,?,?,?,?,?,?,?,?)";
                            PreparedStatement ps = conn.prepareStatement(query);
                            ps.setString(1, username1);
                            ps.setString(2, address);
                            ps.setString(3, contact);
                            ps.setString(4, Branch);
                            ps.setString(5, dob);
                            ps.setString(6, gender);
                            ps.setString(7, el);
                            ps.setString(8, passwrd);
                            ps.setString(9, accnt);
                            ps.setInt(10, amount);
                            int count = ps.executeUpdate();
                            if (count > 0) {
                                label.setText("You have successfully created you account,your account number is:"+accnt);
                                repaint();
                            }
                            else {
                               label.setText("You have not successfully created you account...!");
                               repaint();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (Exception E) {
                    System.out.println(E.getMessage());
                }
            }
        });
        getContentPane().setBackground(new Color(222, 255, 228));
        setSize(800, 800);
        setLocation(450, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SignUp();
    }
}

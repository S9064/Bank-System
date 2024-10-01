package Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends JFrame {
    JButton btn1,btn2,btn3,btn4;
    public Option(){
        super("Option Section");

        JLabel label=new JLabel("Please Choose any of one from below:");
        label.setBounds(100, 50, 400, 30);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        add(label);

        btn1=new JButton("Make Transaction");
        btn1.setBounds(170,100,225,30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Arial",Font.BOLD,17));
        add(btn1);
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionOption();
                setVisible(false);
            }
            
        });

        btn2=new JButton("Balance Enquiry");
        btn2.setBounds(170,150,230,30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Arial",Font.BOLD,17));
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new BalanceEnquiry();
            }
        });

        btn3=new JButton("Delete Account");
        btn3.setBounds(170,200,230,30);
        btn3.setBackground(Color.BLACK);
        btn3.setForeground(Color.WHITE);
        btn3.setFont(new Font("Arial",Font.BOLD,17));
        add(btn3);
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete();
            }
            
        });

         //    setting the background image.
         ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); // getting the image location from the system
         Image iii2=iii1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);// setting the image scalablity
         ImageIcon iii3=new ImageIcon(iii2); // setting the image icon for set image in the frame.
         JLabel iiimage=new JLabel(iii3);
         iiimage.setBounds(0,0,600,600);
         add(iiimage);
 

        setBounds(300,300,600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Option();
    }
}

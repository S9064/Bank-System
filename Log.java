package Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Log extends JFrame{
    JLabel label1,label2,label3,label;
    JTextField text1,text2;
    JPasswordField pf,pf2;
    JButton btn1,btn2,btn3;

    public Log(){
            setTitle("Bank Management System");

            // Setting the bank image
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg")); 
            Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(350,20,150,150);
            add(image);

            label1=new JLabel("WELCOME TO Bank Management System");
            label1.setBounds(200, 145, 500, 40);
            label1.setFont(new Font("Arial",Font.BOLD,20));
            label1.setForeground(Color.WHITE);
            add(label1);

            label2=new JLabel("Email:");
            label2.setFont(new Font("Arial",Font.BOLD,20));
            label2.setForeground(Color.WHITE);
            label2.setBounds(150,190,150,40);
            add(label2);

            text1=new JTextField();
            text1.setFont(new Font("Arial",Font.BOLD,16));
            text1.setBounds(290,190,250,35);
            add(text1);

            label3=new JLabel("Password:");
            label3.setFont(new Font("Arial",Font.BOLD,20));
            label3.setForeground(Color.WHITE);
            label3.setBounds(150,250,150,40);
            add(label3);

            pf=new JPasswordField();
            pf.setFont(new Font("Arial",Font.BOLD,16));
            pf.setBounds(290,250,250,35);
            add(pf);

          
            btn1=new JButton("SIGN IN");
            btn1.setBounds(220,320,100,30);
            btn1.setFont(new Font("Arial",Font.BOLD,14));
            btn1.setForeground(Color.WHITE);
            btn1.setBackground(Color.BLACK);
            add(btn1);

            label=new JLabel();
            label.setBounds(270,380,300,30);
            label.setFont(new Font("Arial",Font.BOLD,20));
            label.setForeground(Color.RED);
            add(label);

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String email=text1.getText();
                    String pass=new String(pf.getPassword());
                    try{
                        String eml="",p="";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bnksystm", "root", "Su9064@");
                        String query="Select * from user where email=? and password=?";
                        PreparedStatement ps=conn.prepareStatement(query);
                        ps.setString(1,email);
                        ps.setString(2,pass);
                        ResultSet r=ps.executeQuery();
                        if(r.next()){
                            eml=r.getString("email");
                            p=r.getString("password");
                            if(eml.equals(email) && p.equals(pass)){
                                new Option();
                            }
                        }
                       else if(!eml.equals(email) && !p.equals(pass)){
                                label.setText("Invalid username or password");
                                System.out.println("Invalid username or password");
                                repaint();
                        }
                    }
                    catch(Exception E){
                        System.out.println(E.getMessage());
                    }
                }
            });

            btn2=new JButton("CLEAR");
            btn2.setBounds(350,320,100,30);
            btn2.setFont(new Font("Arial",Font.BOLD,14));
            btn2.setForeground(Color.WHITE);
            btn2.setBackground(Color.BLACK);
            add(btn2);
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text1.setText("");
                    pf.setText("");
                }
            });

            btn3=new JButton("SIGN UP");
            btn3.setBounds(480,320,100,30);
            btn3.setFont(new Font("Arial",Font.BOLD,14));
            btn3.setForeground(Color.WHITE);
            btn3.setBackground(Color.BLACK);
            add(btn3);
            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new SignUp();
                }
            });
            
       
            ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); 
            Image iii2=iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
            ImageIcon iii3=new ImageIcon(iii2); 
            JLabel iiimage=new JLabel(iii3);
            iiimage.setBounds(0,0,850,480);
            add(iiimage);

            setSize(850,480);
            setLocation(450,200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);
            setVisible(true);
        }

        public static void main(String[] args) {
            new Log();
        }

}

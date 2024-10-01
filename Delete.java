package Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Delete extends JFrame{
    JLabel account,email,password;
    JTextField accnt,el;
    JPasswordField pass;
    Delete(){
        super("Delete Account");
        setBounds(200,200,600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        account=new JLabel("Account No:");
        account.setBounds(70,100,100,30);
        account.setForeground(Color.WHITE);
        account.setFont(new Font("Arial",Font.BOLD,17));
        add(account);

        accnt=new JTextField();
        accnt.setBounds(200,100,200,30);
        accnt.setForeground(Color.BLACK);
        accnt.setFont(new Font("Arial",Font.BOLD,17));
        add(accnt);

        email=new JLabel("Email:");
        email.setBounds(70,160,100,30);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Arial",Font.BOLD,17));
        add(email);

        el=new JTextField();
        el.setBounds(200,160,200,30);
        el.setForeground(Color.BLACK);
        el.setFont(new Font("Arial",Font.BOLD,17));
        add(el);

        password=new JLabel("Passowrd:");
        password.setBounds(70,220,100,30);
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial",Font.BOLD,17));
        add(password);

        pass=new JPasswordField();
        pass.setBounds(200,220,200,30);
        pass.setForeground(Color.BLACK);
        pass.setFont(new Font("Arial",Font.BOLD,17));
        add(pass);

        JLabel label=new JLabel();
        label.setBounds(200,400,300,25);
        label.setFont(new Font("Arial",Font.BOLD,17));
        label.setForeground(Color.RED);
        add(label);

        JButton btn=new JButton("DELETE");
        btn.setBounds(350,350,100,25);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String a=accnt.getText();
                String eml=el.getText();
                String p=new String(pass.getPassword()); 
                if(accnt.getText().equals("") || el.getText().equals("") || pass.getPassword().length==0){
                    JOptionPane.showMessageDialog(null, "Fill all the field");
                }
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnksystm", "root", "Su9064@");  
                String query="Select * from user where accnt=?";
                PreparedStatement ps=conn.prepareStatement(query);
                ps.setString(1,a);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    String em=rs.getString("email");
                    String password=rs.getString("password");
                    String account=rs.getString("accnt");
                    if(account.equals(a)){
                        if(em.equals(eml)){
                            if(password.equals(p)){
                                String query1="Delete from user where accnt=?";
                                PreparedStatement ps1=conn.prepareStatement(query1);
                                ps1.setString(1, account);
                                int count=ps1.executeUpdate(); 
                                if(count>0){
                                    label.setForeground(Color.GREEN);
                                    label.setText("Account Deleted Successfully....!");
                                    repaint();
                                }
                            }
                            else{
                                label.setText("Password is Invalid..!");
                                repaint();
                            }
                        }
                        else{
                                label.setText("Email is Invalid..!");
                                repaint();
                        }
                    }
                }
                    else{
                        label.setText("Account is Invalid..!");
                        repaint();
                    }
                }
                catch(Exception E){
                    System.out.println(E.getMessage());
                }
            }
            
        });
          
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); 
        Image iii2=iii1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon iii3=new ImageIcon(iii2); 
        iiimage.setBounds(0,0,600,600);
        add(iiimage);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Delete();
    }
}

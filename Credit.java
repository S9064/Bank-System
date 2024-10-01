package Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Credit extends JFrame{
    JLabel account,amount;
    JTextField accnt,amnt;
    public Credit(){
        super("Credit Section");
        setBounds(200,200,600,600);

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

        
        amount=new JLabel("Amount:");
        amount.setBounds(70,160,100,30);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Arial",Font.BOLD,17));
        add(amount);

        amnt=new JTextField();
        amnt.setBounds(200,160,200,30);
        amnt.setForeground(Color.BLACK);
        amnt.setFont(new Font("Arial",Font.BOLD,17));
        add(amnt);

        JLabel label1=new JLabel();
        label1.setBounds(170,350,400,30);
        label1.setFont(new Font("Arial",Font.BOLD,17));
        label1.setForeground(Color.green);
        add(label1);

        JLabel label2=new JLabel();
        label2.setBounds(170,350,400,30);
        label2.setFont(new Font("Arial",Font.BOLD,17));
        label2.setForeground(Color.RED);
        add(label2);

        JButton btn=new JButton("CREDIT");
        btn.setBounds(220,270,100,30);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.setFont(new Font("Arial",Font.BOLD,17));
        add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String acnt=accnt.getText();
                String ammnt=amnt.getText();
                int amount=Integer.parseInt(ammnt); // Converting the amount into int of textfield.
                if(accnt.getText().equals("") || amnt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                }
               try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnksystm", "root", "Su9064@");  
                String query="Select * from user where accnt=?";
                PreparedStatement ps=conn.prepareStatement(query);
                ps.setString(1, acnt);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    String a1=rs.getString("accnt");

                    if(a1.equals(acnt)){
                    int a=rs.getInt("amount");
                    a+=amount;
                    String query1="Update user set amount=? where accnt=?";
                    PreparedStatement ps1=conn.prepareStatement(query1);
                    ps1.setInt(1,a);
                    ps1.setString(2,a1);
                    int count=ps1.executeUpdate();
                    if(count>0){
                        label1.setText("Amount Credited Successfully...!");
                        repaint();
                    }
                    else{
                        label2.setText("Amount not Credited Successfully...!");
                        repaint();
                       } 
                    }
                }
                else{
                    label2.setText("Account Number is Invalid...!");
                    repaint();
                }
               }
               catch(Exception E){
                System.out.println(E.getMessage());
               }
            }
            
        });
        
        //    setting the background image.
        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); // getting the image location from the system
        Image iii2=iii1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);// setting the image scalablity
        ImageIcon iii3=new ImageIcon(iii2); // setting the image icon for set image in the frame.
        JLabel iiimage=new JLabel(iii3);
        iiimage.setBounds(0,0,600,600);
        add(iiimage);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Credit();
    }
}

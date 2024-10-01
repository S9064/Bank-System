package Management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TransactionOption extends JFrame{
    JButton btn1,btn2;
    public TransactionOption(){
        super("Transaction Option");

        JLabel label=new JLabel("Please Choose any of one from below:");
        label.setBounds(100, 50, 400, 30);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        add(label);

        btn1=new JButton("Credit");
        btn1.setBounds(210,150,130,30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Arial",Font.BOLD,17));
        add(btn1);
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              new Credit();
            }
            
        });

        btn2=new JButton("Debit");
        btn2.setBounds(210,200,130,30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Arial",Font.BOLD,17));
        add(btn2);
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               new Debit();
            }
            
        });
        
        
         ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("icons/backbg.jpg")); 
         Image iii2=iii1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
         ImageIcon iii3=new ImageIcon(iii2); 
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
        new TransactionOption();
    }
}

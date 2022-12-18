
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pin; JButton back;
    BalanceEnquiry(String pinnumber)
    {
        pin = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel img = new JLabel(i3);
       img.setBounds(0, 0, 800,800); // sirf isse fix nhi hogaaa
          add(img);
          
             back = new JButton("Back");
         back.setFont(new Font("Raleway",Font.BOLD, 13));
        back.setBounds(300, 455, 150, 25); 
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
          img.add(back);
          
          Conn c = new Conn(); 
           int balance = 0;
                try
                {
                    ResultSet rs = c.stmt.executeQuery("select * from bank where pin='"+pin+"'" );

                   
                while(rs.next())
                { 
                    String temp= rs.getString("amount");
                    
                    if(rs.getString("type").endsWith("Deposit"))
                        balance+=Integer.parseInt(temp);
                    else
                        balance-=Integer.parseInt(temp); 
                } 
                }
                catch(Exception e)
                {
                     System.out.println(e);
                }
//        String balance;
                
        JLabel info = new JLabel("Your current Account Balance is" );
        info.setFont(new Font("Raleway",Font.BOLD, 17));
        info.setBounds(140, 240, 500, 30);
        info.setForeground(Color.WHITE);
        img.add(info);
        
        JLabel inf = new JLabel("Rs." + balance);
        inf.setFont(new Font("Raleway",Font.BOLD, 23));
        inf.setBounds(230, 280, 500, 30);
        inf.setForeground(Color.WHITE);
        img.add(inf);
          
          setTitle("Balance Enquiry");
          setSize(800, 800);
        setLocation(350,10);
         getContentPane().setBackground(Color.white);
         setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
            new BalanceEnquiry("");
    }
}

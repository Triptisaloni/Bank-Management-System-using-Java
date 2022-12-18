
package bank.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton b100, b1k, b500, b2k, b5k, b10k, back, exit;
    String pin;
    
    FastCash(String pinnumber)
    {
        pin = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); //image set
          img.setBounds(0, 0, 800,800); // sirf isse fix nhi hogaaa
          add(img);
        
        JLabel info = new JLabel("Select Withdrawal Amount");
        info.setFont(new Font("Raleway",Font.BOLD, 18));
        info.setBounds(150, 240, 500, 30);
        info.setForeground(Color.WHITE);
        img.add(info);
        
        b100 = new JButton("100");
        b100.setFont(new Font("Raleway",Font.BOLD, 13));
        b100.setBounds(100, 350, 150, 25);
        b100.setBackground(Color.WHITE);
        b100.addActionListener(this);
        img.add(b100);
        
         b500 = new JButton("500");
        b500.setFont(new Font("Raleway",Font.BOLD, 13));
        b500.setBounds(300, 350, 150, 25);
        b500.setBackground(Color.WHITE);
        b500.addActionListener(this);
        img.add(b500);
        
        
        b1k = new JButton("1000");
        b1k.setFont(new Font("Raleway",Font.BOLD, 13));
        b1k.setBounds(100, 385, 150, 25);
        b1k.setBackground(Color.WHITE);
        b1k.addActionListener(this);
        img.add(b1k);
        
         b2k = new JButton("2000");
        b2k.setFont(new Font("Raleway",Font.BOLD, 13));
        b2k.setBounds(300, 385, 150, 25);
        b2k.setBackground(Color.WHITE);
        b2k.addActionListener(this);
        img.add(b2k);
        
        b5k = new JButton("5000");
        b5k.setFont(new Font("Raleway",Font.BOLD, 13));
        b5k.setBounds(100, 420, 150, 25);
        b5k.setBackground(Color.WHITE);
        b5k.addActionListener(this);
        img.add(b5k);
        
         b10k = new JButton("10000");
        b10k.setFont(new Font("Raleway",Font.BOLD, 13));
        b10k.setBounds(300, 420, 150, 25);
        b10k.setBackground(Color.WHITE);
        b10k.addActionListener(this);
        img.add(b10k);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD, 13));
        back.setBounds(100, 455, 150, 25);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        img.add(back);
        
         exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD, 13));
        exit.setBounds(300, 455, 150, 25);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        img.add(exit);
        
        setUndecorated(true);
        setTitle("Fast Cash Page");
         setSize(800, 800);
        setLocation(350,10);
         getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== exit)
        {System.exit(0);
        return;}
        else if(ae.getSource()== back)
        {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
          else
        {
            //typecast;
            JButton clicked = (JButton)ae.getSource();
            String amt = clicked.getText();
          
                Conn c = new Conn();
//                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amt+"')";
                
                try
                {
                    ResultSet rs = c.stmt.executeQuery("select * from bank where pin='"+pin+"'" );

                    int balance = 0;
                while(rs.next())
                { 
                    String temp= rs.getString("amount");
                    
                    if(rs.getString("type").endsWith("Deposit"))
                        balance+=Integer.parseInt(temp);
                    else
                        balance-=Integer.parseInt(temp); 
                }    
                    if(balance<Integer.parseInt(amt))
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    else
                    {
                                      Date date = new Date();
                        String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amt+"')";
                                            c.stmt.executeUpdate(query);
                                            
                         JOptionPane.showMessageDialog(null, "Rs. "+ amt +" withdraw successfully");
                    
                         setVisible(false);
                         new Transactions(pin).setVisible(true);
                    }
                        
                
        
                }
                catch(Exception e)
                {
                     System.out.println(e);
                }
        }
        
        
        
        
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }   
}

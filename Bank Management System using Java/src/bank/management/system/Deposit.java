
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit, back;
    String pin;
    
    Deposit(String pinnumber)
    {
        pin = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel img = new JLabel(i3);
       img.setBounds(0, 0, 800,800); // sirf isse fix nhi hogaaa
          add(img);
          
          JLabel info = new JLabel("Enter the amount you want to deposit");
        info.setFont(new Font("Raleway",Font.BOLD, 16));
        info.setBounds(130, 240, 500, 30);
        info.setForeground(Color.WHITE);
        img.add(info);
        
        amount = new JTextField();
         amount.setFont(new Font("Raleway",Font.BOLD, 16));
        amount.setBounds(180, 300, 200, 30); 
          img.add(amount);
          
          deposit = new JButton("Deposit");
         deposit.setFont(new Font("Raleway",Font.BOLD, 13));
        deposit.setBounds(300, 420, 150, 25);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        img.add(deposit);
          
          back = new JButton("Back");
         back.setFont(new Font("Raleway",Font.BOLD, 13));
        back.setBounds(300, 455, 150, 25); 
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
          img.add(back);
          
          setUndecorated(true);
          setTitle("Deposit Page");
          setSize(800, 800);
        setLocation(350,10);
         getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else if(ae.getSource()== deposit)
        {
            String input = amount.getText();
            Date date = new Date();
            
            if(input.equals(""))
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            else
            {
                Conn c = new Conn();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+input+"')";
                
                try
                {
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+input+" deposited successfully");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
            
            
        }
        
    }
    
    public static void main(String args[])
    {
        new Deposit("");
    }
}

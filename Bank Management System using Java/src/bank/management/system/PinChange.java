
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{

       JPasswordField type1, type2;
    JButton change, back;
    String oldpin;
    
    PinChange(String pinnumber)
    {
        oldpin = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel img = new JLabel(i3);
       img.setBounds(0, 0, 800,800); // sirf isse fix nhi hogaaa
          add(img);
          
          JLabel info = new JLabel("New Pin");
        info.setFont(new Font("Raleway",Font.BOLD, 16));
        info.setBounds(110, 240, 150, 30);
        info.setForeground(Color.WHITE);
        img.add(info);
        
        type1 = new JPasswordField();
         type1.setFont(new Font("Raleway",Font.BOLD, 16));
        type1.setBounds(250, 240, 200, 30); 
          img.add(type1);
              
        JLabel inf = new JLabel("Retype New Pin :");
        inf.setFont(new Font("Raleway",Font.BOLD, 16));
        inf.setBounds(110, 280, 500, 30);
        inf.setForeground(Color.WHITE);
        img.add(inf);
          type2 = new JPasswordField();
         type2.setFont(new Font("Raleway",Font.BOLD, 16));
        type2.setBounds(250, 280, 200, 30); 
          img.add(type2);
          
          change = new JButton("Change");
         change.setFont(new Font("Raleway",Font.BOLD, 13));
        change.setBounds(300, 420, 150, 25);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        img.add(change);
          
          back = new JButton("Back");
         back.setFont(new Font("Raleway",Font.BOLD, 13));
        back.setBounds(300, 455, 150, 25); 
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
          img.add(back);
          
          setTitle("Deposit Page");
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
            new Transactions(oldpin).setVisible(true);
        }
        else if(ae.getSource()== change)
        {
            String npin = type1.getText();
            String rpin = type2.getText();
            
           
            if(npin.equals("") || rpin.equals(""))
            {JOptionPane.showMessageDialog(null, "Don't leave any field blank");
            }
            else if(!npin.equals(rpin))
            {
                 JOptionPane.showMessageDialog(null, "Entered PIN does not match");
            }
         
            else if(oldpin.equals(npin))
            {
                JOptionPane.showMessageDialog(null, "You already have this PIN");
            }
            else
            {
                try
                {
                    Conn c = new Conn();
                String query1 = "update bank set pin = '"+npin+"' where pin= '"+oldpin+"'";
                String query2 = "update login set pin = '"+npin+"' where pin= '"+oldpin+"'";
                String query3 = "update signupthree set pin = '"+npin+"' where pin= '"+oldpin+"'";
                
                    c.stmt.executeUpdate(query1);
                    c.stmt.executeUpdate(query2);
                    c.stmt.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN change successfully");
                    
                    setVisible(false);
                    new Transactions(oldpin).setVisible(true);
               
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
        new PinChange("");
    }
}

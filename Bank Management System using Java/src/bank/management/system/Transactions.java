
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{

    
    JButton withdraw, deposit, fastcash, pinchange, ministmt, balance, exit;
    String pin;
    Transactions(String pinnumber)
    {
        pin = pinnumber;
        //background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3); //image set
          img.setBounds(0, 0, 800,800); // sirf isse fix nhi hogaaa
          add(img);
        
        JLabel info = new JLabel("Please select your Transaction");
        info.setFont(new Font("Raleway",Font.BOLD, 18));
        info.setBounds(150, 240, 500, 30);
        info.setForeground(Color.WHITE);
        img.add(info);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD, 13));
        deposit.setBounds(100, 350, 150, 25);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        img.add(deposit);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setFont(new Font("Raleway",Font.BOLD, 13));
        fastcash.setBounds(100, 385, 150, 25);
        fastcash.setBackground(Color.WHITE);
        fastcash.addActionListener(this);
        img.add(fastcash);
        
        pinchange = new JButton("Pin Change");
        pinchange.setFont(new Font("Raleway",Font.BOLD, 13));
        pinchange.setBounds(100, 420, 150, 25);
        pinchange.setBackground(Color.WHITE);
        pinchange.addActionListener(this);
        img.add(pinchange);
        
         withdraw = new JButton("Cash Withdrawal");
        withdraw.setFont(new Font("Raleway",Font.BOLD, 13));
        withdraw.setBounds(300, 350, 150, 25);
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        img.add(withdraw);
        
         ministmt = new JButton("Mini Statement");
        ministmt.setFont(new Font("Raleway",Font.BOLD, 13));
        ministmt.setBounds(300, 385, 150, 25);
        ministmt.setBackground(Color.WHITE);
        ministmt.addActionListener(this);
        img.add(ministmt);
        
         balance = new JButton("Balance Enquiry");
        balance.setFont(new Font("Raleway",Font.BOLD, 13));
        balance.setBounds(300, 420, 150, 25);
        balance.setBackground(Color.WHITE);
        balance.addActionListener(this);
        img.add(balance);
        
         exit = new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD, 13));
        exit.setBounds(300, 455, 150, 25);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        img.add(exit);
        
         setUndecorated(true);
        setTitle("Transaction Page");
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
        else if(ae.getSource()== deposit)
        {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
          else if(ae.getSource()== withdraw)
        {
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        }
        else if(ae.getSource()== fastcash)
        {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource()== pinchange)
        {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource()== balance)
        {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
         else if(ae.getSource()== ministmt)
        {
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
        
        
    }
    
    public static void main(String args[]) 
    {
      new Transactions("");
    }
}

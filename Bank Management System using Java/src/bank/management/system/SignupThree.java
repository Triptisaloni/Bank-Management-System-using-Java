
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    
//    JTextField aadharInput, panInput;
    JRadioButton saving, fixed, curr, recur;
    JCheckBox c1,c2, c3, c4, c5, c6, c7;
    String formno;
    JButton submit, cancel;
    
    SignupThree(String formno){
        
        this.formno = formno;
        //set bound only works when setlayout is null
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM- Page 3");
        
    //Page 3
        JLabel pageNo = new JLabel("Page 3 : Account Details");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setBounds(280,50,600,30);
        add(pageNo);
        
        //account type
        JLabel acc = new JLabel("Account Type : ");
        acc.setFont(new Font("Raleway", Font.BOLD, 20));
        acc.setBounds(100,120,400,30);
        add(acc);
        
        saving = new JRadioButton("Saving Account");
         saving.setBounds(100, 150,150,30);
        saving.setFont(new Font("Raleway", Font.BOLD, 15));
         saving.setBackground(Color.WHITE);
        add(saving);
        
        
         fixed  = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(320, 150,250,30);
        fixed.setBackground(Color.WHITE);
        fixed.setFont(new Font("Raleway", Font.BOLD, 15));
        add(fixed);
        
        curr  = new JRadioButton("Current Account");
        curr.setBounds(100, 180,200,30);
        curr.setBackground(Color.WHITE);
        curr.setFont(new Font("Raleway", Font.BOLD, 15));
        add(curr);
        
        recur  = new JRadioButton("Recurring Deposit Account");
        recur.setBounds(320, 180,300,30);
        recur.setBackground(Color.WHITE);
        recur.setFont(new Font("Raleway", Font.BOLD, 15));
        add(recur);
        
        //dono select hojarhe h simultaneously
        ButtonGroup accGroup = new ButtonGroup();
       accGroup.add(fixed);
        accGroup.add(saving);
        accGroup.add(curr);
        accGroup.add(recur);
        
        JLabel cardNo = new JLabel("Card Number: ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(100,230,200,30);
        add(cardNo);

        JLabel num = new JLabel("XXXX-XXXX-XXXX-XXXX ");
        num.setBounds(300,230,400,30);
      num.setFont(new Font("Raleway", Font.BOLD, 20));
        add(num);
//    
     JLabel info = new JLabel("Your 16 digit card number ");
        info.setFont(new Font("Raleway", Font.BOLD, 12));
        info.setBounds(100,260,200,15);
        add(info);
        
       JLabel pinNo = new JLabel("PIN : ");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pinNo.setBounds(100,300,200,30);
        add(pinNo);

        JLabel pass = new JLabel("XXXX");
        pass.setBounds(300,300,400,30);
      pass.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pass);
//    
     JLabel info1 = new JLabel("Your 4 digit password");
        info1.setFont(new Font("Raleway", Font.BOLD, 12));
        info1.setBounds(100,330,200,15);
        add(info1);

        //services
         JLabel occ = new JLabel("Services Required : ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100,360,200,30);
        add(occ);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(100,400,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Net Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(350,400,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
          c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(100,430,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS Alert");
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350,430,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
          c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(100,460,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBounds(350,460,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);
        
          c7 = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge.",true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,500,600,30);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        
        
        //next button
           submit = new JButton("SUBMIT");
          submit.setBounds(200, 560, 120, 30);
          submit.setBackground(Color.BLACK);
          submit.setForeground(Color.WHITE);
          submit.addActionListener(this);
          add(submit);
        
           cancel = new JButton("CANCEL");
          cancel.setBounds(420, 560, 120, 30);
          cancel.setBackground(Color.BLACK);
          cancel.setForeground(Color.WHITE);
          cancel.addActionListener(this);
          add(cancel);
          
        setSize(800, 700);
        setLocation(350,10);
         getContentPane().setBackground(Color.white);
        setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cancel)
            {
                System.exit(0);
                return;
            }
        
        String account = "";
        //check which is selected
        if(saving.isSelected())
            account = "Saving Account";
        else if(fixed.isSelected())
            account = "Fixed Deposit Account";
        else if(curr.isSelected())
            account = "Current Account";
        else if(recur.isSelected())
            account = "Recurring Deposit Account";
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Net Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        Random random = new Random();
       long x = (random.nextLong() % 90000000L) + 2451366700000000L; 
       String cardnumber = ""+Math.abs(x);
        long y  = Math.abs(random.nextLong() % 9000L)+1000L;
         String pin = ""+Math.abs(y);
         //database
         try
         {
            if(ae.getSource()==submit)             
            {       
                if(account.equals("") || !(c7.isSelected()))
                 JOptionPane.showMessageDialog(null, "Fill required details");
             else
             {
                 Conn c = new Conn();
                 String q1 = "insert into signupThree values('"+formno+"','"+cardnumber+"', '"+pin+"', '"+account+"', '"+facility+"')";
                 String q2 = "insert into Login values('"+formno+"','"+cardnumber+"', '"+pin+"')";
                 c.stmt.executeUpdate(q1);
                 c.stmt.executeUpdate(q2);
                   
                  JOptionPane.showMessageDialog(null, "Your Card No. is : " + cardnumber + "\n Your 4 Digit pin is : " + pin);
                  
                  setVisible(false);
                  new Deposit(pin).setVisible(true);
             }
            }
         }
         catch(Exception e)
         {
             System.out.print(e);
         }
        
    }
    
    public static void main(String args[]) 
    {
            new SignupThree("");
            
    }
}

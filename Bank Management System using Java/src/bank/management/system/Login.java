
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.* ;// for resultset;
import java.awt.event.*; // for actionlistener
//ActionListener interface h
public class Login extends JFrame implements ActionListener {
    //globaaly define taaki baaki function / constructor k baahar bhi access kr sku
    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
          JLabel label = new JLabel(i3); //image set
          label.setBounds(20, 20, 100,100); // sirf isse fix nhi hogaaa
          add(label);
          
          //welcome to atm
          JLabel text = new JLabel("Welcome to ATM");
          text.setFont(new Font("Osward",Font.BOLD, 40));
          text.setBounds(200, 40, 400, 30);
          add(text);
          
          //card no. label
          JLabel cardNo = new JLabel("Card No. : ");
          cardNo.setFont(new Font("Osward",Font.BOLD, 30));
          cardNo.setBounds(100, 150, 200, 30);
          add(cardNo);
          
          //card input
          cardTextField = new JTextField();
          cardTextField.setBounds(300, 150, 250, 30);
          cardTextField.setFont(new Font("Arial",Font.BOLD, 15));
          add(cardTextField);
          
          //pin input
          JLabel pin = new JLabel("PIN : ");
          pin.setFont(new Font("Osward",Font.BOLD, 30));
          pin.setBounds(100, 200, 200, 40);
          add(pin);
          
          //pin input
           pinTextField = new JPasswordField();
          pinTextField.setBounds(300, 200, 250, 30);
          pinTextField.setFont(new Font("Osward",Font.BOLD, 15));
          add(pinTextField);
          
//sign in button
          signin = new JButton("SIGN IN");
          signin.setBounds(300, 300, 100, 30);
          signin.setBackground(Color.BLACK);
          signin.setForeground(Color.WHITE);
          signin.addActionListener(this);
          add(signin);
//          signin.setFont(new Font("Osward",Font.BOLD, 30));
                  
//clear button
          clear = new JButton("CLEAR");
          clear.setBounds(450, 300, 100, 30);
          clear.setBackground(Color.BLACK);
          clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
          add(clear);
          
//signup button
          signup = new JButton("SIGN UP");
          signup.setBounds(300, 350, 230, 30);
          signup.setBackground(Color.BLACK);
          signup.setForeground(Color.WHITE);
            signup.addActionListener(this);
          add(signup);
          
          getContentPane().setBackground(Color.white);
        setSize(800,480);//dimension ^defined
        setVisible(true);
        setLocation(350,200); // kaha dikh rha h 
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
//         button k click krne pe kya krna h ye hum isme define krte h
        //ae action event batayegi kon sa button click hua h
        
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==signin)
        {
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            String query = "select * from login where cardno = '"+cardnumber+"'  and  pin = '"+pinnumber+"' ";
            
            try
            { //resultset datatype
               ResultSet rs = c.stmt.executeQuery(query);
                
               if(rs.next()) //data matched
               {
//                   JOptionPane.showMessageDialog(null, "Log inned");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else
               {
                   //incorrect
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
               }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}

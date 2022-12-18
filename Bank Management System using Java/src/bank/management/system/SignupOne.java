
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{

    
    long random;
    JTextField nameInput, fnameInput, emailInput, pincodeInput, stateInput, cityInput, addressInput;
    JRadioButton male ,female, other, married, unmarried;
    JDateChooser datechooser ;
    JButton next;
    
    SignupOne(){
        
        //set bound only works when setlayout is null
        setLayout(null);
      
        setTitle("SignUp Form for NEW CUSTOMER");
        
          Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L));
    //formNo.
        JLabel formNo = new JLabel("Application Form No. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 20));
        formNo.setBounds(300,30,600,40);
        add(formNo);
    //Page 1
        JLabel pageNo = new JLabel("Page 1 : Personal Details");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setBounds(300,80,600,30);
        add(pageNo);
        
        //name
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,120,100,30);
        add(name);
        
         nameInput = new JTextField();
        nameInput.setFont(new Font("Raleway", Font.BOLD, 15));
        nameInput.setBounds(300, 120, 400, 30);
        add(nameInput);
        //fathers name
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,160,190,30);
        add(fname);
        
         fnameInput = new JTextField();
        fnameInput.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameInput.setBounds(300, 160, 400, 30);
        add(fnameInput);
        
        //DOB
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,200,200,30);
        add(dob);
       
        //DOB inputusing JCalender jar file
         datechooser = new JDateChooser();
        datechooser.setBounds(300,200,400,30);
        datechooser.setFont(new Font("Raleway", Font.BOLD, 15));
        add(datechooser);
        //gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,240,200,30);
        add(gender);
        
         
         male = new JRadioButton("Male");
        male.setBounds(300, 240,100,30);
        male.setFont(new Font("Raleway", Font.BOLD, 15));
         male.setBackground(Color.WHITE);
        add(male);
        
         female = new JRadioButton("Female");
        female.setBounds(450, 240,100,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        add(female);
        
        //dono select hojarhe h simultaneously, usko avoid krne k liye we use button group
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
         
        //email
         JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,280,200,30);
        add(email);
        
         emailInput = new JTextField();
        emailInput.setFont(new Font("Raleway", Font.BOLD, 15));
        emailInput.setBounds(300, 280, 400, 30);
        add(emailInput);
        
        
        //marital status
         JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,320,200,30);
        add(marital);
        
         married = new JRadioButton("Married");
        married.setBounds(300, 320,100,30);
        married.setFont(new Font("Raleway", Font.BOLD, 15));
         married.setBackground(Color.WHITE);
        add(married);
        
         unmarried = new JRadioButton("Unmarried");
         unmarried.setBounds(450, 320,150,30);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
         unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        
         other = new JRadioButton("Other");
        other.setBounds(620, 320,100,30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        add(other);
        
        //dono select hojarhe h simultaneously
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(other);
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        
        //address
         JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,360,200,30);
        add(address);
        
         addressInput = new JTextField();
        addressInput.setFont(new Font("Raleway", Font.BOLD, 15));
        addressInput.setBounds(300, 360, 400, 30);
        add(addressInput);
        //City
         JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,400,200,30);
        add(city);
        
         cityInput = new JTextField();
        cityInput.setFont(new Font("Raleway", Font.BOLD, 15));
        cityInput.setBounds(300, 400, 400, 30);
        add(cityInput);
        
        //state
         JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,440,200,30);
        add(state);
        
         stateInput = new JTextField();
        stateInput.setFont(new Font("Raleway", Font.BOLD, 15));
        stateInput.setBounds(300, 440, 400, 30);
        add(stateInput);
        
        //pincode
         JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,480,200,30);
        add(pincode);
        
         pincodeInput = new JTextField();
        pincodeInput.setFont(new Font("Raleway", Font.BOLD, 15));
        pincodeInput.setBounds(300, 480, 400, 30);
        add(pincodeInput);
        
        //next button
           next = new JButton("Next");
          next.setBounds(600, 600, 120, 30);
          next.setBackground(Color.BLACK);
          next.setForeground(Color.WHITE);
          next.addActionListener(this);
          add(next);
          
        setSize(800, 700);
        setLocation(350,10);
         getContentPane().setBackground(Color.white);
        setVisible(true);
}
    
     @Override
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random; // long to string
        String name = nameInput.getText();
        String fname = fnameInput.getText(); 
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        //check which is selected
        if(male.isSelected())
            gender = "Male";
        else if(female.isSelected())
            gender = "Female";
        
        String email = emailInput.getText();
        
        String marital = null;
        
        //check which is selected
        if(married.isSelected())
            marital = "Married";
        else if(unmarried.isSelected())
            marital = "Unmarried";
        else if(other.isSelected())
            marital = "Other";
        
         String address = addressInput.getText();
         String city = cityInput.getText();
         String state = stateInput.getText();
         String pincode = pincodeInput.getText();
         
         
         //database
         try
         {
             if(name.equals(""))
                 JOptionPane.showMessageDialog(null, "Name is required");
             else
             {
                 Conn c = new Conn();
                 String query = "insert into signupOne values('"+formno+"','"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"' )";
             c.stmt.executeUpdate(query);
             
             //nextButtonClicked
        {
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
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
            new SignupOne();
            
    }
}

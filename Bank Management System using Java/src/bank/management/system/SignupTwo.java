
package bank.management.system;
import javax.swing.*;
import java.awt.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField aadharInput, panInput;
    JRadioButton senYes, senNo, existingYes, existingNo;
    JComboBox religionInput,incomeInput, categoryInput, eduInput, occInput;
    String formno;
    JButton next;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        //set bound only works when setlayout is null
        setLayout(null);
      
        setTitle("NEW ACCOUNT APPLICATION FORM- Page 2");
        
    //Page 1
        JLabel pageNo = new JLabel("Page 2: Additional Details");
        pageNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pageNo.setBounds(280,50,600,30);
        add(pageNo);
        
        //religion
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,120,100,30);
        add(religion);
        
        String religionVal[] = {"Hindu", "Muslim", "Sikh", "Christians", "Other"};
       religionInput = new JComboBox(religionVal);
        religionInput.setBounds(300, 120, 400, 30);
               religionInput.setBackground(Color.WHITE);
        add(religionInput);
        
        //fathers name
        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,160,190,30);
        add(income);
        
         String incomeVal[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
         incomeInput = new JComboBox(incomeVal);
        incomeInput.setBackground(Color.WHITE);
        incomeInput.setBounds(300, 160, 400, 30);
        add(incomeInput);
        
        //DOB
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,200,200,30);
        add(category);
       

        String categoryVal[] = {"General", "OBC", "SC", "ST", "Other"};
         categoryInput = new JComboBox(categoryVal);
        categoryInput.setBounds(300,200,400,30);
        categoryInput.setBackground(Color.WHITE);
        add(categoryInput);
    
        //Education
        JLabel edu = new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,240,200,30);
        add(edu);
        //qualification label
         JLabel qua = new JLabel("Qualifications : ");
        qua.setFont(new Font("Raleway", Font.BOLD, 20));
        qua.setBounds(100,260,200,30);
        add(qua);
        
        String eduVal[] = {"Non Graduation", "Graduate", "Post- graduate", "Doctrate", "Other"};
        eduInput = new JComboBox(eduVal);
        eduInput.setBounds(300,250,400,30);
        eduInput.setBackground(Color.WHITE);
        add(eduInput);

        
        //marital status
         JLabel occ = new JLabel("Occupation : ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100,320,200,30);
        add(occ);
        
         String occVal[] = {"Student", "Self Employed", "Salaried", "Business", "Retired"};
        occInput = new JComboBox(occVal);
        occInput.setBounds(300,320,400,30);
        occInput.setBackground(Color.WHITE);
        add(occInput);
   
        //address
         JLabel pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,360,200,30);
        add(pan);
        
        panInput = new JTextField();
        panInput.setFont(new Font("Raleway", Font.BOLD, 15));
        panInput.setBounds(300, 360, 400, 30);
        add(panInput);
        //City
         JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,400,200,30);
        add(aadhar);
        
        aadharInput = new JTextField();
        aadharInput.setFont(new Font("Raleway", Font.BOLD, 15));
        aadharInput.setBounds(300, 400, 400, 30);
        add(aadharInput);
        
       
         JLabel senior = new JLabel("SeniorCitizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,440,200,30);
        add(senior);
        
       senYes = new JRadioButton("Yes");
         senYes.setBounds(300, 440,150,30);
        senYes.setFont(new Font("Raleway", Font.BOLD, 15));
         senYes.setBackground(Color.WHITE);
        add(senYes);
        
        
         senNo  = new JRadioButton("No");
        senNo.setBounds(480, 440,100,30);
        senNo.setBackground(Color.WHITE);
        senNo.setFont(new Font("Raleway", Font.BOLD, 15));
        add(senNo);
        
        //dono select hojarhe h simultaneously
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(senYes);
        seniorGroup.add(senNo);

        //pincode
         JLabel exist = new JLabel("Existing Account : ");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100,480,200,30);
        add(exist);
 
         existingYes = new JRadioButton("Yes");
         existingYes.setBounds(300, 480,150,30);
        existingYes.setFont(new Font("Raleway", Font.BOLD, 15));
         existingYes.setBackground(Color.WHITE);
        add(existingYes);
        
        
        existingNo  = new JRadioButton("No");
        existingNo.setBounds(480, 480,100,30);
        existingNo.setBackground(Color.WHITE);
        existingNo.setFont(new Font("Raleway", Font.BOLD, 15));
        add(existingNo);
        
        //dono select hojarhe h simultaneously
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);
        
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
    
        String religion = (String)religionInput.getSelectedItem();
        String category = (String)categoryInput.getSelectedItem(); 
        String education = (String)eduInput.getSelectedItem();
        String income = (String)incomeInput.getSelectedItem();
         String occupation = (String)occInput.getSelectedItem();
         
        String seniorcitizen = null;
        //check which is selected
        if(senYes.isSelected())
            seniorcitizen = "Yes";
        else if(senNo.isSelected())
            seniorcitizen = "No";
        
        String existingacc = null;
        
        //check which is selected
        if(existingYes.isSelected())
            existingacc = "Yes";
        else if(existingNo.isSelected())
            existingacc = "No";

         String aadhar = aadharInput.getText();
         String pan = panInput.getText();   
         
         //database
         try
         {
             if(aadhar.equals(""))
                 JOptionPane.showMessageDialog(null, "Fill required details");
             else
             {
                 Conn c = new Conn();
                 String query = "insert into signupTwo values('"+formno+"','"+religion+"', '"+category+"', '"+education+"', '"+income+"', '"+occupation+"', '"+seniorcitizen+"', '"+existingacc+"', '"+aadhar+"', '"+pan+"')";
             c.stmt.executeUpdate(query);
             
             setVisible(false);
            new SignupThree(formno).setVisible(true);
             }
         }
         catch(Exception e)
         {
             System.out.print(e);
         }
        
    }
    
    public static void main(String args[]) 
    {
            new SignupTwo("");
            
    }
}

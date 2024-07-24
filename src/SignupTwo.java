import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends  JFrame implements ActionListener {

    JTextField  pan, aadhar;
    JRadioButton  syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    JButton next;
    String formno;
  
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null); //by the way on frame text is is unbalance on out of frame the used setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    
   
        //JLabel 2 Personal 1: Additional Details
        JLabel personalDetails  = new JLabel("Page 2: Additional Details"); //write the somehting on frame 
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22 ));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        //JLabel 3 Religion
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        //Create String type Array Frist Drop Box
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christain", "Other"};
        religion = new JComboBox(valReligion); //This code used purose Drop Down Box 
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

 
        //JLabel 4
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        //Create a String type Array Second Drop Box
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        //JLabel 5 Date of Birth
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        //Create a String type Array Third Drop Box
        String incomecategory[] = {"Null", "< 1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

                                   
                                 
        //JLabel 6  Educ
        JLabel gender = new JLabel("Educitonal:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290,200,30);
        add(gender);
        
        //JLabel 7 Qualification
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315,200 ,30);
        add(email);

        //Create the String type Array Forth Drop Box
        String educationValues[] = {"Non Grducation", "Graducation", "Post Graducation", "PHD", "Other"}; 
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);



        //JLabel 8 Occupation
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200,30);
        add(marital);

        //Create the String type of Array Fifth Drop Box
        String occupationvalues[] = {"Salaried", "Self Employed", "Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

 
 
        //JLabel 9  PAN Card
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);



        //JLabel 10 Aadhar Number
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490, 200,30);
        add(city);

         aadhar = new JTextField();
         aadhar.setFont(new Font("Raleway",Font.BOLD, 14));
         aadhar.setBounds(300,490,400,30);
        add(aadhar);



        //JLabel 11  Senior Citizen
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200,30);
        add(state);
       
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(syes);
        maritialgroup.add(sno);

         
        //JLabel 12  Exisiting Account
        JLabel pincode = new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritialgroup = new ButtonGroup();
        emaritialgroup.add(eyes);
        emaritialgroup.add(eno);
      
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this);

 

        getContentPane().setBackground(Color.WHITE); //The all color class inside package in import java.awt.*;  change the background color of frame


        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
   }
   
    
    
    //Access the all Data in the Database
    public void actionPerformed(ActionEvent ae){
        
        String sreligion  =  (String) religion.getSelectedItem(); //setText
        String scategory =  (String) category.getSelectedItem(); //
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String sOccupation = (String) occupation.getSelectedItem();
       String  seniorcitizen = null;

        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if (syes.isSelected()){
            seniorcitizen = "No";
        }
   
        String  exisitingaccount = null;
        if(eyes.isSelected()){
             exisitingaccount= "Yes";
        }else if(eyes.isSelected()){
            exisitingaccount = "No";
    
        }
             
        String span = pan.getText();
        String saadhar = aadhar.getText();
         
        //Put the all value in Database 
        try{
             
                Conn c = new Conn();
                  String query = "insert into signuptoo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+sOccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
                  c.s.executeUpdate(query);             
                  
                  //Signup3 object
                  setVisible(false);
                  new SignupThree(formno).setVisible(true);

                  
        }  catch (Exception e){
            System.out.println(e);
             }                 
         }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }

}
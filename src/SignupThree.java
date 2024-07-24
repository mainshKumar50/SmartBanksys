import java.awt.Color;
import java.awt.Font;
import java.awt.event.*; //ActionListener
import java.util.Random;  //import java.uti.*;
import javax.swing.*;
public class SignupThree extends JFrame implements ActionListener{ 
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel;
    String formno;
 
    SignupThree(String formno){ 
        this.formno = formno;

       setLayout(null);
       

       //Label First
       JLabel l1 = new JLabel("Welcome to ATM"); 
       l1.setFont(new Font("Raleway", Font.BOLD, 22));
       l1.setBounds(280,40,400,40);
       add(l1);

       //Label Second
       JLabel type = new JLabel("Account Type:");
       type.setFont(new Font("Relaway", Font.BOLD, 22));
       type.setBounds(100,140,200,30);
       add(type);

       //Radio Button 1st
       r1 = new JRadioButton("Saving Account");
       r1.setFont(new Font("Realway", Font.BOLD, 16));
       r1.setBackground(Color.WHITE);
       r1.setBounds(100,180,150,20);
       add(r1);


       //Radio Button 2nd
       r2 = new JRadioButton("Fixed Deposit Account");
       r2.setFont(new Font("Realway", Font.BOLD, 16));
       r2.setBackground(Color.WHITE);
       r2.setBounds(350,180,250,20);
       add(r2);



       //Radio Button 3rd
       r3 = new JRadioButton("Current Account");
       r3.setFont(new Font("Realway", Font.BOLD, 16));
       r3.setBackground(Color.WHITE);
       r3.setBounds(100,220,250,20);
       add(r3);


       //Radio Button 4th
       r4 = new JRadioButton("Recurring Deposit Account");
       r4.setFont(new Font("Realway", Font.BOLD, 16));
       r4.setBackground(Color.WHITE);
       r4.setBounds(350,220,250,20);
       add(r4);

       //Create the Buttongroup Because i have two option in this form of radio button when i cliked button select both 
       ButtonGroup groupaccount = new ButtonGroup();
       groupaccount.add(r1);
       groupaccount.add(r2);
       groupaccount.add(r3);
       groupaccount.add(r4);


       //Label 3rd Card Number
       JLabel card = new JLabel("Card Number");
       card.setFont(new Font("Raleway",Font.BOLD,22));
       card.setBounds(100,300,200,30);
       add(card);

       //Label under in 3rd

       JLabel number = new JLabel("XXXX-XXXX-XXXX-7087");
       number.setFont(new Font("Raleway", Font.BOLD, 22));
       number.setBounds(330,300,300,30);
       add(number);

       JLabel carddetails = new JLabel("Your 16 Digit Card Number");
       carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
       carddetails.setBounds(100,330,300,30);
       add(carddetails);

       

       //Label 5th Pin Number
       JLabel pin = new JLabel("PIN:");
       pin.setFont(new Font("Raleway", Font.BOLD, 22));
       pin.setBounds(100,370,200,30);
       add(pin);

       //Label under in 4th

       JLabel pnumber = new JLabel("XXXX");
       pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
       pnumber.setBounds(330,370,330,30);
       add(pnumber);


       JLabel pindetail = new JLabel("Your 4 Digit Password");
       pindetail.setFont(new Font("Raleway", Font.BOLD,12));
       pindetail.setBounds(100, 400,300,30);
       add(pindetail);

       //Lable 5th  service Required
       JLabel service = new JLabel("Services Required:");
       service.setFont(new Font("Raleway", Font.BOLD, 22));
       service.setBounds(100,450,220,30);  
       add(service);


       //Create CheckBox C1  
       c1 = new JCheckBox("ATM CARD");
       c1.setBackground(Color.WHITE);
       c1.setFont(new Font("Raleway", Font.BOLD, 16));
       c1.setBounds(100,500,200,30);
       add(c1);

       //Create CheckBox c2
       c2 = new JCheckBox("Internet Banking");
       c2.setBackground(Color.WHITE);
       c2.setFont(new Font("Releway", Font.BOLD, 16));
       c2.setBounds(350,500,200,30);
       add(c2);

       //Cretae checkBox c3

       c3 = new JCheckBox("Mobile Banking");
       c3.setBackground(Color.WHITE);
       c3.setFont(new Font("Releway", Font.BOLD, 16));
       c3.setBounds(100,550,200,30);
       add(c3);

       //Create CheckBox c4
       c4 = new JCheckBox("Email & SMS Alerts");
       c4.setBackground(Color.WHITE);
       c4.setFont(new Font("Releway", Font.BOLD, 16));
       c4.setBounds(350,550,200,30);
       add(c4);

       //Create checkBox c5
       c5 = new JCheckBox("Cheque Book");
       c5.setBackground(Color.WHITE);
       c5.setFont(new Font("Releway", Font.BOLD, 16));
       c5.setBounds(100,600,200,30);
       add(c5);


       //Create CheckBox c6
       c6 = new JCheckBox("E-Statement");
       c6.setBackground(Color.WHITE);
       c6.setFont(new Font("Releway", Font.BOLD, 16));
       c6.setBounds(350,600,200,30);
       add(c6);

       //Create CheckBox c7
       c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of knowledge");
       c7.setBackground(Color.WHITE);
       c7.setFont(new Font("Releway", Font.BOLD, 12));
       c7.setBounds(100,680,600,30);
       add(c7);
        

       //Create the Submit Button
       submit = new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway", Font.BOLD, 14));
       submit.setBounds(250,720,100,30);
       submit.addActionListener(this);
       add(submit);

       //Create Cancel  Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
       add(cancel);

        getContentPane().setBackground(Color.WHITE); //Change the frame background color (i mena all page background color

    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
      
  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        String accountType = null;
        if(r1.isSelected()){
            accountType = "Saving Account";
        }else if(r2.isSelected()){
            accountType = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            accountType = "Current Account";
        }else if(r4.isSelected()){
            accountType ="Reccuring Deposit Account";
        }
        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);

        String pinnumber = "" +Math.abs((random.nextLong() % 9000L) + 1000L);

        String  facility = "";
        if(c1.isSelected()){
           facility = facility + " ATM Card";
        } else if(c2.isSelected()){
            facility = facility + " Internet Banking";
        }else if(c3.isSelected()){
            facility = facility + " Mobile Banking";
        }else if(c4.isSelected()){
            facility = facility + " EMAIL & SMS Alerts";
        }else if(c5.isSelected()){
            facility = facility + " Cheque Book";
        }else if(c6.isSelected()){
            facility = facility + " E-Statements";
        }
         //Exceptional Handling Because When i Run the Progam then can occur the error
         try {
           if(accountType.equals("")){
            JOptionPane.showMessageDialog(null,"Account Type is Required");
           }else{
            Conn conn = new Conn();
            String query1 = "insert into Signup3 values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')"; 
            String query2 = "insert into login values ('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber+ "\n pin: "+ pinnumber);
 
             setVisible(false);
             new Deposit(pinnumber).setVisible(false);

           }
             
         } catch (Exception e) {
            System.out.println(e);
         }

    }else if(ae.getSource() == cancel){
        setVisible(false);
        new Login().setVisible(true);

    }
    
  }

    public static void main(String[] args) {
        new SignupThree("");
 
    }
}
 

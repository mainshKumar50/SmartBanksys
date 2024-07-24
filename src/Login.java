 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
 
public class Login extends JFrame implements ActionListener{

    JButton login, singup, clear; //Therefore Define the three button because i'll able to access outside of constructor class.
    JTextField cardTextField;
    JPasswordField pinTextField;


    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        

        setLayout(null); 
        
        //Set the image in frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,  Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable1 = new JLabel(i3);
        lable1.setBounds(70, 10, 100, 100);
        add(lable1);   

        //lablel 1st
        JLabel text = new JLabel("Welcome to ATM");   //We are using Jlable write something on frame 
        text.setFont(new  Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40); //set the location of content variable in text
        add(text); 


        //label 2nd 
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new  Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 25); //set the location of content variable in cardno
        add(cardno);

        // "JTextField" Just Create a text_area box 
        cardTextField =  new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        //label 3rd
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 40); //set the location of content variable in pin
        add(pin);
        
        //Textarea box there i will fill the any pin no 1st
        pinTextField =  new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        //Create the Sing IN button (login)
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener((this)); //This is one type of function jo (button ke event ko catch karne ke liy used karte hain)
        add(login);


        //Create a Clear Button
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        

        //Create a Singup Button
        singup = new JButton("SIGN UP");
        singup.setBounds(300, 350, 230, 30);
        singup.setBackground(Color.BLACK);
        singup.setForeground(Color.WHITE);
        singup.addActionListener(this);
        add(singup);

        getContentPane().setBackground(Color.WHITE); //Change the background color of Frame 
  
        setSize(800,480);
        setVisible(true);
        setLocation(350, 200);
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin"); //When Open the login frame page then enter any card number and pin show the Incorrect card number or Pin
                    
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if(ae.getSource() == singup){

            //create a object hidden the login page open the next page signupOne
            setVisible(false); //This is code of logic when i click the button signup then open the next page
            new SignupOne().setVisible(true); // Open the next page like form of user


        }

    }
    public static void main(String args[]){
        new Login();
    }
    
}


 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
//public class PinChange extends JFrame implements ActionListener{
public class PinChange extends JFrame implements ActionListener{

    String pinnumber;
    JButton change,back;
    JPasswordField repin, pin;

PinChange(String pinnumber){
    this.pinnumber = pinnumber;
 

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

    //Label first
    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    text.setBounds(250,255,500,35);
    image.add(text);

    //JLabel second New pin
    JLabel pintext = new JLabel("New PIN:");
    pintext.setForeground(Color.WHITE);
    pintext.setFont(new Font("System", Font.BOLD, 16));
    pintext.setBounds(160,320,180,25);
    image.add(pintext);

     //Create JTextFields New PIN
     pin = new JPasswordField();
     pin.setFont(new Font("Raleway",Font.BOLD,25));
     pin.setBounds(315,320,190,25);
     image.add(pin);

    //JLabel third Re-enter New Pin 
    JLabel repintext = new JLabel("Re-Enter New PIN:");
    repintext.setForeground(Color.WHITE);
    repintext.setFont(new Font("System",Font.BOLD, 16));
    repintext.setBounds(160,360,180,25);
    image.add(repintext);

    //Create JTextField Re-Enter New PIN
    repin = new JPasswordField();
    repin.setFont(new Font("Raleway", Font.BOLD, 25));
    repin.setBounds(315,360,190,25);
    image.add(repin);

    //Create Button CHANGE First Button
    change = new JButton("CHANGE");
    change.setBounds(355,455,150,30);
    change.addActionListener(this);
    image.add(change);

    // Create Button of BACK Second Button
    back = new JButton("BACK");
    back.setBounds(355,490,150,30);
    back.addActionListener(this);
    image.add(back);



     setSize(900,900);
     setLocation(300,0);
     setUndecorated(true);
     setVisible(true);

}

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == change) {
        // Handle change button click
        try {
            String npin = pin.getText();
            String rpin = repin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }

            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }

            // Assuming Conn is handling database connections correctly
            Conn conn = new Conn();
            String query1 = "update bank set pin = '" + rpin +"'  where pin='" + pinnumber + "'";
            String query2 = "update login set pin = '" + rpin +"'  where pin='" + pinnumber + "'";
            String query3 = "update signup3 set pin = '" + rpin +"'  where pin='" + pinnumber + "'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true);

        } catch (Exception e) {
           System.out.println(e);
        }
    }  else{

       
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}
 

public static void main(String[] args) {
    new PinChange("").setVisible(true);
}   
}
                                                                                                                   


                 





 /* 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(280,330,800,35);
        l4.add(l1);
        
        l2.setBounds(180,390,150,35);
        l4.add(l2);
        
        l3.setBounds(180,440,200,35);
        l4.add(l3);
        
        t1.setBounds(350,390,180,25);
        l4.add(t1);
        
        t2.setBounds(350,440,180,25);
        l4.add(t2);
        
        b1.setBounds(390,588,150,35);
        l4.add(b1);
        
        b2.setBounds(390,633,150,35);
        l4.add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
     
    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if (ae.getSource() == b1) {
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return;
                }
                
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
    
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
    
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
        
            } else if (ae.getSource() == b2) { // Correct placement for handling BACK button
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
            

    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}

*/
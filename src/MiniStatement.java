import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
public class MiniStatement extends JFrame{

    //Create Constructor

    MiniStatement(String pinnumber){

        setTitle("Mini Statement");
        setLayout(null);


        //Create first Jlabel
        JLabel mini = new JLabel();
        add(mini);

        //Create second JLabel
        JLabel bank = new JLabel("Bank of India");
        bank.setBounds(150,20,100,20);
        add(bank);

        //Create third JLabel
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        //Create fourth JLabel
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

       //Create Try block
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXX" + rs.getString("cardnumber").substring(11));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        //Create second try block

         try {
            int bals = 0;
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
            mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +  "<br><br><html>");            
            if(rs.getString("type").equals("Deposit")){
                bals += Integer.parseInt(rs.getString("amount"));

            }else{
                bals -= Integer.parseInt(rs.getString("amount"));
            }
            }
            balance.setText("Your current Account Balance is Rs " + bals);
             
         } catch (Exception e) {
            System.out.println(e);
         }

         mini.setBounds(20,175,400,200);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        
        //Create object
        new MiniStatement("");

    }
 }
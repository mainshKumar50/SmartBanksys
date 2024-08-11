import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

    JButton  onehund, fivehund, onek, twok, fivek, tenk, exit;
    String pinnumber;
    FastCash(String pinnumber){
    this.pinnumber = pinnumber;
     
           
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
         
         //Label First
         JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(210,280,700,30);
         text.setForeground(Color.WHITE);   
         text.setFont(new Font("System",Font.BOLD, 16));
         image.add(text);  //set the text of upon the image

         //Create  100
         onehund= new JButton("RS 100");
         onehund.setBounds(160,390,150,29);
         onehund.addActionListener(this);
         image.add( onehund);
         
         //Create Deposit Button on the Image
         fivehund = new JButton("RS 500");
         fivehund.setBounds(350,390,150,29);
         fivehund.addActionListener(this);
         image.add(fivehund);

         //Create Fast Cash Button on the Image
         onek = new JButton("RS 1000");
         onek.setBounds(160,425,150,29);
         onek.addActionListener(this);
         image.add(onek);

         //Create Mini Statement Button on the Image
         twok = new JButton("RS 2000");
         twok.setBounds(350,425,150,29);
         twok.addActionListener(this);
         image.add( twok);

         //Create Pin Change Button on the Image
         fivek = new JButton("RS 5000");
         fivek.setBounds(160,460,150,29);
         fivek.addActionListener(this);
         image.add(fivek);

         //Create balance Enquery Button on the Image
         tenk = new JButton("RS 10000");
         tenk.setBounds(350,460,150,29);
         tenk.addActionListener(this);
         image.add(tenk);
         
         //Create BACK Button
         exit = new JButton("BACK");
         exit.setBounds(350,493,150,29);
         exit.addActionListener(this);
         image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
            
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //RS  500
            
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance  = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){

                        balance += Integer.parseInt(rs.getString("amount"));

                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }



            if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS "+ amount + "Debited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
             
        }


    public static void main(String[] args) {
        new FastCash("");
    }
   
}
 
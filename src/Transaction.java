import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Transaction extends JFrame implements ActionListener{

    JButton deposit, withdrawl, ministatement, pinchange,fastcash,balanceenquiry, exit; //Globally Define the all button
    String pinnumber;
    Transaction(String pinnumber){
    this.pinnumber = pinnumber;

  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

         
         //Label First
         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(210,280,700,30);
         text.setForeground(Color.WHITE);   
         text.setFont(new Font("System",Font.BOLD, 16));
         image.add(text);  //set the text of upon the image

         //Create Deposit Button on the Image
         deposit = new JButton("Deposit");
         deposit.setBounds(160,390,150,29);
         deposit.addActionListener(this);
         image.add(deposit);
         
         //Create Deposit Button on the Image
         withdrawl = new JButton("Cash Withdraw");
         withdrawl.setBounds(350,390,150,29);
         withdrawl.addActionListener(this);
         image.add(withdrawl);

         //Create Fast Cash Button on the Image
          fastcash = new JButton("Fash Cash");
         fastcash.setBounds(160,425,150,29);
         fastcash.addActionListener(this);
         image.add(fastcash);

         //Create Mini Statement Button on the Image
         ministatement = new JButton("Mini Statement");
         ministatement.setBounds(350,425,150,29);
         ministatement.addActionListener(this);
         image.add(ministatement);

         //Create Pin Change Button on the Image
         pinchange = new JButton("Pin Change");
         pinchange.setBounds(160,460,150,29);
         pinchange.addActionListener(this);
         image.add(pinchange);

         //Create balance Enquery Button on the Image
         balanceenquiry = new JButton("Balance Enquery");
         balanceenquiry.setBounds(350,460,150,29);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         //Create Exit Button on the Image
         exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
     
        }else if (ae.getSource() == fastcash) {
            setVisible(false);    
            new FastCash(pinnumber).setVisible(true);
            
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        }   else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);

        }else if(ae.getSource() == ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
  
 

    public static void main(String[] args) {
        new Transaction("");
    }
    
}

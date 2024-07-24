import java.sql.*;  

public class Conn{
    Connection c;
    static Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");   
            System.out.println("wegfiu");
             c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmssystem","root","software@8600##");    
             System.out.println("Software");
             s = c.createStatement();
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }
    }  
}  

    
 

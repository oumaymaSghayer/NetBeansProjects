package javaapplication1;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JavaApplication1 {

      public static Connection getConnection()
    {
        Connection con = null;
        
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd","root","");
            System.out.println("cnx good to go");
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
     public static String getUser(String id)
        {
            Connection con = getConnection();
            String query = "SELECT * FROM user WHERE iduser="+id;
             Statement st;
             ResultSet rs;
             String m="0";
       try {
         st = con.createStatement();
         rs = st.executeQuery(query);
         rs.next();
         m=rs.getString("nom");}
           catch (SQLException ex) 
        {
          System.out.println(ex.getMessage());
        }

        return m;

        }
    public static void main(String[] args) {
        // TODO code application logic here
            Scanner s = new Scanner(System.in);
            System.out.println("entrer votre code:");
            String code=s.next();
            System.out.println("user is :"+getUser(code));
        
    }
    
    
}

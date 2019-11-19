/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static javaapplication1.InsertInto.connexion;

/**
 *
 * @author Oumayma
 */
public class Deletedb {
         public static Connection connexion() throws Exception {
       String url="jdbc:mysql://127.0.0.1:3306/try";
       String name="root";
       String user="";
       String driver="com.mysql.jdbc.Driver";
       try {
            Class.forName(driver).newInstance();
            Connection con=DriverManager.getConnection(url,name,"");
            return con;
            
            }
      // catch (SQLException ex) {System.out.println(ex.getMessage());}
       catch (Exception e) {System.out.println(e.getMessage());return null;}
       
       
   }
         
         public static void main(String args []) 
         { try{
              Connection cx=connexion();
              Statement commande=cx.createStatement();
              String query = "delete from user where id = ?";
              PreparedStatement preparedStmt = cx.prepareStatement(query);
              preparedStmt.setInt(1, 0);
              preparedStmt.execute();
              System.out.print("c bon!");
              cx.close();
            }
          catch(SQLException e) {System.out.println(e.getMessage());}
          catch(Exception e) {System.out.println(e.getMessage());}
         }
}

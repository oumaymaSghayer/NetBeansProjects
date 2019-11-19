/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javaapplication1.InsertInto.connexion;

/**
 *
 * @author Oumayma
 */
public class Selectdb {
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
       public static void main(String args[]) 
       {
            try {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            String o="oumayma";
            String req="SELECT * From user where name = '"+o+"';";
            ResultSet rs = commande.executeQuery(req);
            while (rs.next())
      {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String pass= rs.getString("passwd");
        System.out.println(id +" "+name+" "+pass );}
            cx.close();
       
            System.out.println("c bon!");
           
           }
           catch(SQLException e) {System.out.println(e.getMessage());}
           catch(Exception e) {System.out.println(e.getMessage());}
           }
       }


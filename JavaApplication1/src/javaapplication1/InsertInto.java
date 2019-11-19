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

/**
 *
 * @author Oumayma
 */
public class InsertInto {
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
       
       public static void main (String args[]) 
       {
           try {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            String nom="ouma";
            String password="1234";
            int id=5;
            String req="INSERT INTO user(id,name,passwd) VALUES(?,?,?);";
              PreparedStatement preparedStmt = cx.prepareStatement(req);
             preparedStmt.setString (1, "0");
             preparedStmt.setString (2, "ouma");
             preparedStmt.setString(3, "1234");
            preparedStmt.execute();
            cx.close();
         //   commande.executeUpdate(req);// si j'utilise le nom : erreur sql (unknown column 'user_name' )
            System.out.println("c bon!");
            //Statement state = conn.createStatement();
            //state.executeUpdate("INSERT INTO utilisateur VALUES(1,nom,prenom,password,datean,sexe,taille,lieu,adresse)");
           }
           catch(SQLException e) {System.out.println(e.getMessage());}
           catch(Exception e) {System.out.println(e.getMessage());}
           }
    
}

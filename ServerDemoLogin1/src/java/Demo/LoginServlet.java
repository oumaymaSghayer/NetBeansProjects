/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oumayma
 */
public class LoginServlet extends HttpServlet {

    Connection connexion=null;
    String user=null;
    String pass=null;
     public void init()
    {
        System.out.println("--------------------------");
        System.out.println("init method has been called and serlvet is initialized");
        System.out.println("--------------------------");
        String url="jdbc:mysql://127.0.0.1:3306/bd";
        String name="root";
        String pwd="";
        String driver="com.mysql.jdbc.Driver";
        try 
        {
            Class.forName(driver).newInstance();
            connexion=(Connection) DriverManager.getConnection(url, name,"");
        }
        catch(Exception e)
        {
            System.out.println("Error while loading");
        }
    }
    /** RequestDispatcher rd = request.getRequestDispatcher("/LoginServlet.java");
			rd.forward(request, response);**/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        try
        {   
            user=request.getParameter("name");
            pass=request.getParameter("pass");
            String q="select * from user where nom="+user+";";
            Statement commande=connexion.createStatement();
            ResultSet rs=commande.executeQuery(q);
            String username=null;
            String password=null;
            while(rs.next())
            {
                username=rs.getString(2);
                password=rs.getString(4);
            }
            if (username.equals(user)&&password.equals(pass))
            {
                System.out.println("Login successful!");
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out =response.getWriter())
                {
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<title> Servlet loginServlet </title>");
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<h1>Servlet loginServlet at"+request.getContextPath()+"</h1>");
                   out.println("login successful!"+username);
                   out.println("</body>");
                   out.println("</html>");
                }
            }
            
            else 
            {
                System.out.println("login failure..");
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out =response.getWriter())
                {
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<title> Servlet loginServlet </title>");
                   out.println("</head>");
                   out.println("<body>");
                   //out.println("<h1>Servlet loginServlet at"+request.getContextPath()+"</h1>");
                   out.println("login failure!");
                   out.println("</body>");
                   out.println("</html>");
                }
            }
            rs.close();
            commande.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
  @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } 

 
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     processRequest(request, response);
    }

 

}

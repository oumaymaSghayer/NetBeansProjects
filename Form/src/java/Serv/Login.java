/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oumayma
 */
public class Login extends HttpServlet {

 
   public Connection connexion() throws Exception {
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
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        /**************/
          try 
        {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            ResultSet rs=commande.executeQuery("select * from user where name= '"+name+"';");// si j'utilise le nom : erreur sql (unknown column 'user_name' )
            String username="null";
            String password="null";
            while(rs.next()) 
        {
            username=(rs.getString(2));
            password=(rs.getString(3));
            
        } 
             if(username.equals(name)&&password.equals(pass)){
                System.out.println("login successful!");
                this.getServletContext().getRequestDispatcher("/Welcome").forward(request, response);}
             else 
             {   
                 this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
             }
           //  if(!username.equals(name)) {this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);}
        }
          catch (SQLException e) 
          {
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SQLException:  " +e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
          }
          catch (Exception e) 
          {
                 response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exception at: " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
          }
          
        
        
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

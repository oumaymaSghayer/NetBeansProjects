/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Introduction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oumayma
 */
public class S1_hello extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String url="jdbc:mysql://127.0.0.1:3306/bd";
              String name="root";
                String pwd="";
              String driver="com.mysql.jdbc.Driver";
        try 
        {
            Class.forName(driver).newInstance();
            Connection connexion = (Connection) DriverManager.getConnection(url, name,"");
           String user=request.getParameter("name");
           String  pass=request.getParameter("pass");
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
            out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<head>");
                   out.println("<title> Servlet loginServlet </title>");
                   out.println("</head>");
                   out.println("<body>");
                   out.println("<h1>les donnée sont: "+username+" et "+password+"</h1>");
                   
                   out.println("</body>");
                   out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println("Error while loading");
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

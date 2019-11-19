/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DemoLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
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
 * @author rim
 */
public class LoginServlet extends HttpServlet {
    String user=null;
    String pass=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     public Connection connexion()throws RemoteException{
        String url="jdbc:mysql://localhost/db?autoReconnect=true&useSSL=false";
        String name="root";
        String user="";
        String driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver).newInstance();
            Connection con=DriverManager.getConnection(url,name,user);
            return con;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        catch(Exception e){
            return null;
        }
    }
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        user=request.getParameter("name");
        pass=request.getParameter("pass");
        
        try{
        Connection cx=connexion();
        String q="select * from user where username='"+user+"'";
            Statement commande=cx.createStatement();
            ResultSet rs=commande.executeQuery(q);
            String username="null";
            String password="null";
            while(rs.next()){
                username=rs.getString(2);
                password=rs.getString(3);
            }
        if(username.equals(user)&&password.equals(pass)){
   
            System.out.println("Login Successful !");
            request.setAttribute("user", user);
            request.setAttribute("pass", pass);
            
            this.getServletContext().getRequestDispatcher("/Accueil").forward(request, response);
            
           
            /*RequestDispatcher rd=request.getRequestDispatcher("/Welcome");
            rd.forward(request, response);*/
            
            //RequestDispatcher rd=request.getRequestDispatcher("/SessionTrack");
            //rd.forward(request, response);
            
            /*RequestDispatcher rd=request.getRequestDispatcher("/HelloForm");
            rd.forward(request, response);*/
            
            /*String message="Bonjour!";
            request.setAttribute("variable", message);
            String nom=user;
            request.setAttribute("variable1", nom);
            request.setAttribute("heure", "soir");
            this.getServletContext().getRequestDispatcher("/bonjour.jsp").forward(request, response);*/
            
            
        }
        else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("<h1 style=\"color:red;\"> Echec </h1>");
            out.println("<h1 style=\"color:blue;\">Login Failure ... ! </h1>");
            out.println("</body>");
            out.println("</html>");
        }
        }
        }
         
       catch(SQLException e){
            System.out.println(e.getMessage());
           
        }
       catch(Exception e){
           System.out.println(e.getMessage());
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

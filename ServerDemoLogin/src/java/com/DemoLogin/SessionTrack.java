/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DemoLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rim
 */
public class SessionTrack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String user=(String) session.getAttribute( "theName" );
        String pass=(String) session.getAttribute( "thePass" );
        
        Date createTime=new Date(session.getCreationTime());
        Date lastAccessTime=new Date(session.getLastAccessedTime());
        
        String title = "welcome back to your page";
        Integer visitCount=new Integer(0);
        String visitCountKey=new String("visitCount");
        String userIDKey=new String("userID");
        String userID=new String("ABCD");
        int interval=new Integer(0);
        if(session.isNew()){
            title="welcome back to your page "+ user;
            session.setAttribute(userIDKey,userID);
            
            session.setAttribute("name",user);
            session.setAttribute("pass",pass);
        }else{
            visitCount=(Integer)session.getAttribute(visitCountKey);
            //visitCount=visitCount+1; THIS LINE GENERATE ERROR 500 !!!
            userID=(String)session.getAttribute(userIDKey);
            interval=session.getMaxInactiveInterval();
        }
        session.setAttribute(visitCountKey, visitCount);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+title+"</title>");            
            out.println("</head>");
            out.println("<body bgcolor=\"#f0f0f0\">");
            out.println("<h1 align=\"center\">"+title+"</h1>");
            out.println("<h1 align=\"center\">Session Information</h2>");
            out.println("<table border=\"1\" align=\"center\">");
            out.println("<tr bgcolor=\"#949494\"><th>Session Info</th><th>value</th></tr>");
            out.println("<tr>");
            out.println("<td>id</td>");
            out.println("<td>"+session.getId()+"</td></tr>");
            out.println("<tr>");
            out.println("<td>Creation Time</td>");
            out.println("<td>"+createTime+"</td></tr>");
            out.println("<tr>");
            out.println("<td>Time of Last Access</td>");
            out.println("<td>"+lastAccessTime+"</td></tr>");
            out.println("<tr>");
            out.println("<td>User ID</td>");
            out.println("<td>"+userID+"</td></tr>");
            out.println("<tr>");
            out.println("<td>Number of visits</td>");
            out.println("<td>"+visitCount+"</td></tr>");
            out.println("<tr>");
            out.println("<td>Session delay</td>");
            out.println("<td>"+interval+"</td></tr>");
            out.println("</table>");
            out.println("<form action=\"http://localhost:8080/ServerDemoLogin/DeleteSession\" method=\"post\">");
            out.println("<center><input type=\"submit\" value=\"logout\"/></center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

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


public class LoginServlet extends HttpServlet {
    String user=null;
    String pass=null;
   
   public Connection connexion() throws Exception {
       String url="jdbc:mysql://127.0.0.1:3306/bd";
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
        
            user=request.getParameter("name");
            pass=request.getParameter("pass");
        try 
        {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            ResultSet rs=commande.executeQuery("select * from user where iduser= "+1+";");// si j'utilise le nom : erreur sql (unknown column 'user_name' )
            String username="null";
            String password="null";
            while(rs.next()) 
        {
            username=(rs.getString(2));
            password=(rs.getString(4));
            
        }   
            if(username.equals(user)&&password.equals(pass)){
                System.out.println("login successful!");
           /** response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>login successful " + user + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }**/
           String message="Bonjour!";
           request.setAttribute("variable", message);
           String nom=user;
            request.setAttribute("variable1", nom);
            request.setAttribute("heure", "soir");
            
           this.getServletContext().getRequestDispatcher("/bonjour.jsp").forward(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("/HelloForm");
            rd.forward(request, response);
            }
           else 
            {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>login failed" + username + "</h1>");
            out.println("</body>");
            out.println("</html>");  
            }}
        cx.close();
        rs.close();
        commande.close();
        }
        catch (SQLException e) {System.out.println(e.getMessage());
         response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Servlet LoginServlet</title>");            
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<h1>" +e.getMessage()+ "</h1>");
                 out.println("</body>");
                 out.println("</html>");
        }}
        catch (Exception e) {System.out.println(e.getMessage());  response.setContentType("text/html;charset=UTF-8");
          try (PrintWriter out = response.getWriter()) {
                 out.println("<!DOCTYPE html>");
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Servlet LoginServlet</title>");            
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<h1>" +e.getMessage()+ "</h1>");
                 out.println("</body>");
                 out.println("</html>");
        }
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

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

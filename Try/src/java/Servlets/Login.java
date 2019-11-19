
package Servlets;

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
import javax.servlet.http.HttpSession;


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
     
     public void exist ( String name,String passwd) 
     {  try {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            ResultSet rs=commande.executeQuery("select * from user where iduser= "+1+";");
            String username="null";
            String password="null";
            while(rs.next()) 
            {
            username=(rs.getString(2));
            password=(rs.getString(4));
            }   
            if(username.equals(name)&&password.equals(password))
            {
                
            }
            else {}
            }
        catch (SQLException e) {}
        catch (Exception e) {}
     
     }
     

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get parameters : 
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        //create session
       // HttpSession session = request.getSession();
        // 
        try {
            Connection cx=connexion();
            Statement commande=cx.createStatement();
            ResultSet rs=commande.executeQuery("select * from user where id= " +1+";");
            String username="null";
            String password="null";
            while(rs.next()) 
            {
            username=(rs.getString(2));
            password=(rs.getString(3));
            }   
            if(username.equals(name)&&password.equals(passwd))
            {
                this.getServletContext().getRequestDispatcher("/Bienvenu").forward(request, response);
            }
            else {this.getServletContext().getRequestDispatcher("/Loginfailed").forward(request, response);}
            }
        catch (SQLException e) 
        {
              response.setContentType("text/html;charset=UTF-8");
              try (PrintWriter out = response.getWriter()) {
            
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Exception</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>SQLException: " +e.getMessage()+ "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    }
        }
        catch (Exception e) 
        {
              response.setContentType("text/html;charset=UTF-8");
              try (PrintWriter out = response.getWriter()) {
            
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Exception</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Exception: " +e.getMessage()+ "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                    } 
        }
        
        
        
        
        
        
        
        
        
        
        
      //  this.getServletContext().getRequestDispatcher("/Bienvenu").forward(request, response);
      //  RequestDispatcher rd = request.getRequestDispatcher("/Bienvenu");
      //  rd.forward(request, response);
        
        
        
        
        
        
        
      
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

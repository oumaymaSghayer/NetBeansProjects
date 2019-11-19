
package Demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
  
 
public class SessionTrack extends HttpServlet {
  
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      /***************************************/
       String user=request.getParameter("name");
       String pass=request.getParameter("pass");
       //create session if not already created
       HttpSession session = request.getSession();
       java.sql.Date createTime=new java.sql.Date(session.getCreationTime());
       java.sql.Date lastAccessTime=new java.sql.Date(session.getLastAccessedTime());
       
       String title = "welcome back to your page";
       Integer visitCount=new Integer(0);
       String visitCountKey=new String("visitCount");
       String userIDKey=new String("userID");
       String userID=new String("ABCD");
       int interval=new Integer(0);
       if(session.isNew()){ // if new
            title="welcome back to your page "+ user;
            //save him
            session.setAttribute(userIDKey,userID);
            session.setAttribute("name",user);
            session.setAttribute("pass",pass);
        }else{
            visitCount=(Integer)session.getAttribute(visitCountKey);
            visitCount=+1; 
            userID=(String)session.getAttribute(userIDKey);
            interval=session.getMaxInactiveInterval();
        }
      /***************************************/
     
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
 
      String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                 "<h2 align=\"center\">Session Infomation</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session info</th><th>value</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>Creation Time</td>\n" +
                "  <td>" + createTime + 
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Time of Last Access</td>\n" +
                "  <td>" + lastAccessTime + 
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>User ID</td>\n" +
                "  <td>" + userID + 
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Number of visits</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
              "<tr>\n" +
                "  <td>Session delay</td>\n" +
                "  <td>" + interval + "</td></tr>\n" +
                "</table>\n" +
      
              "<form action=\"http://localhost:8080/ServerDemoLogin2/DeleteSession\" method=\"POST\"> "+
              "<center><input type=\"submit\" value=\"Logout\"/></center>" +
              "</form>"+
              "</body></html>");
  }
}
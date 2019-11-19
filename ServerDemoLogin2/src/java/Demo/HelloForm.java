/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author IBM
 */
public class HelloForm extends HttpServlet {
 
   public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      /***************************************/
      String user = request.getParameter("name");
      String pass = request.getParameter("pass");
      //create cookies once and for all
      Cookie Pwd = new Cookie("pass",pass);
      Cookie UserName = new Cookie("name",user);
      //set cookies age to 1 day
      UserName.setMaxAge(60*60*24);
      Pwd.setMaxAge(60*60*24);
      //add cookies to the response
      response.addCookie(UserName);
      response.addCookie(Pwd);
      
      /***************************************/
 
      // Set response content type
      response.setContentType("text/html");
  
      PrintWriter out = response.getWriter();
      String title = "My Cookie Works!!";
      String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Name</b>: "
                + request.getParameter("name") + "\n" +
                "  <li><b>Pwd</b>: "
                + request.getParameter("pass") + "\n" +
                "</ul>\n" +
                "</body></html>");
  }
}
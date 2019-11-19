
package Filtres;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
 
public class AuthentificationFilter implements Filter {
     
    private FilterConfig filterConfig = null;
    //A filter is simply a Java class that implements the javax.servlet.Filter interface. 
    //The javax.servlet.Filter interface defines three methods.
    public void  init(FilterConfig config) throws ServletException{
      //This method is called by the web container to indicate to a filter that it is being placed into service.
      System.out.println("----------------------------------------------------");
      System.out.println("init method is called in "+ this.getClass().getName());
      System.out.println("----------------------------------------------------");
   }
   public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException 
   {  
      //This method is called by the container each time a request/response pair is passed 
      //through the chain due to a client request for a resource at the end of the chain.
        System.out.println("doFilter method is called in "+this.getClass().getName());
        PrintWriter out = response.getWriter();
        String username=request.getParameter("name");
        String password=request.getParameter("pass");
        if(username.equals("admin") && password.equals("admin"))
        { //sends request to next resource
        chain.doFilter(request, response);
        }
        else { out.print("Username or Password is not correct!");}
       
       
   }
   public void destroy( ){
       //This method is called by the web container to indicate to a filter 
       //that it is being taken out of service.
      System.out.println("-------------------------------------------------------");
      System.out.println("destroy method is called in "+ this.getClass().getName());
      System.out.println("-------------------------------------------------------");
   }
     
}
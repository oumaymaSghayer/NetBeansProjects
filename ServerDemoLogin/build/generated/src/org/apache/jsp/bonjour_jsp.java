package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bonjour_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>welcome</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>menu</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"color:red;\">Choose!</h1>\n");
      out.write("       \n");
      out.write("    ");
 
    
    String name=request.getParameter("name");
    session.setAttribute( "theName", name );
   
    String pass=request.getParameter("pass");
    session.setAttribute( "thePass", pass );
    
    
      out.write(" \n");
      out.write("        <ul>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <li><a href=\"/ServerDemoLogin/Welcome\"><b>Welcome</b></a></li>\n");
      out.write("            <li><a href=\"/ServerDemoLogin/SessionTrack\"><b>SessionTrack</b></a></li>\n");
      out.write("            <li><a href=\"/ServerDemoLogin/HelloForm\"><b>HelloForm</b></a></li>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <p>\n");
      out.write("            ");
 String variable=(String)request.getAttribute("variable");
            //out.println(variable);
            
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("            ");
 String variable1=(String)request.getAttribute("variable1");
            //out.println(variable1);
            
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("           ");
 String heure=(String)request.getAttribute("heure"); 
           if(heure.equals("jour")){
               out.println("<h1 style=\"color:green;\">Bonjour!</h1>");}
           else{
               out.println("<h1 style=\"color:blue;\">Bonsoir!</h1>");
           }
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("            ");
 for(int i=0;i<6;i++)
                out.println("<b style=\"color:green;\"> Hello</b>  "+ variable1 +"  ! <br/>");
      out.write("\n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

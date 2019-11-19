<%-- 
    Document   : menu
    Created on : 21 mars 2019, 11:22:34
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP menu</title>
    </head>
    <body>
           <% 
                  String name=request.getParameter("name");
                  session.setAttribute( "name", name );
   
                  String pass=request.getParameter("pass");
                  session.setAttribute( "pass", pass );
          %> 
            <ul>
            
            
            <li><a href="/ServerDemoLogin2/Acceuil"><b>Acceuil</b></a></li>
            <li><a href="/ServerDemoLogin2/LoginServlet"><b>Bonjour</b></a></li>
           
            
            
            </ul>
    </body>
</html>

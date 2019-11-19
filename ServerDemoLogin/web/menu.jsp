<%-- 
    Document   : menu
    Created on : Feb 15, 2019, 6:05:53 PM
    Author     : rim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
    </head>
    <body>
        <h1 style="color:red;">Choose!</h1>
       
    <% 
    
    String name=request.getParameter("name");
    session.setAttribute( "theName", name );
   
    String pass=request.getParameter("pass");
    session.setAttribute( "thePass", pass );
    
    %> 
        <ul>
            
            
            <li><a href="/ServerDemoLogin/Welcome"><b>Welcome</b></a></li>
            <li><a href="/ServerDemoLogin/SessionTrack"><b>SessionTrack</b></a></li>
            <li><a href="/ServerDemoLogin/HelloForm"><b>HelloForm</b></a></li>
            
            
        </ul>
    </body>
</html>

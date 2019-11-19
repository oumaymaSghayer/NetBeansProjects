<%-- 
    Document   : accueil
    Created on : Feb 15, 2019, 6:19:53 PM
    Author     : rim
--%>

<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <h1 style="color:red;">Hello <%= session.getAttribute( "theName" ) %></h1>
        
        
    </body>    
       
    
</html>

<%-- 
    Document   : welcome
    Created on : 24 mars 2019, 13:56:50
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
       
         <% String name=(String)request.getParameter("name");
            out.println("Welcome! "+name);
            %>
            <br>
            <a href="login.jsp">Retour</a>
    </body>
</html>

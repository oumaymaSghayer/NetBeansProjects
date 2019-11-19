<%-- 
    Document   : bienvenu
    Created on : 21 mars 2019, 16:03:42
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Welcome to your page!</h1>
          <% String name=(String)request.getParameter("name");
            out.println(name);
            %>
            <br>

    </body>
</html>

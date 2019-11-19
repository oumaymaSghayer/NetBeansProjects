<%-- 
    Document   : login
    Created on : 21 mars 2019, 15:51:48
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
        <h1>form:</h1>
         <form action="Login" method="POST">
            <p>
                Name : <input type="text" name="name" id="name"/>  
            </p>
             <p>
                Password : <input type="password" name="passwd" id="passwd"/>  
            </p>
            <input type="submit" value="login"/>
            <input type="submit" value="sign in"/>
        </form>
    </body>
</html>

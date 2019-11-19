<%-- 
    Document   : login
    Created on : 24 mars 2019, 09:56:35
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        
         <form action="Login" method="POST">
             <table style="background-color: skyblue;margin-left: 20px;margin-right: 20px;">
            <tr><td>UserName:</td><td><input type="text" name="name"  /></td></tr> 
            <tr><td>Password:</td><td><input type="password" name="pass"  /></td></tr> 
            <tr><td><input type="submit" value="Login"/></td><td><a href="register.jsp">Register</a></td></tr> 
              
        </table>
        </form>
    </body>
</html>

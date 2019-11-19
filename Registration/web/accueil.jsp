<%-- 
    Document   : Accueil
    Created on : 24 mars 2019, 09:42:41
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>accueil</title>
    </head>
    <body>
        <form action="Accueil" method="POST">
        <table>
            <tr><td>UserName:</td><td><input type="text" name="name"  /></td></tr> 
            <tr><td>Password:</td><td><input type="password" name="pass"  /></td></tr> 
            <tr><td><input type="submit" value="Login"/></td><td><a href="register.jsp">Register</a></td></tr> 
            
        </table>
        </form>
    </body>
</html>

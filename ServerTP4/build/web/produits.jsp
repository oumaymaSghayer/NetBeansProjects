<%-- 
    Document   : produits
    Created on : Feb 26, 2019, 5:09:34 PM
    Author     : rim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <h1>Hello!</h1>
        <h2>
            <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom}">
                <p>Vous etes ${ sessionScope.prenom} ${ sessionScope.nom}</p>
            </c:if>
        </h2>
    </body>
</html>

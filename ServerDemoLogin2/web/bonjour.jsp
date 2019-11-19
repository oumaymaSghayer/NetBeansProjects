<%-- 
    Document   : bonjour
    Created on : 21 mars 2019, 10:57:09
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bonjour JSP </title>
    </head>
    <body>
         <%@include file="menu.jsp" %>
        <p>
            <% String variable=(String)request.getAttribute("variable");
            out.println(variable);
            %>
        </p>
        <p>
            <% String variable1=(String)request.getAttribute("variable1");
            out.println(variable1);
            %>
        </p>
         <p>
           <% String heure=(String)request.getAttribute("heure"); 
              out.println("<h1 style=\"color:green;\">---"+heure+"---</h1>");
           if(heure.equals("jour")){
               out.println("<h1 style=\"color:green;\">Bonjour!</h1>");}
           else{
               out.println("<h1 style=\"color:blue;\">Bonsoir!</h1>");
           }%>
        </p>
         <p>
            <% for(int i=0;i<6;i++)
                out.println("<b style=\"color:green;\"> Hello</b>  "+ variable1 +"  ! <br/>");%>
        </p>
        
    </body>
</html>

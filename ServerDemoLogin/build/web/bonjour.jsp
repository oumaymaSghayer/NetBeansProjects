<%-- 
    Document   : bonjour
    Created on : Feb 15, 2019, 5:48:46 PM
    Author     : rim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <p>
            <% String variable=(String)request.getAttribute("variable");
            //out.println(variable);
            %>
        </p>
        <p>
            <% String variable1=(String)request.getAttribute("variable1");
            //out.println(variable1);
            %>
        </p>
        <p>
           <% String heure=(String)request.getAttribute("heure"); 
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

<%-- 
    Document   : accueil
    Created on : 21 mars 2019, 11:59:12
    Author     : Oumayma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil JSP</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1> <center> Mon acceuil</center></h1>
        <form action="Accueil" method="POST">
            <p>
                Name : <input type="text" name="name" id="name"/>  
            </p>
             <p>
                Familyname : <input type="text" name="familyname" id="familyname"/>  
            </p>
            <input type="submit"/>
        </form>
    <c:if test="${!empty sessionScope.familyname && !empty sessionScope.name}">
        <p>Vous etes: ${sessionScope.name} ${sessionScope.familyname}</p>
    </c:if>
        <p>----------------------------------------------------------------------------</p>
             <p>
            <% String message=(String)request.getAttribute("message");
            out.println(message);
            %>
        </p>
        <p>
            <% String nom=(String)request.getAttribute("nom");
            out.println(nom);
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
                out.println("<b style=\"color:green;\"> Hello</b>  "+ nom +"  ! <br/>");%>
        </p>
        <p>----------------------------------------------------------------------------</p>
        <%! 
            int cpt =0;%>
          <%!  int getCpt() {return cpt++;}
            %>
            <h1> <%=getCpt() %> </h1>
         <p>----------------------------------------------------------------------------</p>
         <% int aleat = (int) (Math.random()*5); %>
          <h1> Nombre aleatoir : <%=aleat %> </h1>
          <p>----------------------------------------------------------------------------</p>
          <p>
              Bonjour
              ${6*5}
              ${20*3}
              <br> Par du Java: <br>
              <%
                  String nom2=(String) request.getAttribute("nom");
              %>
              <br> Par du EL: <br>
              ${empty nom ? '' : nom }
              <br>Manipulation des tableaux EL: <br>
              Element 0: ${noms[0]} <br>
              Element 1: ${noms[1]} <br>
          </p>
                 <p>----------------------------------------------------------------------------</p>
    </body>
</html>

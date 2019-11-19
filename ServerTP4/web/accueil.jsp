<%-- 
    Document   : accueil
    Created on : Feb 23, 2019, 3:59:19 PM
    Author     : rim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        
        <h1>Welcome!</h1>
        <h2><p>
        <% String variable=(String)request.getAttribute("variable");
            out.println(variable);
        %>
        
        
        <% String variable1=(String)request.getAttribute("variable1");
            out.println(variable1);
        %>
            </p></h2>
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
                out.println("<b style=\"color:green;\"> Hello  IF4  ! </b><br/>");%>
        </p>
        <p>----------------------------------------------------------</p>
        <%!
            int cpt=0;
            int getCpt(){return cpt++;}
        %>
        <h1><%=getCpt()%></h1>
        <p>----------------------------------------------------------</p>
        <%!
            int alea=(int)(Math.random()*5);%>
          
        
        <h1>Nombre aléatoire : <%=alea%></h1>
        <p>----------------------------------------------------------</p>
        
        <p>Bonjour
                ${ 6*5 }
                ${ 20*3 }
                <br> Par du JAVA : <br>
                <%
                    String variable2=(String)request.getAttribute("variable1");
                    out.println(variable2);
                    
                    %>
                    <br> La deuxième est évalué par Expression Langage EL <br>
                    ${ empty variable1 ? '':variable1 }
                    
                </p>
                <p>
                    Manipulation d'un tableau El <br>
                    Element 0: ${noms[0] } <br>
                    Element 1: ${noms[1] } <br>
                    
                </p>
        <p>----------------------------------------------------------</p>
        <form action="Accueil" method="POST">
            <p>
                <label for="nom"> Nom : </label>
                <input type="text" name="nom" id="nom" /><br>
            </p>
            <p>
                <label for="prenom"> Prenom : </label>
                <input type="text" name="prenom" id="prenom" /><br>
            </p>
                <input type="submit" value="Entrer"/><br>
        </form>
        <p>----------------------------------------------------------</p>
        
    </body>
</html>
       
        

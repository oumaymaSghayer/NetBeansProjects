<%-- 
    Document   : welcome
    Created on : Mar 5, 2019, 8:29:09 PM
    Author     : rim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <h1 >Hello World!</h1>
        <h2>Java Beans </h2> <br>
        
${ auteur.prenom } <br>
${ auteur.nom } <br>
${ auteur.actif ? 'actif':'inactif' }

<h2> JSTL : Java server pages Standard Tag Library !</h2>
<h3>Affichage d'un message en utilisant le langage de la JSTL</h3>
<p> <c:out value="Bonjour ! "/> </p>

<h3> La JSTL permet de définir des variables dans la JSP: (balise c:set) </h3>
<p> Définir la variable à l'intérieur de la balise </p>
<p> <c:set var="pseudo" value="Ali" scope="page"/></p>
<p> <c:out value="${ pseudo }"/> </p>

<h3> Modification d’une variable avec la JSTL </h3>
<p> <c:set var="pseudo" scope="page">Mohamed</c:set></p>
<p> <c:out value="${ pseudo }"/> </p>

<h3>Modification des beans avec la syntaxe de la JSTL </h3>
[Ancienne valeur du prénom:]${ auteur.prenom }
<p> <c:set target="${ auteur }" property="prenom"
value="Mohamed"/></p>
[Nouvelle valeur du prénom:]
<p> <c:out value="${ auteur.prenom }"/></p>

<h3> Les tests avec la JSTL </h3>
<p> Utilisation de la balise c:if </p>
<c:if test= "${ 60 > 50 }">
60 > 50 C'est vrai !
</c:if> <br>
<c:if test= "${ 50 > 60 }">
50 > 60 C'est vrai !
</c:if> <br>

<c:choose>
<c:when test="${ variable }"> Du texte </c:when>
<c:when test="${ variable2 }"> Du texte1 </c:when>
<c:when test="${ variable3 }"> Du texte2 </c:when>
<c:otherwise>otherwise</c:otherwise>
</c:choose>

<h3> Affichage d'un même message plusieurs fois </h3>
<c:forEach begin="0" end="4" step="1">
<p> Un message ! </p>
</c:forEach>
<p> ---------------------------------------------- </p>
<h3> Affichage d'un même message plusieurs fois [pas=1]</h3>
<c:forEach var="i" begin="0" end="4" step="1">
<p> Un message numéro: <c:out value=" ${ i }"/> ! </p>
</c:forEach>
<p> ---------------------------------------------- </p>
<h3> Affichage d'un même message plusieurs fois [pas=2] </h3>
<c:forEach var="i" begin="0" end="4" step="2">
<p> Un message numéro: <c:out value=" ${ i }"/> ! </p>
</c:forEach>
<p> ---------------------------------------------- </p>
<h3> Parcourir des tableaux </h3>
<c:forEach items="${ noms }" var="nom">
<p> <c:out value=" ${ nom }"/> ! </p>
</c:forEach>
<p> ---------------------------------------------- </p>
<h3> Parcourir des tableaux de 0 à 1 </h3>
<c:forEach items="${ noms }" var="nom" begin="0" end="1">
<p> <c:out value=" ${ nom }"/> ! </p>
</c:forEach>
<p> ---------------------------------------------- </p>
<h3> Boucle forTokens pour les chaînes de caractères </h3>
<!--La boucle forTokens: items contient la chaîne qu'on veut
découper -->
<c:forTokens var="morceau" items="Un élément/Un autre
élément/Un dernier élément" delims="/">
<p> ${ morceau } </p>
</c:forTokens>

    </body>
</html>

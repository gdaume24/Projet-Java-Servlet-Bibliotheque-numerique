<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.koor.hello.model.Livre"%>
<%
    Livre livre = (Livre) request.getAttribute("livre");
    boolean isModification = (livre != null);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/common.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/ajouterModifierLivre.css">
<title><%= isModification ? "Modifier un livre" : "Ajouter un livre" %></title>
</head>
<body>
	<h2><%= isModification ? "Modifier un livre" : "Ajouter un livre" %></h2>
	<form method='post' action="<%= isModification ? "modifierLivre" : "ajouterLivre" %>">
		<% if (isModification) { %>
		<input type="hidden" name="idLivre" value="<%= livre.getId() %>" />
		<% } %>
		<label for='titreLivre'>Titre :</label>
		<input id='titreLivre' name='titreLivre' type='text' value="<%= isModification ? livre.getTitre() : "" %>" required /><br>
		<label for='auteurLivre'>Auteur :</label>
		<input id='auteurLivre' name='auteurLivre' type='text' value="<%= isModification ? livre.getAuteur() : "" %>" required/><br>
		<label for='ISBNLivre'>Numéro ISBN :</label>
		<input id='ISBNLivre' name='ISBNLivre' type='text' value="<%= isModification ? livre.getIsbn() : "" %>" required/><br>
		<label for='anneePublicationLivre'>Année de publication :</label>
		<input id='anneePublicationLivre' name='anneePublicationLivre' type='number' value="<%= isModification ? livre.getAnneePublication() : null %>" required/><br>
		<label for='genreLivre'>Genre :</label>
		<input id='genreLivre' name='genreLivre' type='text' value="<%= isModification ? livre.getGenre() : "" %>" required/><br>
		<button type="submit">Valider</button>
	</form>
    <!-- Message dynamique -->
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
                <div class="message_confirmation_form"><%= message %></div>
    <%	}  %>
    <form action="home" method="get">
        <button type="submit">⬅ Retour au menu principal</button>
    </form>
</body>
</html>
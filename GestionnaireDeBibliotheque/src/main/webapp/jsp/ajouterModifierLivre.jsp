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
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/common.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/ajouterModifierLivre.css?v=<%= System.currentTimeMillis() %>">
<title><%= isModification ? "Modifier un livre" : "Ajouter un livre" %></title>
</head>
<body>
	<h2><%= isModification ? "Modifier un livre" : "Ajouter un livre" %></h2>
    <form action="home" method="get" id="buttonRetourForm">	
        <button type="submit" id="buttonRetour">⬅ Retour au menu principal</button>
    </form>
	<form method='post' action="<%= isModification ? "modifierLivre" : "ajouterLivre" %>">
		<% if (isModification) { %>
		<input type="hidden" name="idLivre" value="<%= livre.getId() %>" />
		<% } %>
		 <div class="form-row">
		 	<label for='titreLivre'>Titre :</label>
			<input id='titreLivre' name='titreLivre' type='text' value="<%= isModification ? livre.getTitre() : "" %>" required /><br>
		 </div>
		<div class="form-row">
			<label for='auteurLivre'>Auteur :</label>
			<input id='auteurLivre' name='auteurLivre' type='text' value="<%= isModification ? livre.getAuteur() : "" %>" required/><br>
		</div>
		<div class="form-row">
			<label for='ISBNLivre'>Numéro ISBN :</label>
			<input id='ISBNLivre' name='ISBNLivre' type='text' value="<%= isModification ? livre.getIsbn() : "" %>" required/><br>
		</div>
		<div class="form-row">
			<label for='anneePublicationLivre'>Année de publication :</label>
			<input id='anneePublicationLivre' name='anneePublicationLivre' type='number' value="<%= isModification ? livre.getAnneePublication() : null %>" required/><br>
		</div>
		<div class="form-row">
			<label for='genreLivre'>Genre :</label>
			<input id='genreLivre' name='genreLivre' type='text' value="<%= isModification ? livre.getGenre() : "" %>" required/><br>
		</div>
		<div class="form-row" id="div-button">
			<button type="submit" id="buttonValider">Valider</button>
		</div>
	    <!-- Message dynamique -->
	    <%
	        String message = (String) request.getAttribute("message");
	        if (message != null) {
	    %>
        <div class="message_confirmation_form"><%= message %></div>
	    <%	}  %>
	</form>
</body>
</html>
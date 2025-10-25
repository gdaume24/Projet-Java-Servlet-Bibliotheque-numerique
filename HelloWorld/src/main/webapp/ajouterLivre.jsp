<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Entrez le titre du livre -->
	<form method='post' action='ajouterLivre'>
		<label for='titreLivre'>Titre :</label>
		<input id='titreLivre' name='titreLivre' type='text' value='${titre}' /><br>
		<label for='auteurLivre'>Auteur :</label>
		<input id='auteurLivre' name='auteurLivre' type='text' value='${auteur}' /><br>
		<label for='ISBNLivre'>Numéro ISBN :</label>
		<input id='ISBNLivre' name='ISBNLivre' type='text' value='${ISBN}' /><br>
		<label for='anneePublicationLivre'>Année de publication :</label>
		<input id='anneePublicationLivre' name='anneePublicationLivre' type='number' value='${anneePublication}' /><br>
		<label for='genreLivre'>Genre :</label>
		<input id='genreLivre' name='genreLivre' type='text' value='${genre}' /><br>
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
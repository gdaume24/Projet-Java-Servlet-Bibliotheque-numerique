<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, com.koor.hello.model.Livre" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/common.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/consulterLivres.css">
   	<script src="js/notification.js"></script> 
	<title>Insert title here</title>
</head>
<body>
    <h1>Liste des Livres</h1>
    <% 
    String message = (String) session.getAttribute("message");
	if (message != null) { 
	%>
    	<div id="notification" class="message_confirmation_form"><%= message %></div>
    <% 
    	session.removeAttribute("message");
	} 
	%>
    <form action="consulterLivres" method="post">				
	    <input type="text" name="titre" placeholder="Rechercher un livre par titre" size="50" value="<%= request.getAttribute("titreRecherche") != null ? request.getAttribute("titreRecherche") : "" %>">
	    <button type="submit">🔍 Rechercher</button>
	</form>
    <%
    	List<Livre> livres = (List<Livre>) request.getAttribute("livres");
    %>
    <table border="1">
       <thead>
	       <tr>
	           <th>ID</th>
	           <th>Titre</th>
	           <th>Auteur</th>
	           <th>ISBN</th>
	           <th>Année</th>
	           <th>Genre</th>
	           <th>Modifier</th>
	           <th>Supprimer</th>
	       </tr>
       </thead>
       <tbody>
       <%
       		for (Livre livre : livres) {
       %>
  			<tr>
  				<td><%= livre.getId() %></td>
  				<td><%= livre.getTitre() %></td>
  				<td><%= livre.getAuteur() %></td>
  				<td><%= livre.getIsbn() %></td>
  				<td><%= livre.getAnneePublication() %></td>
  				<td><%= livre.getGenre() %></td>
  				<td>
 				    <form action="modifierLivre" method="get" style="display: block;">				
			            <input type="hidden" name="id" value="<%= livre.getId() %>">
 						<button 
						type="submit" 
						style="color: blue; text-decoration: underline; cursor: pointer; background-color: Transparent; border: none; display: block;
						"
						>
						Modifier
						</button>
 					</form>  				</td>
 				<td>
 				    <form action="supprimerLivre" method="post" style="display: block;">				
			            <input type="hidden" name="id" value="<%= livre.getId() %>">
 						<button 
						type="submit" 
						onclick="return confirm('Supprimer ce livre ?')" 
						style="color: red; text-decoration: underline; cursor: pointer; background-color: Transparent; border: none; display: block;
						"
						>
						Supprimer
						</button>
 					</form>
  				</td>
  			</tr>
  		<%
       		}
  		%>
      	</tbody>
    </table>
   	<form action="home" method="get">
       	<button type="submit">⬅ Retour au menu principal</button>
   	</form>
</body>
</html>
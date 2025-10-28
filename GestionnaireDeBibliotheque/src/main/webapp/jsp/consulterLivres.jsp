<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, com.koor.hello.model.Livre" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css?v=<%= System.currentTimeMillis() %>">
    <link rel="stylesheet" type="text/css" href="css/myCss/common.css?v=<%= System.currentTimeMillis() %>">
    <link rel="stylesheet" type="text/css" href="css/myCss/consulterLivres.css?v=<%= System.currentTimeMillis() %>">
   	<script src="js/notification.js?v=<%= System.currentTimeMillis() %>"></script> 
	<title>Insert title here</title>
</head>
<body>
    <h1>Liste des Livres</h1>
    <% 
    String messageModification = (String) session.getAttribute("messageModification");
    String messageDeletion = (String) session.getAttribute("messageDeletion");
	if (messageModification != null) { 
	%>
    	<div id="message_modification" class="notification"><%= messageModification %></div>
    <% 
    	session.removeAttribute("messageModification");
	} 
	if (messageDeletion != null) { 
	%>
    	<div id="message_deletion" class="notification"><%= messageDeletion %></div>
    <% 
    	session.removeAttribute("messageDeletion");
	} 
	%>
	<div class="formAndTableContainer">
		<form action="consulterLivres" method="post" class="formRecherche">				
		    <input type="text" name="titre" placeholder="Rechercher un livre par titre" size="80%" class="inputRechercheParTitre" value="<%= request.getAttribute("titreRecherche") != null ? request.getAttribute("titreRecherche") : "" %>">
		    <button type="submit" class="buttonRechercher">🔍 Rechercher</button>
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
	 				    <form action="modifierLivre" method="get" class="tableActionForm">				
				            <input type="hidden" name="id" value="<%= livre.getId() %>">
	 						<button 
							type="submit" 
							class="boutonTable"
							id="bouton-modifier-table"
							>
							Modifier
							</button>
	 					</form>  				
 					</td>
	 				<td>
	 				    <form action="supprimerLivre" method="post" class="tableActionForm">				
				            <input type="hidden" name="id" value="<%= livre.getId() %>">
	 						<button 
	 						class="boutonTable"
 						 	id="bouton-supprimer-table"
							type="submit" 
							onclick="return confirm('Supprimer ce livre ?')" 
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
       	<form action="home" method="get" class="retourMenuButtonForm">
       		<button type="submit" class="buttonForm">⬅ Retour au menu principal</button>
   		</form>
	</div>

</body>
</html>
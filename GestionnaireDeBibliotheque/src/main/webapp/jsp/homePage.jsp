<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/common.css">
    <link rel="stylesheet" type="text/css" href="css/myCss/homePage.css">
    <title>Gestionnaire de Livres</title>
</head>
<body>
    <h1>Gestionnaire de Livres</h1>
	<div class="formulaires">
		<form class="first-form" action="ajouterLivre" method="get">
	        <button type="submit">Ajouter un nouveau livre</button>
	    </form>
	
	    <form action="consulterLivres" method="get">
	        <button type="submit">Consulter la liste de tous les livres</button>
	    </form>
	</div>
</body>
</html>

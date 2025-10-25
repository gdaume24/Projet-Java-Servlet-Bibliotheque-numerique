<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestionnaire de Livres</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        form {
            margin-bottom: 10px;
        }
        button {
            padding: 8px 16px;
            border: none;
            background-color: #1976d2;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #125aa0;
        }
    </style>
</head>
<body>
    <h1>Gestionnaire de Livres</h1>

    <form action="ajouterLivre" method="get">
        <button type="submit">Ajouter un nouveau livre</button>
    </form>

    <form action="consulterLivres" method="get">
        <button type="submit">Consulter la liste de tous les livres</button>
    </form>

    <form action="rechercherLivreParTitre" method="get">
        <button type="submit">Rechercher un livre par son titre</button>
    </form>

    <form action="modifierLivre" method="get">
        <button type="submit">Modifier un livre existant</button>
    </form>

    <form action="supprimerLivre" method="get">
        <button type="submit">Supprimer un livre</button>
    </form>

    <form action="quitterApp" method="get">
        <button type="submit">Quitter l'application</button>
    </form>
</body>
</html>

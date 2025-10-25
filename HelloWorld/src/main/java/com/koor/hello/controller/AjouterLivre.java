package com.koor.hello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koor.hello.bdd.DBConnection;

/**
 * Servlet implementation class AjouterLivre
 */
@WebServlet("/ajouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final String query = "INSERT INTO Livres(titre, auteur, isbn, annee_publication, genre) VALUES (?, ?, ?, ?, ?);";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterLivre() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ajouterLivre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titreLivre");
		String auteur = request.getParameter("auteurLivre");
		String isbn = request.getParameter("ISBNLivre");
		String annee = request.getParameter("anneePublicationLivre");
		int anneePublication;
	    anneePublication = Integer.parseInt(annee); 
		String genre = request.getParameter("genreLivre");
    	try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);) {
    		ps.setString(1, titre);
    		ps.setString(2, auteur);
    		ps.setString(3, isbn);
    		ps.setInt(4, anneePublication);
    		ps.setString(5, genre);
    		int count = ps.executeUpdate();
    		if (count == 1) {
                request.setAttribute("message", "✅ Le livre a été ajouté à la base de données !");
    		} else {
                request.setAttribute("message", "❌ Une erreur est survenue lors de l'enregistrement du livre.");
			}
    	}catch (SQLException se) {
    		se.printStackTrace();
            request.setAttribute("message", "❌ Erreur SQL : " + se.getMessage());
    	}
        request.getRequestDispatcher("ajouterLivre.jsp").forward(request, response);
	}
}

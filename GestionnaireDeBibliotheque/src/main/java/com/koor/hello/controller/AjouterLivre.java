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

import com.koor.hello.DAO.LivreDAO;
import com.koor.hello.bdd.DBConnection;
import com.koor.hello.model.Livre;

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
        request.getRequestDispatcher("jsp/ajouterModifierLivre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titreLivre");
		String auteur = request.getParameter("auteurLivre");
		String isbn = request.getParameter("ISBNLivre");
		int anneePublication = Integer.parseInt(request.getParameter("anneePublicationLivre"));
		String genre = request.getParameter("genreLivre");
		
	    Livre livre = new Livre(titre, auteur, isbn, anneePublication, genre);

	    boolean success = LivreDAO.ajouterLivre(livre);

	    if (success) {
	        request.setAttribute("message", "✅ Le livre a été ajouté à la base de données !");
	    } else {
	        request.setAttribute("message", "❌ Une erreur est survenue lors de l'enregistrement du livre.");
	    }
        request.getRequestDispatcher("jsp/ajouterModifierLivre.jsp").forward(request, response);
	}
}

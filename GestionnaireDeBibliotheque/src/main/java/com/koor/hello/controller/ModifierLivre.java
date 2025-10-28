package com.koor.hello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koor.hello.DAO.LivreDAO;
import com.koor.hello.bdd.DBConnection;
import com.koor.hello.model.Livre;

@WebServlet("/modifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLivre = Integer.parseInt(request.getParameter("id"));
		Livre livreAModifier = LivreDAO.getLivreById(idLivre);
        request.setAttribute("livre", livreAModifier);
        request.getRequestDispatcher("jsp/ajouterModifierLivre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idLivre"));
        String titre = request.getParameter("titreLivre");
		String auteur = request.getParameter("auteurLivre");
		String isbn = request.getParameter("ISBNLivre");
		int anneePublication = Integer.parseInt(request.getParameter("anneePublicationLivre"));
		String genre = request.getParameter("genreLivre");
		Livre livre = new Livre(id, titre, auteur, isbn, anneePublication, genre);
		boolean success = LivreDAO.modifierLivre(livre);
        if (success) {
        	request.getSession().setAttribute("messageModification", "✅ Le livre a bien été modifié !");
 		} else {
             request.getSession().setAttribute("messageModification", "❌ Une erreur est survenue lors de la modification.");
			}
        response.sendRedirect(request.getContextPath() + "/consulterLivres");
	}
}

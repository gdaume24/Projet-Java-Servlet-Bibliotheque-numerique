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

import com.koor.hello.bdd.DBConnection;
import com.koor.hello.model.Livre;

/**
 * Servlet implementation class ModifierLivres
 */
@WebServlet("/modifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLivre = Integer.parseInt(request.getParameter("id"));
		String sql = "SELECT * FROM Livres WHERE id = ?";
        Livre livre = null;
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
        	    
    	    ps.setInt(1, idLivre);
    	    
    	    try (ResultSet rs = ps.executeQuery()) {
    	        if (rs.next()) {
    	            livre = new Livre(
    	                rs.getInt("id"),
    	                rs.getString("titre"),
    	                rs.getString("auteur"),
    	                rs.getString("isbn"),
    	                rs.getInt("annee_publication"),
    	                rs.getString("genre")
    	            );
    	        }
    	    }
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
        request.setAttribute("livre", livre);
        request.getRequestDispatcher("jsp/ajouterModifierLivre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "UPDATE Livres SET titre=?, auteur=?, isbn=?, annee_publication=?, genre=? WHERE id = ?";
        int id = Integer.parseInt(request.getParameter("idLivre"));
        String titre = request.getParameter("titreLivre");
		String auteur = request.getParameter("auteurLivre");
		String isbn = request.getParameter("ISBNLivre");
		int anneePublication = Integer.parseInt(request.getParameter("anneePublicationLivre"));
		String genre = request.getParameter("genreLivre");
    	try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);) {
    		ps.setString(1, titre);
    		ps.setString(2, auteur);
    		ps.setString(3, isbn);
    		ps.setInt(4, anneePublication);
    		ps.setString(5, genre);
    		ps.setInt(6, id);
    		int count = ps.executeUpdate();
    		if (count == 1) {
                request.getSession().setAttribute("messageModification", "✅ Le livre a bien été modifié !");
    		} else {
                request.getSession().setAttribute("messageModification", "❌ Une erreur est survenue lors de la modification.");
			}
    	} catch (SQLException se) {
    		se.printStackTrace();
    	}
        response.sendRedirect(request.getContextPath() + "/consulterLivres");
	}
}

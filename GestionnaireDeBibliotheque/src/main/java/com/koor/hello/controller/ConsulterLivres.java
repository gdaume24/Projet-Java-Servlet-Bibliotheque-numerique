package com.koor.hello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koor.hello.bdd.DBConnection;
import com.koor.hello.model.Livre;

/**
 * Servlet implementation class ConsulterLivres
 */
@WebServlet("/consulterLivres")
public class ConsulterLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String requestSQL = "SELECT * FROM Livres";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterLivres() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livre> livres = new ArrayList<>();
    	try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(requestSQL);
		ResultSet rs = ps.executeQuery()) {
    		while(rs.next()) {
	        	int id = rs.getInt("id");
	        	String isbn = rs.getString("isbn");
	        	String titre = rs.getString("titre");
	        	String auteur = rs.getString("auteur");
	        	int anneePublication = rs.getInt("annee_publication");
	        	String genre = rs.getString("genre");
		        livres.add(new Livre(id, titre, auteur, isbn, anneePublication, genre));
    		}
    	} catch (SQLException se) {
    		request.setAttribute("message", "Erreur lors de la récupération des livres :" + se.getMessage());
	        se.printStackTrace(); 
    	}
        request.setAttribute("livres", livres);
        request.getRequestDispatcher("jsp/consulterLivres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titreRecherche = request.getParameter("titre");
        String requestSQLRechercheLivre = "SELECT * FROM Livres WHERE titre LIKE ?;";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(requestSQLRechercheLivre)) {
        	ps.setString(1, "%" + titreRecherche + "%");
            ResultSet rs = ps.executeQuery();

            List<Livre> livresTrouves = new ArrayList<>();

            while (rs.next()) {
	        	int id = rs.getInt("id");
	        	String isbn = rs.getString("isbn");
	        	String titre = rs.getString("titre");
	        	String auteur = rs.getString("auteur");
	        	int anneePublication = rs.getInt("annee_publication");
	        	String genre = rs.getString("genre");
	        	
		        livresTrouves.add(new Livre(id, titre, auteur, isbn, anneePublication, genre));
            }
            
            request.setAttribute("livres", livresTrouves);
            request.getRequestDispatcher("jsp/consulterLivres.jsp").forward(request, response);
            
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
}

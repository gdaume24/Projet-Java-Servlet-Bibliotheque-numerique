package com.koor.hello.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koor.hello.bdd.DBConnection;
import com.koor.hello.model.Livre;

public class LivreDAO {
	public static boolean ajouterLivre(Livre livre) {
        String query = "INSERT INTO Livres (titre, auteur, isbn, annee_publication, genre) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);) {

            ps.setString(1, livre.getTitre());
            ps.setString(2, livre.getAuteur());
            ps.setString(3, livre.getIsbn());
            ps.setInt(4, livre.getAnneePublication());
            ps.setString(5, livre.getGenre());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public static List<Livre> getLivres() {
	    String requestSQL = "SELECT * FROM Livres";
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
	        se.printStackTrace(); 
    	}
    	return livres;
	}
	
	public static Livre getLivreById(int id) {
		String sql = "SELECT * FROM Livres WHERE id = ?";
        Livre livre = null;
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
        	    
    	    ps.setInt(1, id);
    	    
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
        return livre;
	}
	
	public static boolean modifierLivre(Livre livre) {
		String sql = "UPDATE Livres SET titre=?, auteur=?, isbn=?, annee_publication=?, genre=? WHERE id = ?";
        
    	try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);) {
    		ps.setString(1, livre.getTitre());
    		ps.setString(2, livre.getAuteur());
    		ps.setString(3, livre.getIsbn());
    		ps.setInt(4, livre.getAnneePublication());
    		ps.setString(5, livre.getGenre());
    		ps.setInt(6, livre.getId());
    		return ps.executeUpdate() == 1;
    	} catch (SQLException se) {
    		se.printStackTrace();
    		return false;
    	}
	}
	
	public static boolean supprimerLivreById(int id) {
		String sql = "DELETE FROM Livres WHERE id = ?";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	
	
}

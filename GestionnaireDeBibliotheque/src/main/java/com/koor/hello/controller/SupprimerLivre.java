package com.koor.hello.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koor.hello.DAO.LivreDAO;
import com.koor.hello.bdd.DBConnection;

@WebServlet("/supprimerLivre")
public class SupprimerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean success = LivreDAO.supprimerLivreById(id);
        if (success) {
            request.getSession().setAttribute("messageDeletion", "✅ Le livre a bien été supprimé !");
		} else {
            request.getSession().setAttribute("messageDeletion", "❌ Une erreur est survenue lors de la suppression.");
		}
        response.sendRedirect(request.getContextPath() + "/consulterLivres");
	}
}

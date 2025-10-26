package com.koor.hello.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connection = null;
    public static Connection getConnection() {
    	try {
			if (connection == null || connection.isClosed()) {
				try {
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 👈 obligatoire sur Tomcat
			    	String URL = "jdbc:sqlserver://localhost:1433;databaseName=BibliothequeDB;encrypt=true;trustServerCertificate=true";
			    	String USERNAME = "SA";
			    	String PASSWORD = "Ljbts61%%";

					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			        System.out.println("✅ Connexion à la base OK !");
				} catch (SQLException e) {
			        System.err.println("❌ Erreur lors de la connexion à la base !");
			        e.printStackTrace();
			    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return connection;
    }
}

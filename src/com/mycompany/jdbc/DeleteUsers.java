package com.mycompany.jdbc;

import java.sql.*;

public class DeleteUsers {

	public static void main(String[] args) {
		//initialisation des variables propres à la connection
		String dbURl = "jdbc:mysql://localhost:8889/connectionJdbc";
		String userName ="root";
		String password ="root";
		Connection conn = null;

		try {

			//Charger le pilote pour faire le lien entre jdbc et la base de donnée
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Etablissement de la connection avec DriverManager
			conn = DriverManager.getConnection(dbURl, userName, password);

			//Vérification de la connection
			if (conn != null) {

				System.out.println("Connected");

			}
			//Requête SQL
			String sql = "DELETE FROM users WHERE Id=?";

			//Sécurité contre l'injection SQL
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, 2);


			int rowsDeleted = stmt.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}

			//Fermeture de la connection
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

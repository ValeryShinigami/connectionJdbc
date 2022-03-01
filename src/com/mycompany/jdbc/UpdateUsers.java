package com.mycompany.jdbc;

import java.sql.*;


public class UpdateUsers {

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
			String sql = "UPDATE users SET FirstName=?, LastName=?, Password=?, Email=? WHERE Id=?";

			//Sécurité contre l'injection SQL
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "Lebron");
			stmt.setString(2, "James");
			stmt.setString(3, "Lakers");
			stmt.setString(4, "lebronJames@me.com");
			stmt.setInt(5, 2);


			int rowsUpdated = stmt.executeUpdate();
			
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			}

			//Fermeture de la connection
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

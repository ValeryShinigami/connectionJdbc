package com.mycompany.jdbc;

//Toutes les classes de JDBC sont dans le package java.sql. 
import java.sql.*;

public class InsertUsers {

	public static void main(String[] args) throws ClassNotFoundException {

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
			String sql = "INSERT INTO users (Id, FirstName, LastName, Password, Email) VALUES (?,?,?,?,?)";

			//Sécurité contre l'injection SQL
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, 2);
			stmt.setString(2, "Lebron");
			stmt.setString(3, "James");
			stmt.setString(4, "Lakers");
			stmt.setString(5, "lebronjames@me.com");

			stmt.executeUpdate();
						
			//Fermeture de la connection
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

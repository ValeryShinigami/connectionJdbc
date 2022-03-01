package com.mycompany.jdbc;

import java.sql.*;


public class SelectUsers {

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
			String sql = "SELECT * FROM users ";

			//Sécurité contre l'injection SQL
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));

			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

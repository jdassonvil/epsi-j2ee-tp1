package epsi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	public static void main (String[] args){
				
		try{
			// Vérification du bon chargement du Driver MySQL
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("JDBC driver successfuly loaded");
			
			// Exécution d'une requête sur la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore", "root", "");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM track");
			
			// Parcours du resultat
			while(result.next()){
				System.out.print(result.getInt(1) + ". ");
				System.out.print(result.getString(2) + " - ");
				System.out.println(result.getInt(3) / 60 + ":" + result.getInt(3) % 60);
			}
					
		}catch(SQLException sqlEx){
			System.err.println(sqlEx.getMessage());
		}
		catch(Exception e){
			System.err.println("an error has occured");
		}
	}

}

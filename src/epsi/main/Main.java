package epsi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import epsi.model.Track;


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
			
			List<Track> tracks = new ArrayList<Track>();
			
			// Parcours du resultat
			while(result.next()){
				tracks.add(new Track(result.getString(2), result.getInt(1), result.getInt(3)));
			}
			
			for(Track track : tracks){
				System.out.println(track);
			}
					
		}catch(SQLException sqlEx){
			System.err.println(sqlEx.getMessage());
		}
		catch(Exception e){
			System.err.println("an error has occured");
		}
	}

}

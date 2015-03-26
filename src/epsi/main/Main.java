package epsi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import epsi.dao.TrackDao;
import epsi.model.Track;


public class Main {
	
	public static void main (String[] args){
				
		try{
			// Vérification du bon chargement du Driver MySQL
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("JDBC driver successfuly loaded");
			
			// Exécution d'une requête sur la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore", "root", "");
			
			TrackDao trackDao = new TrackDao(conn);
			
			for(Track track : trackDao.find()){
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

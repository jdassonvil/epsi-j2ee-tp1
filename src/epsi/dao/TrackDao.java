package epsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import epsi.model.Track;

public class TrackDao {

	protected Connection connection = null;
	
	public TrackDao(Connection connection){
		
		if(connection == null){
			throw new IllegalArgumentException("connection can't be null");
		}
		
		this.connection = connection;
	}
	
	public boolean create(Track track){
		return false;
	}
	
	public boolean update(Track track){
		return false;
	}
	
	public boolean delete(Track track){
		return false;
	}
	
	public List<Track> find(){
		try{
			ResultSet result = connection.createStatement().executeQuery("SELECT * FROM track");
		
			List<Track> tracks = new ArrayList<Track>();
			
			while(result.next()){
				tracks.add(new Track(result.getString("title"), result.getInt("position"), result.getInt("length")));
			}
			
			return tracks;

		}catch(SQLException sqlEx){
			System.err.println(sqlEx.getMessage());
			throw new RuntimeException("Fatal error");
		}
	}
	
	
}

package epsi.main;

import epsi.dao.ArtistDao;
import epsi.model.Artist;


public class Main {
	
	public static void main (String[] args){
				
		try{		
			ArtistDao artistDao = new ArtistDao();
		
			for(Artist artist: artistDao.find()){
				System.out.println(artist);
			}
			
		}
		catch(Exception e){
			System.err.println("an error has occured: " + e.getMessage());
			e.printStackTrace();	
		}
	}

}

package epsi.main;

import epsi.dao.TrackDao;
import epsi.model.Track;


public class Main {
	
	public static void main (String[] args){
				
		try{		
			TrackDao trackDao = new TrackDao();
			
			for(Track track : trackDao.find()){
				System.out.println(track);
			}
					
		}
		catch(Exception e){
			System.err.println("an error has occured: " + e.getMessage());
		}
	}

}

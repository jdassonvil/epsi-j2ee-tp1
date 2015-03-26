package epsi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
	
	private List<Track> tracks = new ArrayList<Track>();
	private String title;
	private Date releaseDate;
	
	public Album(){
		
	}
	
	public Album(List<Track> tracks, String title, Date releaseDate) {
		super();
		this.tracks = tracks;
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public List<Track> getTracks() {
		return tracks;
	}
	
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}

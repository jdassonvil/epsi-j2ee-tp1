package epsi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@OneToMany(mappedBy="album", fetch = FetchType.EAGER)
	private Collection<Track> tracks;
	
	@ManyToOne
	@JoinColumn(name = "artist_fk")
	private Artist artist;
	
	public Album(){
		
	}
	
	public Album(String title, Date releaseDate) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public Collection<Track> getTracks() {
		return tracks;
	}
	
	public void setTracks(ArrayList<Track> tracks) {
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
	
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		
		String albumString = releaseDate.getYear()+ ": " + title + "\n \n";
		
		for(Track track : this.tracks){
			albumString += "\t" + track + " \n";
		}
		
		return albumString + "\n";
	}
	
}

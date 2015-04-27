package epsi.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String city;
	private String biography;
	
	@Column(name ="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy="artist", fetch = FetchType.EAGER)
	private Collection<Album> albums;
	
	public Artist(){
		
	}
	
	public Artist(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}
	
	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}
	
	public String getBiography() {
		return biography;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String artistString = name + " from " + city + " \n";
		
		for(Album album: this.albums){
			artistString += "\t" + album;
		}
		
		return artistString;
	}

}

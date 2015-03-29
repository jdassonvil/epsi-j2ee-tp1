package epsi.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy="artist")
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
	
	@Override
	public String toString() {
		String artistString = name + " from " + city + " \n";
		
		for(Album album: this.albums){
			artistString += "\t" + album;
		}
		
		return artistString;
	}

}

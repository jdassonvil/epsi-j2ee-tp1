package epsi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="track")
public class Track {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private int position;
	private int length;
	
	public Track(){
		
	}

	public Track(String title, int position, int length) {
		super();
		this.title = title;
		this.position = position;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return position + ". " + title + " - " + (length / 60) + ":" + (length % 60);
	}
	
	
}

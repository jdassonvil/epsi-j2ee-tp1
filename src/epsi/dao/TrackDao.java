package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import epsi.model.Track;

public class TrackDao {

	EntityManager em;
	
	public TrackDao(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		em = emf.createEntityManager();	
	}
	
	public void create(Track track){
		em.persist(track);;
	}
	
	public void update(Track track){
		em.persist(track);
	}
	
	public void delete(Track track){
		em.remove(track);
	}
	
	@SuppressWarnings("unchecked")
	public List<Track> find(){
			List<Track> tracks = em.createQuery("SELECT t FROM Track t").getResultList();
			return tracks;
	}
	
}

package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import epsi.model.Artist;

public class ArtistDao {
	
	EntityManager em;
	
	public ArtistDao(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		em = emf.createEntityManager();	
	}
	
	public void create(Artist artist){
		em.persist(artist);;
	}
	
	public void update(Artist artist){
		em.persist(artist);
	}
	
	public void delete(Artist artist){
		em.remove(artist);
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> find(){
			List<Artist> artists = em.createQuery("SELECT a FROM Artist a").getResultList();
			return artists;
	}

}

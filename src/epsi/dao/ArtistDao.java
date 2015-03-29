package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import epsi.model.Artist;

public class ArtistDao {
	
	public ArtistDao(){
	}
	
	public void create(Artist artist){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(artist);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void update(Artist artist){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.merge(artist);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void delete(Artist artist){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
				
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
				
		em.remove(artist);
		transaction.commit();
				
		//Close entity manager
		em.close();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> find(){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		List<Artist> artists = em.createQuery("SELECT a FROM Artist a").getResultList();
		//Close entity manager
		em.close();
		emf.close();
		return artists;
	}
	
	public Artist findByName(String name){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		Artist artist = (Artist) em.createQuery("Select a FROM Artist a WHERE a.name=:name")
							.setParameter("name", name).getSingleResult();
		em.close();
		emf.close();
		return artist;
				
	}

}

package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import epsi.model.Track;

public class TrackDao {

	public TrackDao(){
	}
	
	public void create(Track track){
		
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(track);
		transaction.commit();
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void update(Track track){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.merge(track);
		transaction.commit();
		//Close entity manager
		em.close();
		emf.close();

	}
	
	public void delete(Track track){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.remove(em.contains(track) ? track : em.merge(track));
		transaction.commit();
		//Close entity manager
		em.close();
		emf.close();

	}
	
	@SuppressWarnings("unchecked")
	public List<Track> find(){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		List<Track> tracks = em.createQuery("SELECT t FROM Track t").getResultList();
			
		//Close entity manager
		em.close();
		emf.close();
		return tracks;


	}
	
}

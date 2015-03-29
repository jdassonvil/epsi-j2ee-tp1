package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import epsi.model.Album;

public class AlbumDao {
	
	public AlbumDao(){
		
	}
	
	public void create(Album album){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(album);;
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void update(Album album){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.merge(album);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();

	}
	
	public void delete(Album album){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.remove(album);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> find(){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		List<Album> albums = em.createQuery("SELECT a FROM Album a").getResultList();
		
		//Close entity manager
		em.close();
		emf.close();
		
		return albums;
	}


}

package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import epsi.exception.ArtistNotFoundException;
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
				
		em.remove(em.contains(artist) ? artist : em.merge(artist));
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
	
	public Artist findByName(String name) throws ArtistNotFoundException{
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		try{
		Artist artist = (Artist) em.createQuery("Select a FROM Artist a WHERE a.name=:name")
							.setParameter("name", name).getSingleResult();
		Hibernate.initialize(artist.getAlbums());
		return artist;	

		}catch(NoResultException e){
			throw new ArtistNotFoundException();
		}finally{
			em.close();
			emf.close();
		}
	}
	
	public Artist findById(Long id) throws ArtistNotFoundException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		try{
			Artist artist = (Artist) em.createQuery("Select a FROM Artist a WHERE a.id=:id")
							.setParameter("id", id).getSingleResult();
			Hibernate.initialize(artist.getAlbums());
			return artist;
			
		}catch(NoResultException ex){
			throw new ArtistNotFoundException();
		}finally{
			em.close();
			emf.close();
		}		
	}

}

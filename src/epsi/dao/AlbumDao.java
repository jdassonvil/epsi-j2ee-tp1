package epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import epsi.model.Album;

public class AlbumDao {
	
	EntityManager em;
	
	public AlbumDao(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		em = emf.createEntityManager();	
	}
	
	public void create(Album album){
		em.persist(album);;
	}
	
	public void update(Album album){
		em.persist(album);
	}
	
	public void delete(Album album){
		em.remove(album);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> find(){
			List<Album> albums = em.createQuery("SELECT a FROM Album a").getResultList();
			return albums;
	}


}

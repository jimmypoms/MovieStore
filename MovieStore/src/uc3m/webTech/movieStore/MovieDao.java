package uc3m.webTech.movieStore;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class MovieDao {

	private EntityManagerFactory managerFactory;
	private EntityManager em;
	
	public MovieDao(){
		managerFactory=Persistence.createEntityManagerFactory("MovieStore");
		em=managerFactory.createEntityManager();
	}
	
	public void addMovie(String title, int year, String synopsis){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Movie newMovie = new Movie();
		newMovie.setTitle(title);
		newMovie.setYear(year);
		newMovie.setSynopsis(synopsis);
		em.persist(newMovie);
		transaction.commit();
		
	}
	
	public List<Movie> getMovieList(){
		Query query = em.createQuery("SELECT m from Movie m");
		@SuppressWarnings("unchecked")
		List<Movie> movies = query.getResultList();
		return movies;
	}
	
	public void deleteMovie(int id){
		Query q = em.createQuery("DELETE FROM Movie m WHERE m.id = " + id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}

}

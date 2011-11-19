package uc3m.webTech.movieStore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MovieDao {
	//that's not an actual DAO yet
	
	private EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	public MovieDao(){
		managerFactory=Persistence.createEntityManagerFactory("MovieStore");
		manager=managerFactory.createEntityManager();
	}
	
	public void addMovie(String title, int year){
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Movie newMovie = new Movie();
		newMovie.setTitle(title);
		newMovie.setYear(year);
		manager.persist(newMovie);
		transaction.commit();
		
	}
	
	public List<Movie> getMovieList(){
		Query query = manager.createQuery("SELECT m from Movie m");
		@SuppressWarnings("unchecked")
		List<Movie> movies = query.getResultList();
		return movies;
		
	}

}

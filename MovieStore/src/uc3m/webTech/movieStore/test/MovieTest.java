package uc3m.webTech.movieStore.test;

import uc3m.webTech.movieStore.MovieDao;


public class MovieTest {

	public static void addMovie(String title, int year, String synopsis, String actors) {
//		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("MovieStore");
//		EntityManager manager = managerFactory.createEntityManager();
//		// Add a movie.
//		EntityTransaction transaction = manager.getTransaction();
//		transaction.begin();
//		Movie newMovie = new Movie();
//		newMovie.setTitle(title);
//		newMovie.setYear(year);
//		manager.persist(newMovie);
//		transaction.commit();
//		// Show persisted movies.
//		System.out.println("Check movie inserted in db");
//		Query query = manager.createQuery("SELECT m from Movie m");
//		@SuppressWarnings("unchecked")
//		List<Movie> movies = query.getResultList();
//		for (Movie movie : movies) {
//			System.out.println(movie);
//		}
		MovieDao movieDao=new MovieDao();
		movieDao.addMovie(title, year, synopsis, actors);
	}

	public static void main(String... args) {
		addMovie(args[0], Integer.parseInt(args[1]), args[2], args[3]);
	}
}

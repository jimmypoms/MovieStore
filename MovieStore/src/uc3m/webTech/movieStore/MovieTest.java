package uc3m.webTech.movieStore;


public class MovieTest {

	public static void addMovie(String title, int year) {
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
		movieDao.addMovie(title, year);
	}

	public static void main(String... args) {
		addMovie(args[0], Integer.parseInt(args[1]));
	}
}
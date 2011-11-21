package uc3m.webTech.movieStore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet(name="/MovieListServlet", urlPatterns={"/movielist"})
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDao movieDao;
       
    public MovieListServlet() {
        super();
        movieDao = new MovieDao(); //should be injected from context
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Display the list of movies:
        request.setAttribute("movies",movieDao.getMovieList() );
        request.getRequestDispatcher("/movielist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		System.out.println(title);
		System.out.println(year);
		movieDao.addMovie(title, Integer.parseInt(year));
		
		doGet(request, response);
	}

}

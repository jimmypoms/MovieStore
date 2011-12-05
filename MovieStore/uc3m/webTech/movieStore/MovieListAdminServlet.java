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
@WebServlet(name="/MovieListServlet", urlPatterns={"/movielistadmin"})
public class MovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDao movieDao;
       
    public MovieListAdminServlet() {
        super();
        movieDao = new MovieDao(); //should be injected from context
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies",movieDao.getMovieList() );
        request.getRequestDispatcher("/movielistadmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String synopsis = request.getParameter("synopsis");
		String year = request.getParameter("year");
		movieDao.addMovie(title, Integer.parseInt(year), synopsis);
		
		doGet(request, response);
	}
	
}

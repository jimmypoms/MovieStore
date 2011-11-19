package uc3m.webTech.movieStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet(name="MovieListServlet", urlPatterns={"/movielist"})
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MovieDao movieDao;
       
    public MovieListServlet() {
        //super();
        movieDao = new MovieDao(); //should be injected from context
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Display the list of movies:
		
//        request.setAttribute("movies",movieDao.getMovieList() );
//        request.getRequestDispatcher("/movielist.jsp").forward(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header><title>Movie List from DB</title></header>");
		out.println("<body><p>");
		List<Movie> movies = movieDao.getMovieList();
		if(!movies.isEmpty()){
			out.println("<hr><ol>");
			for(Movie movie : movies)
				out.println("<li>"+movie.toString()+"</li>");
			out.println("</ol></hr>");
		}
		out.println("</p></body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

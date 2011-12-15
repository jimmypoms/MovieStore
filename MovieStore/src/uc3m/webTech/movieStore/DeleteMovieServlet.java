package uc3m.webTech.movieStore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet(name="DeleteMovieServlet", urlPatterns={"/deletemovie"})
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private MovieDao movieDao;
       
    
    public DeleteMovieServlet() {
        super();
        movieDao = new MovieDao(); 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("movies",movieDao.getMovieList() );
        request.getRequestDispatcher("/movielistadmin.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("movieid"));
		movieDao.deleteMovie(id);
		
		doGet(request, response);
	}

}

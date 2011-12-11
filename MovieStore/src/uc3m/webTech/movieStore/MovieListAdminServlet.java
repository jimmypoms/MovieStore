package uc3m.webTech.movieStore;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="MovieListAdminServlet", urlPatterns={"/movielistadmin"})
public class MovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private MovieDao movieDao;
       
    public MovieListAdminServlet() {
        super();
        movieDao = new MovieDao(); 
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies",movieDao.getMovieList() );
        request.getRequestDispatcher("/movielistadmin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		checkTitle(title);
		String synopsis = request.getParameter("synopsis");
		String year = request.getParameter("year");
		checkYear(year);
		movieDao.addMovie(title, Integer.parseInt(year), synopsis);
		
		doGet(request, response);
	}
	
	private void checkTitle(String title) throws IllegalArgumentException{
		if(title.isEmpty())
			throw new IllegalArgumentException();
	}
	
	private void checkYear(String year) throws IllegalArgumentException{
		if(year.isEmpty())
			throw new IllegalArgumentException();
		Calendar cal = new GregorianCalendar();
		if(Integer.parseInt(year)>cal.get(Calendar.YEAR)+10)
			throw new IllegalArgumentException();
		if(Integer.parseInt(year)<1895)
			throw new IllegalArgumentException();
	}
	
}

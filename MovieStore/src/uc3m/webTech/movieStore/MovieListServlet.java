package uc3m.webTech.movieStore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet(name="MovieListServlet", urlPatterns={"/movielist"})
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        //super();
        movieDao = new MovieDao(); //should be injected from context
        userDao = UserDao.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("id");
		String session = request.getSession().getId();
		User u = null;
		if (session != null ) {
			u = userDao.getUser(session);
			System.out.println(session);
		}
		if (u!=null) System.out.println(u.toString());
		else System.out.println("NO USER SESSION");
		
		request.setAttribute("user", u);
		
		if (id!=null){
			request.setAttribute("movie", movieDao.getMovieById(Long.decode(id)));
			request.getRequestDispatcher("/moviedetails.jsp").forward(request, response);
		} 
		else {
			request.setAttribute("movies",movieDao.getMovieList() );
			request.getRequestDispatcher("/movielist.jsp").forward(request, response);
		}
    }
}

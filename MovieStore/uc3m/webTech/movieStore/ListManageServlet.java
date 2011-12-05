package uc3m.webTech.movieStore;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListManageServlet
 */
@WebServlet(name="ListManageServlet",urlPatterns={"/addmovie"})
public class ListManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MovieDao movieDao;
    
    public ListManageServlet() {
        //super();
        movieDao = new MovieDao(); //should be injected from context
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("movies", movieDao.getMovieList());
        request.getRequestDispatcher("/addmovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Handle a new movie:
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        
        //simple validation, maybe better client-side with javascript
        if (title != null && year>1895)
            movieDao.addMovie(title, year);
 
        // Display the list of guests:
        doGet(request, response);
	}

}

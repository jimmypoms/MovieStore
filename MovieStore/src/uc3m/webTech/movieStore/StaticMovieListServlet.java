package uc3m.webTech.movieStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(name="/StaticMovieListServlet", urlPatterns={"/staticList"})
public class StaticMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<String> movies;

    /**
     * Default constructor. 
     */
    public StaticMovieListServlet() {
    	movies = new ArrayList<String>();
		movies.add("Movie1");
		movies.add("Movie2");
		movies.add("Movie3");
		movies.add("Movie4");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("movies", movies);
        request.getRequestDispatcher("/staticList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
	}

}
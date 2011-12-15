package uc3m.webTech.movieStore;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="UserLoginServlet", urlPatterns={"/login"})
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao;
	
	public UserLoginServlet(){
		super();
		userDao=new UserDao();
	}
	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		if(userName.isEmpty())
			throw new IllegalArgumentException();
		
		String password = request.getParameter("password");
		if(password.isEmpty() || password.length()<8)
			throw new IllegalArgumentException();
		
		User user;
	
		user = userDao.checkUser(userName,password);
		if (user.equals(null)){
			System.out.println("Invalid username or password! Please try again! ");
			System.out.println("New user? You can sign up here!");
		}
		else{
			System.out.println("User Details:");
			System.out.println("-------------");
			System.out.println(user.toString());
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//doGet(request, response);
	}

}

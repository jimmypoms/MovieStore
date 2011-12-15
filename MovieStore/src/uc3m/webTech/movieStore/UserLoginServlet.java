package uc3m.webTech.movieStore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="UserLoginServlet", urlPatterns={"/login"})
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao;
	
	public UserLoginServlet(){
		super();
		userDao=UserDao.getInstance();
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

		if (user == null){
			System.out.println("Invalid username or password! Please try again! ");
			System.out.println("New user? You can sign up here!");
		}
		else{
			HttpSession session = request.getSession(true);
			user.setSession(session.getId());
			user.setLastLogin();
		}

		
		//TEST ------> check if the user is actually added to DB
				System.out.println("USER LIST --------------------->>>>>>>");
				List<User> users = userDao.getUserList();
				for(User u : users)
					System.out.println(u.toString());
				System.out.println("<<<<<<<---------------------");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//doGet(request, response);
	}

}

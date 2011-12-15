package uc3m.webTech.movieStore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="NewUserServlet", urlPatterns={"/newuser"})
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
       
    
    public NewUserServlet() {
        super();
        userDao=UserDao.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet only redirects to new user jsp page
		request.getRequestDispatcher("/newuser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		if(userName.isEmpty())
			throw new IllegalArgumentException();
		
		String password = request.getParameter("password");
		if(password.isEmpty() || password.length()<8)
			throw new IllegalArgumentException();
		
		String name = request.getParameter("name");
		if(name.isEmpty())
			throw new IllegalArgumentException();
		
		String surname = request.getParameter("surname");
		if(surname.isEmpty())
			throw new IllegalArgumentException();
		
		String age = request.getParameter("age");
		if(age.isEmpty() || Integer.parseInt(age)<0 || Integer.parseInt(age)>150)
			throw new IllegalArgumentException();
		
		userDao.addUser(userName,password,name,surname,Integer.parseInt(age));
		
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

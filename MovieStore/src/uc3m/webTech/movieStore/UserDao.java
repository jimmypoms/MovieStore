package uc3m.webTech.movieStore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Stateless
public class UserDao {
	
	private EntityManagerFactory managerFactory;
	private EntityManager em;
	
	public UserDao(){
		managerFactory=Persistence.createEntityManagerFactory("MovieStore");
		em=managerFactory.createEntityManager();
	}
	
	public void addUser(String userName, String pswd, String name,
			String surname, int age){
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		User newUser = new User();
		newUser.setUsername(userName);
		newUser.setPassword(pswd);
		newUser.setName(name);
		newUser.setSurname(surname);
		newUser.setAge(age);
		em.persist(newUser);
		transaction.commit();
	}
	
	public void removeUser(int id){
		Query q = em.createQuery("DELETE FROM User u WHERE u.id = " + id);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
	
	public List<User> getUserList(){
		Query query = em.createQuery("SELECT u from User u");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;
	}
	
	public User checkUser(String usrname,String pass){
		List<User> users=getUserList();
		for(User u : users){
			if (u.getUsername().equals(usrname)&&u.getPassword().equals(pass)){
					return u;				
			}
			
		}
		return null;
	}

}

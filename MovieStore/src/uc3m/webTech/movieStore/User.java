package uc3m.webTech.movieStore;

import java.util.Set;
import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name="movieStoreUser") //a table can't be called User, it's a reserved word
public class User implements Comparable{
	@Id
	@GeneratedValue()
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String username;	
	private String password;
	private String lastSession;
	private String session;
	private Set<Purchase> purchaseHistory;
	
	public boolean isAdmin;
	
	
	public Long getId(){
		return id;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", age=" + age
				+ ", username=" + username + ",SessionID=" + session +
				", LastSession=" + lastSession + "]";
	}


	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
	public void setLastLogin(){
    	Date date = new Date();
    	this.lastSession=dateFormat.format(date);
    }
    public String getLastSession(){
    	return lastSession;
    }
    
    public void setName(String n){
    	this.name=n;
    }
	public String getName(){
		return name;
	}
	
	public void setSurname(String s){
		this.surname=s;
	}
	public String getSurname(){
		return surname;
	}
	
	public void setAge(int a){
		this.age=a;
	}
	public int getAge(){
		return age;
	}
	
	public void setUsername(String u){
		this.username=u;
	}
	public String getUsername(){
		return username;
	}
	
	public void setPassword(String p){
		this.password=p;
	}
	public String getPassword(){
		return password;
	}
	
	public void setPurchaseHistory(Set<Purchase> pur){
		this.purchaseHistory=pur;
	}
	public Set<Purchase> getPurchaseHistory(){
		return purchaseHistory;
	}


	public String getSession() {
		return session;
	}


	public void setSession(String session) {
		this.session = session;
	}
	
	@Override
	public boolean equals(Object u) {
		if (u instanceof User)
			return id.equals(((User)u).getId());
		return false;
	}


	@Override
	public int compareTo(Object u) {
		if (this.equals(u)) return 0;
		else return -1;
	}
}

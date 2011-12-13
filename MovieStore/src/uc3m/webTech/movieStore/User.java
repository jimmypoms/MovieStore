package uc3m.webTech.movieStore;

import java.util.Set;
import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class User {
	@Id
	@GeneratedValue()
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String username;	
	private String password;
	private String LastSession;
	private Set<Purchase> purchaseHistory;
	
	
	
	public Long getId(){
		return id;
	}
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
	public void setLastSession(){
    	Date date = new Date();
    	this.LastSession=dateFormat.format(date);
    }
    public String getLastSession(){
    	return LastSession;
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
}

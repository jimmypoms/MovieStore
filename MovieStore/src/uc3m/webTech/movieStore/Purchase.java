package uc3m.webTech.movieStore;


import java.util.Set;
import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue()
	private Long id;
	private Long userid;
	private Set<Movie> movies;
	private String timestamp;
	
	public Long getId(){
		return id;
	}
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
	public void setTimestamp(){
    	Date date = new Date();
    	this.timestamp=dateFormat.format(date);
    }
    public String getTimestamp(){
    	return timestamp;
    	
    }
    
    public void setUserId(Long i){
    	this.userid=i;
    }
    public Long getUserId(){
    	return userid;
    }
    
    public void setMovies(Set<Movie> m){
    	this.movies=m;
    }
    public Set<Movie> getMovies(){
    	return movies;
    }
}

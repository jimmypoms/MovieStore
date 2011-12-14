package uc3m.webTech.movieStore;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue()
	private Long id;
	private String title;
	@Column(name="RELEASE_YEAR")
	private int year;
	private String indent;
	private Set<String> languageCodes;
	private String actors;
	private String synopsis;
	private Genre genre;

	public Long getId() {
		return id;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year<1895){
			throw new IllegalArgumentException(String.valueOf(year));
		}
		this.year = year;
	}
	public String getIndent() {
		return indent;
	}
	public void setIndent(String indent) {
		this.indent = indent;
	}
	public Set<String> getLanguageCodes() {
		return languageCodes;
	}
	public void setLanguageCodes(Set<String> languageCodes) {
		this.languageCodes = languageCodes;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		//we could check here that title isn't a empty string, but probably 
		//this check is done in an upper level ( web form,.. )
		//we can check anyway due to good practice
		if(title.isEmpty()||title==null)
			throw new IllegalArgumentException(String.valueOf(title));
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + "]";
	}

}

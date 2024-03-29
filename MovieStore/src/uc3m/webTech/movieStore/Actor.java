package uc3m.webTech.movieStore;

import javax.persistence.*;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue()
	private Long id;
	
	private String displayName;//eg Joe Smith
	private String orderName;//eg Smith, Joe
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	
}

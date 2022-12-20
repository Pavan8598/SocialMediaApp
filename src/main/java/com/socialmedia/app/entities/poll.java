package com.socialmedia.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pollid;
	
	@Column(nullable=true)
	private String polltitle;
	
	

	 @OneToOne(cascade=CascadeType.ALL , fetch=FetchType.EAGER)   
		private user user;
	
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	 @Fetch(value = FetchMode.SUBSELECT)
	List<option> options =new ArrayList<option>();

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getPolltitle() {
		return polltitle;
	}

	public void setPolltitle(String polltitle) {
		this.polltitle = polltitle;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public List<option> getOptions() {
		return options;
	}

	public void setOptions(List<option> options) {
		this.options = options;
	}
	
	
	
	
	

}
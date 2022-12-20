package com.socialmedia.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class user implements Serializable{                              //DAOUser
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 public int userid;
	

	public String name;
	
	private String password;
    
	
	public String email;
	
	 public String mobileno;
	 
	  @ManyToOne(cascade=CascadeType.ALL)    //,fetch=FetchType.EAGER
		private post post;
//	 
//	public List<user> getLikes() {
//		return likes;
//	}
//
//	public void setLikes(List<user> likes) {
//		this.likes = likes;
//	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	
//
//	    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//		@JoinColumn(name="Add_id")
//		private Customer_Address customer_Address;
//	 

	
	
}

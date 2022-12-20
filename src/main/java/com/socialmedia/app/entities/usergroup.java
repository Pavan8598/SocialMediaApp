package com.socialmedia.app.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class usergroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groupid;
   
    private String groupname;
    
	private String type;
	
	  @OneToMany(cascade=CascadeType.ALL)    //,fetch=FetchType.EAGER
	  @JoinColumn(name="users")
		private  List<user> users=new ArrayList<user>();
		
		
		  @OneToMany(cascade=CascadeType.ALL)    //,fetch=FetchType.EAGER
		  @JoinColumn(name="posts")
			private  List<post> posts=new ArrayList<post>();

	public String getGroupname() {
			return groupname;
		}

		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}

		public List<user> getUsers() {
			return users;
		}

		public void setUsers(List<user> users) {
			this.users = users;
		}

		public List<post> getPosts() {
			return posts;
		}

		public void setPosts(List<post> posts) {
			this.posts = posts;
		}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
//	@OneToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
//	Customer_Details c;
//	
//	@OneToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
//	Product p;
	

}

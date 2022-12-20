package com.socialmedia.app.entities;

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
public class comment {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentid;
	

	private String content ;
	
	

	@OneToOne(cascade=CascadeType.ALL)    //,fetch=FetchType.EAGER
	  @JoinColumn(name="user")
		private user user;
	

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

//	public List<comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<comment> comments) {
//		this.comments = comments;
//	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



//	@OneToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
//	private Product product;
//	

	
	
}

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
public class post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	 

	@Column(nullable=true)
	private String title;
	
	@Column( nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String multimedianame;
	
	@Column(nullable=true)
	private String multimediatype;

	
	 @OneToOne(cascade=CascadeType.ALL , fetch=FetchType.EAGER)    //,fetch=FetchType.EAGER
	// @JsonIgnore
		private user user;
	
	  @OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER )    //,fetch=FetchType.EAGER
	  @JoinColumn(name="likes")
	  @Fetch(value = FetchMode.SUBSELECT)
		private List<user> likes=new ArrayList<user>();
	  
	  @OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER )    //,fetch=FetchType.EAGER
	  @Fetch(value = FetchMode.SUBSELECT)
		private List<comment> comments=new ArrayList<comment>();

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMultimedianame() {
		return multimedianame;
	}

	public void setMultimedianame(String multimedianame) {
		this.multimedianame = multimedianame;
	}

	public String getMultimediatype() {
		return multimediatype;
	}

	public void setMultimediatype(String multimediatype) {
		this.multimediatype = multimediatype;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public List<user> getLikes() {
		return likes;
	}

	public void setLikes(List<user> likes) {
		this.likes = likes;
	}

	public List<comment> getComments() {
		return comments;
	}

	public void setComments(List<comment> comments) {
		this.comments = comments;
	}
	
      
	

	

	
}

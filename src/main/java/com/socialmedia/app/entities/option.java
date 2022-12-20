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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int optionid;
	
	@Column
	private String optioncontent;
	
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	 @Fetch(value = FetchMode.SUBSELECT)
	List<user> selecters =new ArrayList<user>();


	public int getOptionid() {
		return optionid;
	}


	public void setOptionid(int optionid) {
		this.optionid = optionid;
	}


	public List<user> getSelecters() {
		return selecters;
	}


	public void setSelecters(List<user> selecters) {
		this.selecters = selecters;
	}


	public String getOptioncontent() {
		return optioncontent;
	}


	public void setOptioncontent(String optioncontent) {
		this.optioncontent = optioncontent;
	}
	

	
	
	
}

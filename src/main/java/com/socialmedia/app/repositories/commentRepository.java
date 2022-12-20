package com.socialmedia.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.socialmedia.app.entities.comment;


public interface commentRepository extends JpaRepository<comment ,Integer> {
	
	

}

package com.socialmedia.app.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.socialmedia.app.entities.usergroup;



public interface groupRepository extends JpaRepository<usergroup ,Integer> {
	
	
}

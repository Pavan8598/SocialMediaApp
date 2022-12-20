package com.socialmedia.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.entities.poll;
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;

@Repository
public interface pollRepository extends JpaRepository<poll,Integer> {

	
	public List<poll> findByUser(user u);

}

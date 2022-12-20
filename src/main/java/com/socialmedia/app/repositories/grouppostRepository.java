package com.socialmedia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.usergroup;

@Repository
public interface grouppostRepository extends JpaRepository<post ,Integer> {

}

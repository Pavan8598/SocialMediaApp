package com.socialmedia.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.socialmedia.app.entities.user;


@Repository
public interface userRepository extends JpaRepository< user , Integer> {


	public user findByEmail(String email);
}

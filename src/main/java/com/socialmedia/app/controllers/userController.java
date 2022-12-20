package com.socialmedia.app.controllers;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.entities.login;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.services.userService;



@RestController
public class userController {
	@Autowired
	private userService userService;
	

	@PostMapping(value = "/login" ,headers = "Accept=application/json")
	public ResponseEntity<user> authenticateUser(@RequestBody login authenticationRequest) throws Exception {
		
		user usr=userService.getUserByEmail(authenticationRequest.getEmail());
	    
		if(usr.getPassword().equals(userService.encryptPass(authenticationRequest.getPassword())))
		     return ResponseEntity.ok(usr);
		 else
		   return   ResponseEntity.notFound().build();
	}
	
	
	@PostMapping(value="/signup",headers = "Accept=application/json")     //register customer
	public user addUser(@RequestBody user user) throws NoSuchAlgorithmException
	{
		return this.userService.addUser(user);
	}
	
	
	@GetMapping(value="/getAllUsers")     //register customer
	public List<user> allUSers()
	{
		return userService.getAllUSers();
	}
	
	@GetMapping(value="/getUser/{userid}")     //register customer
	public ResponseEntity<user> userByUSerID(@PathVariable int userid)
	{
		return ResponseEntity.ok(userService.getUser(userid));
	}
	

	
}

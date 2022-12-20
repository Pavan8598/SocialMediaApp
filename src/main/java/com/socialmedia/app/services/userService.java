package com.socialmedia.app.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.userRepository;

@Service
public class userService {
	
	@Autowired
	 private userRepository userRepository;

//	
//   @Autowired
//	private PasswordEncoder bcryptEncoder;
//	
	public user getUser(int userid)
	{
		return userRepository.findById(userid).get();
	}
	
	public user addUser(user user) throws NoSuchAlgorithmException
	{
		user newUser = new user();
		newUser.setName(user.getName());
		newUser.setPassword(encryptPass(user.getPassword()));
		newUser.setMobileno(user.getMobileno());
		newUser.setEmail(user.getEmail());
	
		return userRepository.save(newUser);	
	}

	public user getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public List<user> getAllUSers()
	{
	 return userRepository.findAll();
	}
	
	public String encryptPass(String pass) throws NoSuchAlgorithmException
	{
		  String password = pass;
	        String algorithm = "SHA";

	        byte[] plainText = password.getBytes();
	      
	     
	            MessageDigest digest = MessageDigest.getInstance(algorithm);
	            digest.reset();
	            digest.update(plainText);
	            byte[] encodedPassword = digest.digest();

	            StringBuilder builder = new StringBuilder();
	            for (byte b : encodedPassword) {
	                if ((b & 0xff) < 0x10) {
	                    builder.append("0");
	                }
	                builder.append(Long.toString(b & 0xff, 16));
	            }

	          
	           
	       
	        return builder.toString();
	}
}

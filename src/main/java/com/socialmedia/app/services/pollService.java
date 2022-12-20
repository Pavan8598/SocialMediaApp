package com.socialmedia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.poll;
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.userRepository;

@Service
public class pollService {
	
	@Autowired
	private com.socialmedia.app.repositories.pollRepository pollRepository;
	
	@Autowired
	private userRepository userRepository;
	
	
	public poll addPoll(poll poll)
	{
		return pollRepository.save(poll);
	}
	
	
	public List<poll> getPollsById(int userid) {
	       
	    user u = userRepository.findById(userid).get();
	 
        return pollRepository.findByUser(u);
    }
	
	  public List<poll> getAllPolls() {
			
			return pollRepository.findAll();
		}
	  
	  public poll getPollsBypollId(int pollid) {
	        
	        return pollRepository.findById(pollid).get();
	    }

}

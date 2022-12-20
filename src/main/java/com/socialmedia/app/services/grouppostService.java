package com.socialmedia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.postRepository;
import com.socialmedia.app.repositories.userRepository;

@Service
public class grouppostService {

	@Autowired
	com.socialmedia.app.repositories.grouppostRepository grouppostRepository;
	
	
	public post AddPostToGroup(post post)
	{
		return grouppostRepository.save(post);
	}
//	
//	
//	
//    public List<post> getAllPosts() {
//		
//		return grouppostRepository.findAll();
//	}
//    
//    
    public post getPostsBypostId(int postid) {
        
	    
        return grouppostRepository.getOne(postid);
    }
}

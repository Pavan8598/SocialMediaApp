package com.socialmedia.app.services;


import java.util.List;

import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class postService {
	
	
	@Autowired
	private postRepository postRepository;
	  
	@Autowired
	private com.socialmedia.app.repositories.userRepository userRepository;
	
	public post addPost(post post)
	{
		return postRepository.save(post);
	}
  
	public List<post> getPostsById(int userid) {
       
	    user u = userRepository.findById(userid).get();
	 
        return postRepository.findByUser(u);
    }
	
    public List<post> getAllPosts() {
		
		return postRepository.findAll();
	}
    
    
    public post getPostsBypostId(int postid) {
        
	    
        return postRepository.findById(postid).get();
    }
   

	
	
//
//	public List<Product> getProduct1() {
//		// TODO Auto-generated method stub
//		return p.findAll();
//	}
//
//	public List<Product> getsubcat(String subcat) {
//		// TODO Auto-generated method stub
//		
//		return p.findBySubcat(subcat);
//	}
//
//	public List<Product> getcatid(String catid) {
//		// TODO Auto-generated method stub
//		return p.findByCatid(catid);
//	}
//
//	public Product getptid(Integer pid) {
//		// TODO Auto-generated method stub
//		return p.findByPid(pid);
//	}
//	
//	

	
}

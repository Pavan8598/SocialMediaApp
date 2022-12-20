package com.socialmedia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.app.entities.comment;
import com.socialmedia.app.entities.option;
import com.socialmedia.app.entities.poll;
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.userRepository;
import com.socialmedia.app.services.postService;

@RestController
@CrossOrigin
public class pollController {
	
	@Autowired
	private com.socialmedia.app.services.pollService pollService;
	
	@Autowired
	private com.socialmedia.app.repositories.optionRepository optionRepository;
	
	
	@Autowired
	private userRepository ur;
	
	@PostMapping(value="/newPoll/{userid}" ,headers = "Accept=application/json" )
	public poll addNewPoll(@RequestBody poll poll ,@PathVariable int userid  )
	{      
		user u = ur.findById(userid).get();
		
		poll.setUser(u);
		
		return pollService.addPoll(poll);
	}
	

	@PostMapping(value="/addNewOption/{pollid}" ,headers = "Accept=application/json" )
	public ResponseEntity<?> addNewOption(@RequestBody option option  ,@PathVariable int pollid )
	{ 
		poll p = pollService.getPollsBypollId(pollid);
        
		option opt = optionRepository.save(option);
		
		p.getOptions().add(opt);
		
		pollService.addPoll(p);
		
		return ResponseEntity.ok("you added option to poll");
	}
	
	
    
	@GetMapping("/voteTheOption/{optionid}/{userid}")
	public ResponseEntity<?> voteOption(@PathVariable int userid ,@PathVariable int optionid){
		
		option opt = optionRepository.findById(optionid).get();
		user u = ur.findById(userid).get();
		
		opt.getSelecters().add(u);
		
		optionRepository.save(opt);
	
		return ResponseEntity.ok("you voted for option" + opt.getOptioncontent());
	 
	}
	
	@GetMapping("/getOptions/{pollid}")
	public ResponseEntity<?> getOptions(@PathVariable int pollid){
		
		poll p = pollService.getPollsBypollId(pollid);
	    return ResponseEntity.ok(p.getOptions());
  }
	
	@GetMapping("/getOptionVoters/{optionid}")
	public ResponseEntity<?> getOptionVoters(@PathVariable int optionid){
		
		option opt  = optionRepository.findById(optionid).get();
	    return ResponseEntity.ok(opt.getSelecters());
  }
//	
//	@PostMapping(value="/addNewComment/{userid}/{postid}" ,headers = "Accept=application/json" )
//	public ResponseEntity<?> addNewComment(@RequestBody comment comment ,@PathVariable int userid ,@PathVariable int postid )
//	{ 
//		post p = postService.getPostsBypostId(postid);
//		user u = ur.findById(userid).get();
//		comment.setUser(u);
//		
//		comment c = commentService.addComment(comment);
//		p.getComments().add(c);
//		
//		postService.addPost(p);
//		return ResponseEntity.ok("you commented on post");
//	}
//	
//	@GetMapping("/getComments/{postid}")
//	public List<comment> getCommentsOfPost(@PathVariable int postid){
//	
//		post p = postService.getPostsBypostId(postid);
//	   
//		return p.getComments();
//	}
//	
	
	
}

package com.socialmedia.app.controllers;


import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.app.entities.comment;
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.repositories.userRepository;
import com.socialmedia.app.services.postService;

@RestController
@CrossOrigin
public class postController {
	
	@Autowired
	private postService postService;
	
	@Autowired
	private com.socialmedia.app.services.commentService commentService;
	

	
	@Autowired
	private userRepository ur;
	
	@PostMapping(value="/newPost/{userid}" ,headers = "Accept=application/json" )
	public post addNewPost(@RequestBody post post ,@PathVariable int userid  )
	{      
		user u = ur.findById(userid).get();
		
		post.setUser(u);
		return postService.addPost(post);
	}
	
	@GetMapping("/getPostById/{userid}")
	public List<post> getSelfPosts(@PathVariable int userid){
		
		return postService.getPostsById(userid);
	
	}
	
	@GetMapping("/getAllPosts")
	public List<post> getAllPosts( ){
		
		return postService.getAllPosts();
	}
    
	@GetMapping("/likethepost/{postid}/{userid}")
	public ResponseEntity<?> likePost(@PathVariable int userid ,@PathVariable int postid){
		
		post p = postService.getPostsBypostId(postid);
		user u = ur.findById(userid).get();
		
		p.getLikes().add(u);
		
		postService.addPost(p);
		System.out.println(p.getLikes().size());
		return ResponseEntity.ok("you like the post");
	 
	}
	
	@GetMapping("/getAllLikes/{postid}")
	public ResponseEntity<?> getAllLikes(@PathVariable int postid){
		
		post p = postService.getPostsBypostId(postid);
	    return ResponseEntity.ok(p.getLikes().size());
	}
	
	@PostMapping(value="/addNewComment/{userid}/{postid}" ,headers = "Accept=application/json" )
	public ResponseEntity<?> addNewComment(@RequestBody comment comment ,@PathVariable int userid ,@PathVariable int postid )
	{ 
		post p = postService.getPostsBypostId(postid);
		user u = ur.findById(userid).get();
		comment.setUser(u);
		
		comment c = commentService.addComment(comment);
		p.getComments().add(c);
		
		postService.addPost(p);
		return ResponseEntity.ok("you commented on post");
	}
	
	@GetMapping("/getComments/{postid}")
	public List<comment> getCommentsOfPost(@PathVariable int postid){
	
		post p = postService.getPostsBypostId(postid);
	   
		return p.getComments();
	}
	
	
	
}

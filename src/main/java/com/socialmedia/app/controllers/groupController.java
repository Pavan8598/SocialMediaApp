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
import com.socialmedia.app.entities.post;
import com.socialmedia.app.entities.user;
import com.socialmedia.app.entities.usergroup;
import com.socialmedia.app.services.commentService;

@RestController
@CrossOrigin
public class groupController {
	
	@Autowired
	private com.socialmedia.app.services.groupService groupService; 
	
	@Autowired
	private com.socialmedia.app.services.commentService commentService; 
	@Autowired
	private com.socialmedia.app.services.grouppostService grouppostService; 
	
	@Autowired
	private com.socialmedia.app.repositories.userRepository userRepository;
 
	@PostMapping("/newgroup/{userid}")
	public ResponseEntity<usergroup> createGroup(@RequestBody usergroup usergroup , @PathVariable int userid)
	{
		user u= userRepository.findById(userid).get();
		usergroup.getUsers().add(u);
	
		return ResponseEntity.ok(groupService.CreateGroup(usergroup));
	
	}
	
	@GetMapping("/joingroup/{userid}/{groupid}")
	public ResponseEntity<?> JoinNewGroup( @PathVariable int userid ,@PathVariable int groupid)
	{
		user u= userRepository.findById(userid).get();
	    usergroup ug = groupService.getGroupById(groupid);
	    ug.getUsers().add(u);
	    groupService.CreateGroup(ug);
		return ResponseEntity.ok("You Joined the group");
	}
	
	@GetMapping("/leavegroup/{userid}/{groupid}")
	public ResponseEntity<?> leaveGroup( @PathVariable int userid ,@PathVariable int groupid)
	{
		user u= userRepository.findById(userid).get();
	    usergroup ug = groupService.getGroupById(groupid);
	    ug.getUsers().remove(u);
	    groupService.CreateGroup(ug);
		return ResponseEntity.ok("You leaved the group");
		
	}
	
	@GetMapping("/groupmembers/{groupid}")
	public List<user> getGroupMembers( @PathVariable int groupid)
	{
		
	    usergroup ug = groupService.getGroupById(groupid);
		return ug.getUsers();
		
	}
	
	@GetMapping("/groupmembersCount/{groupid}")
	public ResponseEntity<?> getGroupMembersCount( @PathVariable int groupid)
	{		
	    usergroup ug = groupService.getGroupById(groupid);
		return ResponseEntity.ok(ug.getUsers().size());
		
	}
	
	@PostMapping("/postinGroup/{groupid}/{userid}")
	public ResponseEntity<?> newgroupPost(@RequestBody post post, @PathVariable int groupid , @PathVariable int userid)
	{
		
		 usergroup ug = groupService.getGroupById(groupid);
			user u= userRepository.findById(userid).get();
		 if(ug.getType().equalsIgnoreCase("Private"))
		   {
		      if(ug.getUsers().contains(u))
			   {
		    	  post p = grouppostService.AddPostToGroup(post);
		    	  ug.getPosts().add(p);
		    	  grouppostService.AddPostToGroup(p);
			    	return ResponseEntity.ok(p);
			   }
			  else
			  {
				return ResponseEntity.ok("This group is Private and You are not allowed to create post");
			  }
		  }
		   else
		   {
			   post p = grouppostService.AddPostToGroup(post);
			   ug.getPosts().add(p);
			   grouppostService.AddPostToGroup(p);
		    	return ResponseEntity.ok(p);
		   }
		
	}
	
	@GetMapping("/getGroupPosts/{groupid}/{userid}")
	public ResponseEntity<?> getGroupPosts( @PathVariable int groupid ,  @PathVariable int userid)
	{  
		 usergroup ug = groupService.getGroupById(groupid);
			user u= userRepository.findById(userid).get();
	   if(ug.getType().equalsIgnoreCase("Private"))
	   {
	      if(ug.getUsers().contains(u))
		   {
	    
		    	return ResponseEntity.ok(ug.getPosts());
		   }
		  else
		  {
			return ResponseEntity.ok("This group is Private and You are not member of group");
		  }
	  }
	   else
	   {
			return ResponseEntity.ok(ug.getPosts());
	   }
		
	}
	
	@GetMapping("/liketheGrouppost/{postid}/{userid}")
	public ResponseEntity<?> likePost(@PathVariable int userid ,@PathVariable int postid){
		
		post p = grouppostService.getPostsBypostId(postid);
		user u= userRepository.findById(userid).get();
		
		p.getLikes().add(u);
		grouppostService.AddPostToGroup(p);
		return ResponseEntity.ok("you like the post");
	 
	}
	
	@GetMapping("/getAllLikesGroup/{postid}")
	public ResponseEntity<?> getAllLikesGroups(@PathVariable int postid){
		
		post p = grouppostService.getPostsBypostId(postid);
	    return ResponseEntity.ok(p.getLikes().size());
	}
	
	@PostMapping(value="/addNewCommentGroup/{userid}/{postid}" ,headers = "Accept=application/json" )
	public ResponseEntity<?> addNewComment(@RequestBody comment comment ,@PathVariable int userid ,@PathVariable int postid )
	{ 
		post p = grouppostService.getPostsBypostId(postid);
		user u= userRepository.findById(userid).get();
		comment.setUser(u);
		
		comment c = commentService.addComment(comment);
		p.getComments().add(c);
		grouppostService.AddPostToGroup(p);
		return ResponseEntity.ok("you commented on post");
	}
	
	@GetMapping("/getCommentsGroup/{postid}")
	public List<comment> getCommentsOfPostGroup(@PathVariable int postid){
	
		post p = grouppostService.getPostsBypostId(postid);
	   
		return p.getComments();
	}
	
	

}

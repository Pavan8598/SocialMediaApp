package com.socialmedia.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.comment;
import com.socialmedia.app.repositories.commentRepository;;


@Service
public class commentService {
 
	@Autowired
	private commentRepository commentRepository;
	
    
	public comment addComment(comment comment)
	{
	    return commentRepository.save(comment);
	}
	
	
}

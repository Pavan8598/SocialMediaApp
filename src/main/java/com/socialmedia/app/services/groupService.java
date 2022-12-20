package com.socialmedia.app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.app.entities.usergroup;
import com.socialmedia.app.repositories.groupRepository;

@Service
public class groupService {
	
	@Autowired
	private groupRepository groupRepository;
	
	public usergroup CreateGroup(usergroup usergroup)
	{
		return groupRepository.save(usergroup);
	}
	
	public usergroup getGroupById(int groupid)
	{
		return groupRepository.findById(groupid).get();
	}

}

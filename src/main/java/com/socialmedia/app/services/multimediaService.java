package com.socialmedia.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.app.entities.multimedia;
import com.socialmedia.app.repositories.multimediaRepository;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class multimediaService {
	
	@Autowired
	private multimediaRepository repo;

    public multimedia getVideo(String name) {
        if(!repo.existsByName(name)){
                try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
        return repo.findByName(name);
    }

   
    public List<String> getAllVideoNames() {
            return repo.getAllEntryNames();
    }

  
    public void saveVideo(MultipartFile file, String name)  {
        try {
    	if(repo.existsByName(name))
    	    {
                throw new Exception();
           }
        multimedia newVid = new multimedia(name, file.getBytes());
        repo.save(newVid);
        }
        catch(Exception e)
        {
        	
        }
    }
    
}
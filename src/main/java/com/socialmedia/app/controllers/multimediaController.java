package com.socialmedia.app.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.app.entities.multimedia;
import com.socialmedia.app.services.multimediaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class multimediaController {
	
	@Autowired
   private multimediaService videoService;

   
   @PostMapping("/postmultimedia")
   public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name)  {
       videoService.saveVideo(file, name);
       return ResponseEntity.ok("Video saved successfully.");
   }

  
   @GetMapping("/getmultimediaVideo/{name}")
   public ResponseEntity<byte[]> getVideoByName(@PathVariable("name") String name){
      
	   byte[] videoResource = videoService.getVideo(name).getData();
	   
	   return ResponseEntity.ok()
               .contentType(MediaType.parseMediaType("video/mp4"))
               .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=video_%s.%s", 1, "mp4"))
               .body(videoResource);
	   //return ResponseEntity.ok(new ByteArrayResource(videoService.getVideo(name).getData()));
   }
   
   @GetMapping(value ="/getmultimediaImage/{name}" )
   public ResponseEntity<byte[]> getImageByName(@PathVariable("name") String name) 
   {
      
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(videoService.getVideo(name).getData());
  }
		    
  

   @GetMapping("/allmultimediaNames")
   public ResponseEntity<List<String>> getAllVideoNames(){
       return ResponseEntity
               .ok(videoService.getAllVideoNames());
   }
}
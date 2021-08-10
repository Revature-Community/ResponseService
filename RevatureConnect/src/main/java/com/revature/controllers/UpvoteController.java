package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Upvote;
import com.revature.service.UpvoteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/upvote")
public class UpvoteController {

	@Autowired
	private UpvoteService userv;
	
	@PostMapping("/add-upvote")
	public ResponseEntity<Upvote> save(@RequestBody Upvote upvote) throws IOException {
		
		Upvote u = new Upvote();
		u.setPostId(upvote.getPostId());
		u.setUserId(upvote.getUserId());
		
		Upvote upvoteObject = userv.addUpvote(upvote);
		return new ResponseEntity<Upvote>(upvoteObject, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{upvoteId}")
	public ResponseEntity<Upvote> delete(@PathVariable("upvoteId") Integer upvoteId) {
		userv.deleteUpvote(upvoteId);
		return new ResponseEntity<Upvote>(HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
    public ResponseEntity<List<Upvote>> getUpvotesByPostId(@PathVariable("postId") int postId) { 
        List<Upvote> us = userv.getUpvotesByPostId(postId);
        return new ResponseEntity<List<Upvote>>(us, HttpStatus.OK); 
    }
}

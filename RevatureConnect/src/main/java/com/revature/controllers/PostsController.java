package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Posts;
import com.revature.service.PostsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostsController {

	@Autowired
	PostsService postsService;

	@GetMapping("/")
	public ResponseEntity<List<Posts>> getAllPost() {

		List<Posts> postList = postsService.getAllPost();

		return new ResponseEntity<>(postList, HttpStatus.OK);

	}
	
	@PostMapping("/addPost")
	public ResponseEntity<Posts> addPost(@RequestBody Posts post){
		System.out.println("Post info: " + post);
		Posts newPost = postsService.addPost(post);
		
		return ResponseEntity.ok().body(newPost);
		
	}
	
	@GetMapping("/byLocation/{locationId}")
    public ResponseEntity<List<Posts>> getPostsByLocationId(@PathVariable("locationId") int locationId) {
        List<Posts> postsByLocation = postsService.getPostsByLocationId(locationId);
        return new ResponseEntity<>(postsByLocation, HttpStatus.OK);
    }

}

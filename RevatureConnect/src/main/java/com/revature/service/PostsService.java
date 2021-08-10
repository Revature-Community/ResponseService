package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.models.Posts;
import com.revature.repositories.PostsRepository;

@Service
public class PostsService {

	@Autowired
	PostsRepository postsRepository;

	public List<Posts> getAllPost() {

		List<Posts> postsList = postsRepository.findAll();

		return postsList;

	}

	public Posts addPost(Posts post) {

		Posts newPost = postsRepository.save(post);

		return newPost;

	}

	public List<Posts> getPostsByLocationId(int locationId) {
        List<Posts> postsByLocationId = postsRepository.getPostsByLocationId(locationId);
        return postsByLocationId;
    }
}

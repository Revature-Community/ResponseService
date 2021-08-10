package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Downvote;
import com.revature.models.Posts;
import com.revature.repositories.DownvoteRepository;

@Service
@Transactional
public class DownvoteService {
	
	@Autowired
    private DownvoteRepository dvrepo;
	
    public List<Downvote> getAllDownvotesByPostId(int postId) {
        return dvrepo.getDownvotesByPostId(postId); 
    }

    public Downvote submitDownvote(Downvote downvote) {
        dvrepo.save(downvote);
        return downvote; 
    }

    public void deleteDownvote(int id) {
        Downvote deleted = dvrepo.findById(id).get();
        dvrepo.delete(deleted);
    }

}

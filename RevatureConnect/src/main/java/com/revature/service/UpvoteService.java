package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Upvote;
import com.revature.repositories.UpvoteRepository;

@Service
@Transactional
public class UpvoteService {
	@Autowired
	private UpvoteRepository urepo;
	
	public Upvote addUpvote(Upvote upvote) {
		urepo.save(upvote);
		return upvote;
	}
	
	public void deleteUpvote(Integer upvoteId) {
		Upvote deleted = urepo.findById(upvoteId).get();
		urepo.delete(deleted);
	}
	
    public List<Upvote> getUpvotesByPostId(int postId) {
        return urepo.getUpvotesByPostId(postId); 
    }
}

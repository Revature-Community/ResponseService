package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.Downvote;
import com.revature.models.Posts;

public interface DownvoteRepository extends JpaRepository<Downvote, Integer> {
	
	@Query(value = "SELECT * FROM downvote WHERE downvote.post_id = :postId", nativeQuery = true)
    List<Downvote> getDownvotesByPostId(@Param("postId") int postId);

}

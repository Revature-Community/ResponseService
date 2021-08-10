package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Posts;
import com.revature.models.Upvote;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote, Integer>{

    @Query(value = "SELECT * FROM upvote WHERE upvote.post_id = :postId", nativeQuery = true)
    List<Upvote> getUpvotesByPostId(@Param("postId") int postId);
}

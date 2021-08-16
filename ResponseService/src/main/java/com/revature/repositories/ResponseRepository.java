package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {

    @Query(value = "SELECT * FROM Response WHERE response.post_id = :postId", nativeQuery = true)
    List<Response> getResponsesByPostId(@Param("postId") int postId);

}
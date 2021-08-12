package com.revature.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.Downvote;
import com.revature.models.Posts;
import com.revature.models.User;
import com.revature.repositories.DownvoteRepository;
import com.revature.repositories.ResponseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DownvoteControllerIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager; 
	
	@Autowired
	private DownvoteRepository dvrepo;

	// This test is in a different class because the method is a NatvieSQL method
	@Test
	public void whenFindByPostId_thenReturnDownvotes() {
		//given - sets Response object to persist in mock database
		Downvote downvote = new Downvote(1, 1);
		entityManager.persist(downvote);
		entityManager.flush();
		
		//when - method to run
		List<Downvote> found = dvrepo.getDownvotesByPostId(1);
		
		//then - asserts that the method returns the correct Content
		for (Downvote f : found) {
		assertThat(f.getUserId()).isEqualTo(downvote.getUserId());
		}
	}

}

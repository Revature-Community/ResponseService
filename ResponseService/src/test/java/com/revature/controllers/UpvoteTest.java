package com.revature.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.Upvote;
import com.revature.repositories.UpvoteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UpvoteTest {

	@Autowired
	private TestEntityManager entityManager; 
	
	@Autowired
	private UpvoteRepository urepo;
	
	@Test
	public void whenFindPostById_thenReturnUpvotes() {
		//given
		Upvote upvote = new Upvote(1,1);
		entityManager.persist(upvote);
		entityManager.flush();
		
		//when
		List<Upvote> found = urepo.getUpvotesByPostId(1);
		
		for (Upvote f : found) {
		assertThat(f.getUserId()).isEqualTo(upvote.getUserId());
		}
	}
}

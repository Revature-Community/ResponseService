package com.revature.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.CategoryType;
import com.revature.models.Location;
import com.revature.models.Posts;
//import com.revature.controller.ResponseController;
import com.revature.models.Response;
import com.revature.repositories.ResponseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ResponseControllerIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager; 
	
	@Autowired
	private ResponseRepository rrepo;

	// This test is in a different class because the method is a NatvieSQL method
	@Test
	public void whenFindByPostId_thenReturnResponses() {
		//given - sets Response object to persist in mock database


	
		Response response = new Response("This is a test", 1, 1, "user");
		
		entityManager.persist(response);
		entityManager.flush();
		
//		Mockito.when(rrepo.getResponsesByPostId(id).thenReturn(response.getContent()));
		//when - method to run
		List<Response> found = rrepo.getResponsesByPostId(1);
		
		//then - asserts that the method returns the correct Content
		for (Response f : found) {
		assertThat(f.getContent()).isEqualTo(response.getContent());

		}
	}

}


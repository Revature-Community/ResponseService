package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Downvote;
import com.revature.models.Posts;
import com.revature.models.User;
import com.revature.service.DownvoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(DownvoteController.class)
public class DownvoteControllerPostTest {
	
	@Autowired 
	MockMvc mvc;
	
	@MockBean
	DownvoteService dvserv;
	
	private String toJson(Downvote dv) {
		try {
			return new ObjectMapper().writeValueAsString(dv);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	
	@Test
	public void submitDownvoteTest() throws Exception {
		// set Response object
		Downvote dv = new Downvote();
		dv.setId(1);
		dv.setPostId(1);
		dv.setUserId(1);
		
		mvc.perform(post("/downvotes/add-downvote")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(dv)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deleteDownvoteTest() throws Exception {
		// set Response object
		Downvote dv = new Downvote();
		dv.setId(1);
		dv.setPostId(1);
		dv.setUserId(1);
		
		// insert Response object into mock database
		mvc.perform(post("/downvotes/add-downvote")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(dv)));
		
		// perform Delete method on Response with Id 1 in mock database, checks for success  
		mvc.perform(delete("/downvotes/delete/1"))
				.andExpect(status().isOk());
	}

}

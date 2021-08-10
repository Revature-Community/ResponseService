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
import com.revature.models.Upvote;
import com.revature.service.UpvoteService;

@RunWith(SpringRunner.class)
@WebMvcTest(UpvoteController.class)
public class UpvoteTest2 {

	@Autowired 
	MockMvc mvc;
	
	@MockBean
	UpvoteService userv;
	
	private String toJson(Upvote u) {
		try {
			return new ObjectMapper().writeValueAsString(u);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	
	@Test
	public void addUpvoteTest() throws Exception {
		Upvote upvote = new Upvote(1,1);
		
		mvc.perform(post("/upvote/add-upvote")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(upvote)))
				.andExpect(status().isOk());
		
	}
	
	@Test
	public void deleteUpvoteTest() throws Exception {
		Upvote upvote = new Upvote(1,1);
		
		mvc.perform(post("/upvote/add-upvote")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(upvote)));
		
		mvc.perform(delete("/upvote/delete/1"))
				.andExpect(status().isOk());
	}
}

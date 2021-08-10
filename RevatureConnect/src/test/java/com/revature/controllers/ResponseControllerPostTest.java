package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.revature.models.Posts;
import com.revature.models.Response;
import com.revature.service.ResponseService;

@RunWith(SpringRunner.class)
@WebMvcTest(ResponseController.class)
public class ResponseControllerPostTest {

	@Autowired 
	MockMvc mvc;
	
	@MockBean
	ResponseService rserv;
	
	// turns objects into Json files in order to accurately communicate with the database
	private String toJson(Response r) {
		try {
			return new ObjectMapper().writeValueAsString(r);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	public Posts id = new Posts();
	
	
	@Test
	public void submitResponseTest() throws Exception {
		// set Response object
		Response r = new Response();
		r.setContent("hello i am test");
		r.setPostId(1);
		r.setUserId(1);
		r.setUsername("name");
		
		// insert Response object, check that method ran successfully
		mvc.perform(post("/responses/submit-response")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(r)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateResponseTest() throws Exception {
		// set Response object
		Response response = new Response("Testing update method",1, 1, "name");
		
		// insert Response object into mock database
		mvc.perform(post("/responses/submit-response")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(response)));
		
		// set new response object with same Id as old object
		Response r = new Response();
		r.setContent("hello i am test");
		r.setPostId(1);
		r.setUserId(1);
		r.setUsername("name");
		
		// perform update method, check that it ran successfully
		mvc.perform(put("/responses/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(r)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deleteResponseTest() throws Exception {
		// set Response object
		Response r = new Response();
		r.setContent("hello i am test");
		r.setPostId(1);
		r.setUserId(1);
		r.setUsername("name");
		
		// insert Response object into mock database
		mvc.perform(post("/responses/submit-response")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(r)));
		
		// perform Delete method on Response with Id 1 in mock database, checks for success  
		mvc.perform(delete("/responses/delete/1"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getResponseByIdTest() throws Exception {
		// set Response object
		Response r = new Response();
		r.setContent("hello i am test");
		r.setPostId(1);
		r.setUserId(1);
		r.setUsername("name");
		
		// insert Response object into mock database
		mvc.perform(post("/responses/submit-response")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJson(r)));
		
		// retrieve Response with Id 1 from mock database, checks for success  
		mvc.perform(get("/responses/responses/1"))
				.andExpect(status().isOk());
	}
}
package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.CategoryType;
import com.revature.models.Location;
import com.revature.models.Posts;
import com.revature.models.User;
import com.revature.service.PostsService;

@RunWith(SpringRunner.class)
@WebMvcTest(PostsController.class)
public class PostControllerTest {
	
	@Autowired 
	MockMvc mvc;
	
	@MockBean
	PostsService pserv;
	
	private String toJson(Posts p) {
		try {
			return new ObjectMapper().writeValueAsString(p);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	
	@Test
	public void addPostTest() throws Exception {
		Posts p = new Posts();
		Location l = new Location();
		l.setId(1);
		l.setCity("Reston");
		l.setState("Virginia");
		User user = new User();
		user.setEmail("test@gmail.com");
		p.setId(1);
		p.setCategoryType(CategoryType.Housing);
		p.setTitle("Title");
		p.setContent("Hello");
		p.setLocationId(l);
		p.setUser(user);
		p.setUserId(1);
		p.setUsername("Username");
		
		mvc.perform(post("/post/addPost")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(p)))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void getPostsByLocationId() throws Exception {
		Posts p = new Posts();
		Location l = new Location();
		l.setId(1);
		l.setCity("Reston");
		l.setState("Virginia");
		User user = new User();
		user.setEmail("test@gmail.com");
		p.setId(1);
		p.setCategoryType(CategoryType.Housing);
		p.setTitle("Title");
		p.setContent("Hello");
		p.setLocationId(l);
		p.setUser(user);
		p.setUserId(1);
		p.setUsername("Username");
		
		Posts p2 = new Posts();
		Location l2 = new Location();
		l2.setId(1);
		l2.setCity("Reston");
		l2.setState("Virginia");
		User user2 = new User();
		user.setEmail("test@gmail.com");
		p2.setId(1);
		p2.setCategoryType(CategoryType.Housing);
		p2.setTitle("Title");
		p2.setContent("Hello");
		p2.setLocationId(l2);
		p2.setUser(user2);
		p2.setUserId(1);
		p2.setUsername("Username");
		
		List<Posts> postsByLocationId = new ArrayList<>();
		postsByLocationId.add(p);
		postsByLocationId.add(p2);
		
		mvc.perform(get("/post/byLocation/1"))
				.andExpect(status().isOk());
	}
}

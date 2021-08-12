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
import com.revature.models.User;
import com.revature.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired 
	MockMvc mvc;
	
	@MockBean
	UserService userServ;
	
	private String toJson(User u) {
		try {
			return new ObjectMapper().writeValueAsString(u);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	
	@Test
	public void getAllUsersTest() throws Exception {
		List<User> allUsers = new ArrayList<>();
		User user = new User(1, "Email", "Username", "Password", "First", "Last");
		User user2 = new User(2, "Email", "Username", "Password", "First", "Last");
		allUsers.add(user);
		allUsers.add(user2);
		
		mvc.perform(get("/users/"))
			.andExpect(status().isOk());
				
	}
	
	@Test
	public void addUserTest() throws Exception {
		User user = new User(1, "Email", "Username", "Password", "First", "Last");
		
		mvc.perform(post("/users/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(user)))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void getUserByIdTest() throws Exception {
		User user = new User(1, "Email", "Username", "Password", "First", "Last");
		
		mvc.perform(post("/users/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(user)));
		
		mvc.perform(get("/users/1"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void loginUserTest() throws Exception {
		User user = new User(1, "Email", "Username", "Password", "First", "Last");
		
		mvc.perform(post("/users/login")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(user)))
			.andExpect(status().isOk());
	}
	
	
}


package com.revature.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Location;
import com.revature.service.LocationService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	LocationService lserv;
	
	private String toJson(Location l) {
		try {
			return new ObjectMapper().writeValueAsString(l);
		  } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}

	@Test
	void deleteLocation() throws Exception { 
		Location l = new Location();
		l.setId(1);
		l.setCity("Reston");
		l.setState("Virginia");
		
		mvc.perform(post("/locations/add/Reston/Virginia")
		.contentType(MediaType.APPLICATION_JSON)
		.content(toJson(l)));
		
		mvc.perform(delete("/locations/remove/Reston/Virginia"))
			.andExpect(status().isOk());

	}

	@Test
	void createLocation() throws Exception {
		Location l = new Location();
		l.setId(1);
		l.setCity("Reston");
		l.setState("Virginia");
		
		mvc.perform(post("/locations/add/Reston/Virginia")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(l)))
			.andExpect(status().isOk());
	}
	
	@Test
	void getLocationById() throws Exception {
		Location l = new Location();
		l.setId(1);
		l.setCity("Reston");
		l.setState("Virginia");
		
		mvc.perform(post("/locations/add/Reston/Virginia")
			.contentType(MediaType.APPLICATION_JSON)
			.content(toJson(l)));
		
		mvc.perform(get("/locations/1"))
			.andExpect(status().isOk());
	}
	

}




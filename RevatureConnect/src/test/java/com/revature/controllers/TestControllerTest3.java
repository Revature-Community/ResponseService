package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
class TestControllerTest3 {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHello() throws Exception {
		RequestBuilder req = get("/hello");
		MvcResult result = mockMvc.perform(req).andReturn();
		assertEquals("Hello, World",result.getResponse().getContentAsString());
	}
	
	

}

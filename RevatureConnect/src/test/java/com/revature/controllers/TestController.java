package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

		@GetMapping("/hello")
		public String hello(@RequestParam(name = "name", defaultValue="World")String name ) {
			String res = "Hello, " + name ;
			return res;
		}
}

package com.revature.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/users")
public class UserController {	

	@Autowired
	UserService userServ;

	@GetMapping(path = "/", produces = "application/json")
	public List<User> getAllUsers() {

		return userServ.findAll();

	}
	
	@GetMapping(path="/{id}",produces="application/json")
	public User getUserById(@PathVariable(value="id")int id) throws ResourceNotFoundException {
		return userServ.findOne(id);
	}


	@PostMapping(path="/login")
	public User loginUser(@RequestBody User user) throws ResourceNotFoundException{
		User userLoggedIn = userServ.login(user);
		
		return userLoggedIn;
	}
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewUser(@RequestBody User userToAdd) {
	
		//userToAdd.setRole(RoleTitle.User);
		User userSaved = userServ.save(userToAdd);
		
		return ResponseEntity.ok().body(userSaved);
	}

	@DeleteMapping("/remove/{name}")
	public Map<String, Boolean> removeUser(@PathVariable("email") String email) throws ResourceNotFoundException {
		return userServ.remove(email);

	}

}
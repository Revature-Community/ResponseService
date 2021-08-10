//package com.revature.controllers;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.revature.exceptions.ResourceNotFoundException;
//import com.revature.models.Role;
//import com.revature.models.UserRoles;
//import com.revature.service.UserRoleService;
//
//@RestController
//@CrossOrigin(origins="*")
//@RequestMapping("/userroles")
//public class UserRoleController {	
//
//	@Autowired
//	UserRoleService userRoleServ;
//
//	@GetMapping(path = "/", produces = "application/json")
//	public List<UserRoles> getAllUserRoles() {
//
//		return userRoleServ.findAll();
//
//	}
//	
//	@GetMapping(path="/{id}",produces="application/json")
//	public UserRoles getUserRoleById(@PathVariable(value="user_id")int id) throws ResourceNotFoundException {
//		return userRoleServ.findOne(id);
//	}
//
//	@PostMapping(path = "/add/{user_id}/{role_id}")
//	public ResponseEntity<Object> createNewRole(@PathVariable(value = "user_id") int user_id, @PathVariable(value = "role_id") int role_id) {
//		
//		UserRoles userRoleToAdd = new UserRoles(user_id, role_id);
//		UserRoles userRoleSaved = userRoleServ.save(userRoleToAdd);
//
//		//creating path to the userRole that was saved
//		URI userRoleURI = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(userRoleSaved.getUser_id()) 	
//				.toUri();
//		
//		//sending the path to the userRole in the response rather than the userRole obj itself
//		//if you need to access the userRole after creating it, you can make a quick get request using this URI
//		//If it turns out we are always immediately using the userRole object in the front end we can change this method
//		return ResponseEntity.created(userRoleURI).build();
//	}
//
//	@DeleteMapping("/remove/{name}")
//	public Map<String, Boolean> removeUserRole(@PathVariable("user_id") int id) throws ResourceNotFoundException {
//		return userRoleServ.remove(id);
//
//	}
//
//}

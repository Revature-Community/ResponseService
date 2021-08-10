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
//import com.revature.models.RoleTitle;
//import com.revature.service.RoleService;
//
//@RestController
//@CrossOrigin(origins="*")
//@RequestMapping("/roles")
//public class RoleController {	
//
//	@Autowired
//	RoleService roleServ;
//
//	@GetMapping(path = "/", produces = "application/json")
//	public List<Role> getAllRoles() {
//
//		return roleServ.findAll();
//
//	}
//	
//	@GetMapping(path="/{id}",produces="application/json")
//	public Role getRoleById(@PathVariable(value="id")int id) throws ResourceNotFoundException {
//		return roleServ.findOne(id);
//	}
//
//	@PostMapping(path = "/add/{title}")
//	public ResponseEntity<Object> createNewRole(@PathVariable(value = "title") RoleTitle title) {
//		
//		Role roleToAdd = new Role(title);
//		Role roleSaved = roleServ.save(roleToAdd);
//
//		//creating path to the role that was saved
//		URI roleURI = ServletUriComponentsBuilder.fromPath("")
//				.path("/{id}")
//				.buildAndExpand(roleSaved.getId())
//				.toUri();
//		
//		//sending the path to the role in the response rather than the role obj itself
//		//if you need to access the role after creating it, you can make a quick get request using this URI
//		//If it turns out we are always immediately using the role object in the front end we can change this method
//		return ResponseEntity.created(roleURI).build();
//	}
//
//	@DeleteMapping("/remove/{name}")
//	public Map<String, Boolean> removeRole(@PathVariable("title") RoleTitle title) throws ResourceNotFoundException {
//		return roleServ.remove(title);
//
//	}
//
//}

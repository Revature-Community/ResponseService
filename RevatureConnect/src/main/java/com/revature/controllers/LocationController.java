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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Location;
import com.revature.service.LocationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationService locServ;

	@GetMapping(path = "/", produces = "application/json")
	public List<Location> getAllLocations() {

		return locServ.findAll();

	}
	
	@GetMapping(path="/{id}",produces="application/json")
	public Location getLocationById(@PathVariable(value="id")int id) throws ResourceNotFoundException {
		return locServ.findOne(id);
	}



@PostMapping(path = "/add/{city}/{state}")
	public ResponseEntity<Object> createNewLocation(@PathVariable(value = "city") String city, @PathVariable(value = "state") String state) {
		
		Location locToSave = new Location(city, state);

		Location locSaved = locServ.save(locToSave);


		return ResponseEntity.ok().body(locSaved);
		
	}



	@DeleteMapping("/remove/{city}/{state}")
	public Map<String, Boolean> removeLocation(
			@PathVariable("city") String city, @PathVariable("state") String state) 
					throws ResourceNotFoundException {
		return locServ.remove(city, state);
	}
}






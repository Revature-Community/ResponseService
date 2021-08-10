package com.revature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Location;
import com.revature.models.Posts;
import com.revature.repositories.LocationRepository;
import com.revature.repositories.PostsRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	PostsRepository postRepo;

	// use to get all the locations from db
	public List<Location> findAll() {

		List<Location> locations = locRepo.findAll();

		return locations;
	}

	// use to add a new location to the db
	public Location save(Location location) {
		Location loc = locRepo.save(location);
		return loc;

	}
	

	// use to remove a location from the db
	public Map<String, Boolean> remove(String city, String state) throws ResourceNotFoundException {

		Location locToDel = locRepo.findOne(Example.of(new Location(city, state)))
				.orElseThrow(() -> new ResourceNotFoundException("Location not found"));

		locRepo.delete(locToDel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	public Location findOne(int id) throws ResourceNotFoundException {
		return locRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found"));
	}

}


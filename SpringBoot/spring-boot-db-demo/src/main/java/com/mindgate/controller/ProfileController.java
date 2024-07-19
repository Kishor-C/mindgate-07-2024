package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.beans.Profile;
import com.mindgate.exceptions.ProfileNotFoundException;
import com.mindgate.service.ProfileService;

@RestController
@RequestMapping("/api/v2")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	// find by id using path parameter, /profiles/2 [or] /profiles/3 [or] /profiles/4
	@GetMapping(path = "/profiles/{id}")
	public ResponseEntity<Object> fetchProfile(@PathVariable("id") int id) {
		try {
			Profile p = profileService.fetchProfile(id);
			return ResponseEntity.status(200).body(p);
		} catch(ProfileNotFoundException e) {
			String error = e.getMessage();
			return ResponseEntity.status(404).body(error);
		}
	}
	
	// find all the profiles
	@GetMapping(path = "/profiles")
	public ResponseEntity<Object> fetchProfiles() {
		List<Profile> list = profileService.fetchProfiles();
		return ResponseEntity.status(200).body(list);
	}
	// store the profile, consumes json from the request body
	@PostMapping(path = "/profiles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeProfile(@RequestBody Profile profile) {
		// save the profile and return the saved profile with status code 201
		Profile p = profileService.store(profile);
		return ResponseEntity.status(201).body(p);
	}
}

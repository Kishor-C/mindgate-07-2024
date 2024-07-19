package com.mindgate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.beans.Profile;
import com.mindgate.dao.ProfileRepository;
import com.mindgate.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceImpl implements ProfileService {
	// auto-wired the dao layer
	@Autowired
	private ProfileRepository profileRepository;
	
	// store method that takes Profile and returns saved profile
	@Override
	public Profile store(Profile profile) {
		// dao saves the profile in the table 
		return profileRepository.save(profile);
	}
	// fetch all profiles by calling dao.findAll()
	@Override
	public List<Profile> fetchProfiles() {
		return profileRepository.findAll();
	}
	// fetch profile based on the id, throw exception if profile not found
	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// import Optional from java.util package
		Optional<Profile> optional = profileRepository.findById(id);
		//orElseThrow has an inbuilt get() method if data is present
		return optional.orElseThrow(
				()->new ProfileNotFoundException("Profile "+id+" not found")
				);
//		if(optional.isPresent()) {
//			// don't call optional.get() without isPresent() because you will get error
//			Profile profile = optional.get(); // return the profile only if present
//			return profile;
//		} else {
//			throw new ProfileNotFoundException("Profile "+id+" not found!");
//		}
	}
}

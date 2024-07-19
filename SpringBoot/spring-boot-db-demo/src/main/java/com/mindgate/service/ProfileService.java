package com.mindgate.service;

import java.util.List;

import com.mindgate.beans.Profile;
import com.mindgate.exceptions.ProfileNotFoundException;

public interface ProfileService {

	// store method that takes Profile and returns saved profile
	Profile store(Profile profile);

	// fetch all profiles by calling dao.findAll()
	List<Profile> fetchProfiles();

	// fetch profile based on the id, throw exception if profile not found
	Profile fetchProfile(int id) throws ProfileNotFoundException;

}
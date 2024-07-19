package com.mindgate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mindgate.beans.Profile;

/*
 *  by extending CrudRepository<Profile, Integer>
 *  you get save(), delete(), findById(), findAll() methods that works
 *  on for Profile entity mapped to profile
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
/*
 * Access Type, ReturnType, MethodName, Parameters
 * public Profile save(Profile p): returns the saved entity, you can use this to update also
 * public List<Profile> findAll(): returns all the entities in the List format
 * public Optional<Profile> findById(int id): returns Optional which may or may not have
 *  the entity, you can use methods like: Optional.isPresent(), Optional.get() and so on
 *  Optional: Gives methods to check whether or not entity is found
 *  public void deleteById(int id): deletes the entity based on the id
 *  All the above methods provide SQL query to the database it has connected to
 */

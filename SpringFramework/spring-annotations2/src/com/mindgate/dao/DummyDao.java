package com.mindgate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // default id is = dummyDao
public class DummyDao {

	// injects the object of type Datasource
	@Autowired
	private Datasource datasource;
	// a dummy store() to only verify datasource is initialized
	public int store() {
		System.out.println("store() of DummyDao is called");
		System.out.println("DB username="+datasource.getUsername());
		return 1;
	}
}

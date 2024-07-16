package com.mindgate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.DummyDao;

@Service // id = dummyService
public class DummyService {

	@Autowired
	private DummyDao dao; 
	// service layer method takes dao result and generate exception
	// or success result if required
	public int store() {
		System.out.println("store of service()");
		int count = dao.store();
		return count;
	}
}

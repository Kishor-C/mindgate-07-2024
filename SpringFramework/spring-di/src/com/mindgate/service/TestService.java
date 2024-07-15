package com.mindgate.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindgate.dao.DBOperations;
import com.mindgate.dao.Datasource;

public class TestService {
	public static void main(String[] args) {
		// Considering this as a Service layer, we need to call the store method 
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DBOperations dbop = (DBOperations)context.getBean("dao");
		dbop.store();
	}
}

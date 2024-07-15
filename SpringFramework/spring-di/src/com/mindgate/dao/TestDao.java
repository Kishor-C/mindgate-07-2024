package com.mindgate.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {
	public static void main(String[] args) {
		// Considering this as a DAO layer, we need Database credentials 
		// i.e., present in Datasource object, so we need to call getters to get the credentials
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Datasource datasource = (Datasource)context.getBean("ds");
		// print the url, username, password & driverclassname
		System.out.println("URL="+datasource.getUrl());
		System.out.println("Username="+datasource.getUsername());
		System.out.println("Password="+datasource.getPassword());
		System.out.println("Driver Class="+datasource.getDriverClassName());
		// We will use these credentials in the DAO layer to connect to the database
		// which is pending as of now
		
	}
}

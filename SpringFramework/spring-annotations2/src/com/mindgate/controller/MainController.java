package com.mindgate.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindgate.service.DummyService;

// Once you use web app, you will not be using
// main method or ApplicationContext
public class MainController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		DummyService service = (DummyService)context.getBean("dummyService");
		// store() is calling dao.store(), dao.store() is calling datasource.getters()
		int result = service.store(); 
		System.out.println("Result="+result);
	}
}

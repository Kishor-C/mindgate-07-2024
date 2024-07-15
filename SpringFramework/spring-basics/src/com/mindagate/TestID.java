package com.mindagate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestID {
	public static void main(String[] args) {
		// client code that calls the print method only by 
		// using interface reference
		// get the object from the container and assign it to the
		// interface reference
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ID id = (ID)context.getBean("b");
		id.print();
		
	}
}

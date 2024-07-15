package com.mindagate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreetings {
	public static void main(String[] args) {
		// initializes the spring container
		// which reads the beans.xml and creates all the objects
		// configured using <bean>
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		// context.getBean("ID") returns the object from the container
		
		Test test = (Test)context.getBean("a");
		System.out.println(test.greet("Kishor"));
		
	}
}

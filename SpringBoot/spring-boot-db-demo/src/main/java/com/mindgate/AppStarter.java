package com.mindgate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *  below annotation does the auto-configuration based on the
 *  library you add, ex: if spring-boot-starter-web library 
 *  is added in your classpath - then this annotation does following
 *  tasks 
 *  a) component scan from base-package = com.mindgate
 *  b) front-controller configuration 
 *  c) adding embedded server to your project
 *  d) initializing the spring container
 */
@SpringBootApplication
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
		
		// inside run pass the class having @SpringBootApplication
		// args is a command line argument, right now its optional
	}
}

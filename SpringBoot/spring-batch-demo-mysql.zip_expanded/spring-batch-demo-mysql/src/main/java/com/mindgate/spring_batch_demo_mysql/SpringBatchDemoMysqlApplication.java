package com.mindgate.spring_batch_demo_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchDemoMysqlApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SpringBatchDemoMysqlApplication.class, args)));
		//SpringApplication.run(SpringBatchDemoMysqlApplication.class, args);
	}

}

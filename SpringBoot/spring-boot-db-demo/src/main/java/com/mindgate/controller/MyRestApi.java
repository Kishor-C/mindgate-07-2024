package com.mindgate.controller;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class MyRestApi {
	// a WebService is accessed with URL & HTTP methods
	@GetMapping(path = "/greet") // HTTP - GET
	public String greetings() { 
		return "Hello REST - HTTP GET";
	}
	@PostMapping(path = "/greet") // HTTP - POST
	public String greetings2() {
		return "Hello REST - HTTP POST";
	}
	@GetMapping(path = "/greet2")
	public ResponseEntity<Object> greet2() {
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello REST");
		map.put("time", LocalTime.now().toString());
		// map will be converted to JSON 
		// {"message":value, "time":value}
		return ResponseEntity.status(200).body(map);
	}
	
}

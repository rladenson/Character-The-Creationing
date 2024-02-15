package com.ctc.restservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.restservice.models.User;
import com.ctc.restservice.repository.UserRepository;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	UserRepository userRepository;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/users")
	public UserList userList() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return new UserList(users); // THIS RETURNS THE OBJECTS
									// THAT MEANS IT USES THE GETTERS YOU BUILT
	}
}
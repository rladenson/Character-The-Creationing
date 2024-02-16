package com.ctc.restservice.controllers.authentication;

import java.util.Set;

public record SignupRequest(String username, String password, Set<String> role) {

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Set<String> getRole() {
		return role;
	}

}

package com.ctc.restservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public User() { }
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// PUT GETTERS AND SETTERS HERE
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public String toString() {
		return username;
	}
	
}

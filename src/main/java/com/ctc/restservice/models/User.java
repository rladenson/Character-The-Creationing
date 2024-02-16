package com.ctc.restservice.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users", 
		uniqueConstraints = {
				@UniqueConstraint(columnNames="username")
		})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name="username")
	private String username;
	
	@NotBlank
	@Size(max = 120)
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
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

	public Set<Role> getRoles() {
		return roles;
	}
	
	public String getPassword() {
		return password;
	}
	
	public long getId() {
		return id;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}

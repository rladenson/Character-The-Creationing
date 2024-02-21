package com.ctc.restservice.models;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "characters_plus")
public class ComprehensiveCharacter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "alignment")
	private String alignment;

	@Column(name = "class")
	private String currentClass;
	
	@Column(name="completed_classes")
	private String[] completedClasses;

	@Column(name = "exaltation")
	private String exaltation;
	
	@Column(name = "resource")
	private String resource;
	
	@Column(name = "power")
	private String power;

	@Column(name = "race")
	private String race;

	@Column(name = "username")
	private String username;

	@Column(name = "user_id")
	private Long userId;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getAlignment() {
		return alignment;
	}

	public String getCurrentClass() {
		return currentClass;
	}
	
	public String[] getCompletedClasses() {
		return completedClasses;
	}

	public String getExaltation() {
		return exaltation;
	}
	
	public String getResource() {
		return resource;
	}
	
	public String getPower() {
		return power;
	}

	public String getRace() {
		return race;
	}

	public String getUsername() {
		return username;
	}

	public Long getUserId() {
		return userId;
	}
}

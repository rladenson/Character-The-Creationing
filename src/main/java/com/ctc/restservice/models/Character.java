package com.ctc.restservice.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ctc.restservice.controllers.characters.NewCharacterRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotBlank
	@Size(max = 20)
	@Column(name = "name")
	private String name;

	@Positive
	@Column(name = "age")
	private String age;

	@NotBlank
	@Size(max = 20)
	@Column(name = "race")
	private String race;

	@NotBlank
	@Size(max = 20)
	@Column(name = "exaltation")
	private String exaltation;

	@NotBlank
	@Size(max = 20)
	@Column(name = "resource")
	private String resource;

	@NotBlank
	@Size(max = 20)
	@Column(name = "power")
	private String power;

	@Size(max = 20)
	@Column(name = "alignment")
	private String alignment;

	@NotBlank
	@Size(max = 32)
	@Column(name = "class")
	private String currentClass;

	@Column(name = "completed_classes")
	private List<String> completedClasses;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CharacterStats stats;

	public Character() {
	}

	public Character(User user, NewCharacterRequest newCharacterRequest) {
		this.stats = new CharacterStats(newCharacterRequest);

		// mandatory values
		this.user = user;
		this.name = newCharacterRequest.name().trim();
		this.race = newCharacterRequest.race().trim();
		this.exaltation = newCharacterRequest.exaltation().trim();
		this.resource = newCharacterRequest.resource().trim();
		this.power = newCharacterRequest.power().trim();
		this.currentClass = newCharacterRequest.currentClass().trim();
		// optional values
		newCharacterRequest.age().ifPresent(a -> this.age = a);
		newCharacterRequest.alignment().ifPresent(al -> this.alignment = al);
		newCharacterRequest.completedClasses().ifPresentOrElse(classes -> {
			if(classes.trim().equals("")) {
				this.completedClasses = new ArrayList<String>();
			} else {
				this.completedClasses = Arrays.asList(classes.split(", ?"));
			}
		}, () -> this.completedClasses = new ArrayList<String>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CharacterStats getStats() {
		return stats;
	}

	@Override
	public String toString() {
		return name + " by " + user;
	}

	public UUID getId() {
		return id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getExaltation() {
		return exaltation;
	}

	public void setExaltation(String exaltation) {
		this.exaltation = exaltation;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public List<String> getCompletedClasses() {
		System.out.println(completedClasses);
		return completedClasses;
	}

	public void setStats(CharacterStats stats) {
		this.stats = stats;
	}
}

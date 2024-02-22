package com.ctc.restservice.models;

import java.util.Optional;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ctc.restservice.controllers.characters.NewCharacterRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	@Size(max = 20)
	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@NotBlank
	@Size(max = 20)
	@Column(name = "race")
	private String race;

	@NotBlank
	@Size(max = 20)
	@Column(name = "exaltation")
	private String exaltation;

	@Size(max = 20)
	@Column(name = "alignment")
	private String alignment;

	@NotBlank
	@Size(max = 32)
	@Column(name = "class")
	private String currentClass;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	public Character() {
	}

	public Character(User user, String name, String race, String exaltation, String currentClass, Optional<Integer> age,
			Optional<String> alignment) {
		this.user = user;
		this.name = name;
		this.race = race;
		this.exaltation = exaltation;
		this.currentClass = currentClass;
		age.ifPresent(a -> this.age = a);
		alignment.ifPresent(al -> this.alignment = al);
	}

	public Character(User user, NewCharacterRequest newCharacterRequest) {
		//mandatory values
		this.user = user;
		this.name = newCharacterRequest.name();
		this.race = newCharacterRequest.race();
		this.exaltation = newCharacterRequest.exaltation();
		this.currentClass = newCharacterRequest.currentClass();
		//optional values
		newCharacterRequest.age().ifPresent(a -> this.age = a);
		newCharacterRequest.alignment().ifPresent(al -> this.alignment = al);
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

	@Override
	public String toString() {
		return name + " by " + user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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
}

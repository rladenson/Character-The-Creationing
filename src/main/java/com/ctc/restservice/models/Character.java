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
	
	@NotBlank
	@Size(max=20)
	@Column(name="resource")
	private String resource;
	
	@NotBlank
	@Size(max=20)
	@Column(name="power")
	private String power;

	@Size(max = 20)
	@Column(name = "alignment")
	private String alignment;

	@NotBlank
	@Size(max = 32)
	@Column(name = "class")
	private String currentClass;
	
	@Column(name="completed_classes")
	private String[] completedClasses;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "stats_id", referencedColumnName = "_stats_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private CharacterStats stats;

	public Character() {
	}

	public Character(User user, NewCharacterRequest newCharacterRequest, CharacterStats stats) {
		//mandatory values
		this.user = user;
		this.name = newCharacterRequest.name();
		this.race = newCharacterRequest.race();
		this.exaltation = newCharacterRequest.exaltation();
		this.resource = newCharacterRequest.resource();
		this.power = newCharacterRequest.power();
		this.currentClass = newCharacterRequest.currentClass();
		//optional values
		newCharacterRequest.age().ifPresent(a -> this.age = a);
		newCharacterRequest.alignment().ifPresent(al -> this.alignment = al);
		newCharacterRequest.completedClasses().ifPresent(classes -> this.completedClasses = classes.split(", ?"));
		
		this.stats = stats;
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
	
	public CharacterStats getStats() {
		return stats;
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

	public void setAge(Optional<Integer> age) {
		age.ifPresent(a -> this.age = a);
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

	public void setAlignment(Optional<String> alignment) {
		alignment.ifPresent(al -> this.alignment = al);
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

	public String[] getCompletedClasses() {
		return completedClasses;
	}
}

package com.ctc.restservice.controllers.characters;

import java.util.Optional;

public record NewCharacterRequest(String name, String race, String exaltation, String resource, String power, String currentClass,
		Optional<Integer> age, Optional<String> alignment, Optional<String> completedClasses) {
	public String name() {
		return name;
	}

	public String race() {
		return race;
	}

	public String exaltation() {
		return exaltation;
	}

	public String resource() {
		return resource;
	}
	
	public String power() {
		return power;
	}
	
	public String currentClass() {
		return currentClass;
	}

	public Optional<Integer> age() {
		return age;
	}

	public Optional<String> alignment() {
		return alignment;
	}

	public Optional<String> completedClasses() {
		return completedClasses;
	}
}

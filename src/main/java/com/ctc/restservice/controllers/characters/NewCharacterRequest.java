package com.ctc.restservice.controllers.characters;

import java.util.Optional;

public record NewCharacterRequest(String name, String race, String exaltation, String currentClass,
		Optional<Integer> age, Optional<String> alignment) {
	public String name() {
		return name;
	}

	public String race() {
		return race;
	}

	public String exaltation() {
		return exaltation;
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
}

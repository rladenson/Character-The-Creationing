package com.ctc.restservice.controllers.characters;

import java.util.Optional;

import com.ctc.restservice.models.helpers.Characteristics;
import com.ctc.restservice.models.helpers.MentalSkills;
import com.ctc.restservice.models.helpers.PhysicalSkills;
import com.ctc.restservice.models.helpers.SocialSkills;

public record NewCharacterRequest(String name, String race, String exaltation, String resource, String power,
		String currentClass, Optional<String> age, Optional<String> alignment, Optional<String> completedClasses,
		Characteristics characteristics, Optional<Integer> level, Integer size, Optional<Long> xp,
		MentalSkills mentalSkills, PhysicalSkills physicalSkills, SocialSkills socialSkills) {
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

	public Optional<String> age() {
		return age;
	}

	public Optional<String> alignment() {
		return alignment;
	}

	public Optional<String> completedClasses() {
		return completedClasses;
	}

	public Characteristics characterisitics() {
		return characteristics;
	}

	public Optional<Integer> level() {
		return level;
	}

	public Integer size() {
		return size;
	}

	public Optional<Long> xp() {
		return xp;
	}

	public Characteristics characteristics() {
		return characteristics;
	}

	public MentalSkills mentalSkills() {
		return mentalSkills;
	}

	public PhysicalSkills physicalSkills() {
		return physicalSkills;
	}

	public SocialSkills socialSkills() {
		return socialSkills;
	}
}

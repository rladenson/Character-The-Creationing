package com.ctc.restservice.controllers.characters;

import java.util.Optional;

import com.ctc.restservice.models.helpers.Characteristics;
import com.ctc.restservice.models.helpers.MentalSkillsHelper;
import com.ctc.restservice.models.helpers.PhysicalSkillsHelper;
import com.ctc.restservice.models.helpers.SocialSkillsHelper;

public record NewCharacterRequest(String name, String race, String exaltation, String resource, String power,
		String currentClass, Optional<String> age, Optional<String> alignment, Optional<String> completedClasses,
		Characteristics characteristics, Optional<Integer> level, Integer size, Optional<Long> xp,
		MentalSkillsHelper mentalSkills, PhysicalSkillsHelper physicalSkills, SocialSkillsHelper socialSkills) {
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

	public MentalSkillsHelper mentalSkills() {
		return mentalSkills;
	}

	public PhysicalSkillsHelper physicalSkills() {
		return physicalSkills;
	}

	public SocialSkillsHelper socialSkills() {
		return socialSkills;
	}
}

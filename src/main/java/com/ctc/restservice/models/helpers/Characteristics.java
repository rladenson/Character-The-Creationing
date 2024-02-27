package com.ctc.restservice.models.helpers;

public class Characteristics {
	private Integer intelligence;
	private Integer wisdom;
	private Integer willpower;
	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer charisma;
	private Integer fellowship;
	private Integer composure;

	public Characteristics(Integer intelligence, Integer wisdom, Integer willpower, Integer strength, Integer dexterity,
			Integer constitution, Integer charisma, Integer fellowship, Integer composure) {
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.willpower = willpower;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.charisma = charisma;
		this.fellowship = fellowship;
		this.composure = composure;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public Integer getWillpower() {
		return willpower;
	}

	public Integer getStrength() {
		return strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public Integer getFellowship() {
		return fellowship;
	}

	public Integer getComposure() {
		return composure;
	}
}

package com.ctc.restservice.models;

import com.ctc.restservice.controllers.characters.NewCharacterRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "character_stats")
public class CharacterStats {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "intelligence", columnDefinition = "integer default 1")
	private Integer intelligence;

	@Column(name = "wisdom", columnDefinition = "integer default 1")
	private Integer wisdom;

	@Column(name = "willpower", columnDefinition = "integer default 1")
	private Integer willpower;

	@Column(name = "strength", columnDefinition = "integer default 1")
	private Integer strength;

	@Column(name = "dexterity", columnDefinition = "integer default 1")
	private Integer dexterity;

	@Column(name = "constitution", columnDefinition = "integer default 1")
	private Integer constitution;

	@Column(name = "charisma", columnDefinition = "integer default 1")
	private Integer charisma;

	@Column(name = "fellowship", columnDefinition = "integer default 1")
	private Integer fellowship;

	@Column(name = "composure", columnDefinition = "integer default 1")
	private Integer composure;

//	@NotBlank
//	@Column(name = "academic_lore")
//	private Integer academicLore;
//
//	@NotBlank
//	@Column(name = "arcana")
//	private Integer arcana;
//
//	@NotBlank
//	@Column(name = "common_lore")
//	private Integer commonLore;
//
//	@NotBlank
//	@Column(name = "crafts")
//	private Integer crafts;
//
//	@NotBlank
//	@Column(name = "forbidden_lore")
//	private Integer forbiddenLore;
//
//	@NotBlank
//	@Column(name = "medicae")
//	private Integer medicae;
//
//	@NotBlank
//	@Column(name = "perception")
//	private Integer perception;
//
//	@NotBlank
//	@Column(name = "politics")
//	private Integer politics;
//
//	@NotBlank
//	@Column(name = "tech_use")
//	private Integer techUse;
//
//	@NotBlank
//	@Column(name = "acrobatics")
//	private Integer acrobatics;
//
//	@NotBlank
//	@Column(name = "athletics")
//	private Integer athletics;
//
//	@NotBlank
//	@Column(name = "drive")
//	private Integer drive;
//
//	@NotBlank
//	@Column(name = "larceny")
//	private Integer larceny;
//
//	@NotBlank
//	@Column(name = "pilot")
//	private Integer pilot;
//
//	@NotBlank
//	@Column(name = "stealth")
//	private Integer stealth;
//
//	@NotBlank
//	@Column(name = "ballistics")
//	private Integer ballistics;
//
//	@NotBlank
//	@Column(name = "brawl")
//	private Integer brawl;
//
//	@NotBlank
//	@Column(name = "weaponry")
//	private Integer weaponry;
//
//	@NotBlank
//	@Column(name = "animal_ken")
//	private Integer animalKen;
//
//	@NotBlank
//	@Column(name = "charm")
//	private Integer charm;
//
//	@NotBlank
//	@Column(name = "command")
//	private Integer command;
//
//	@NotBlank
//	@Column(name = "deceive")
//	private Integer deceive;
//
//	@NotBlank
//	@Column(name = "disguise")
//	private Integer disguise;
//
//	@NotBlank
//	@Column(name = "intimidation")
//	private Integer intimidation;
//
//	@NotBlank
//	@Column(name = "performer")
//	private Integer performer;
//
//	@NotBlank
//	@Column(name = "persuasion")
//	private Integer persuasion;
//
//	@NotBlank
//	@Column(name = "scrutiny")
//	private Integer scrutiny;
//	
//	@Column(name = "xp")
//	private Integer xp;
//	
//	@PositiveOrZero
//	@Max(value=10)
//	@Column(name = "devotion")
//	private Integer devotion;
//	
//	@Positive
//	@Column(name="size")
//	private Integer size;
	
	public CharacterStats() {
		
	}
	
	public CharacterStats(NewCharacterRequest req) {
		Characteristics chars = req.characterisitics().get();
		
		this.intelligence = chars.getIntelligence();
		this.wisdom = chars.getWisdom();
		this.willpower = chars.getWillpower();
		this.strength = chars.getStrength();
		this.dexterity = chars.getDexterity();
		this.constitution = chars.getConstitution();
		this.charisma = chars.getCharisma();
		this.fellowship = chars.getFellowship();
		this.composure = chars.getComposure();
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getWillpower() {
		return willpower;
	}

	public void setWillpower(Integer willpower) {
		this.willpower = willpower;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public Integer getFellowship() {
		return fellowship;
	}

	public void setFellowship(Integer fellowship) {
		this.fellowship = fellowship;
	}

	public Integer getComposure() {
		return composure;
	}

	public void setComposure(Integer composure) {
		this.composure = composure;
	}

	public Long getId() {
		return id;
	}

}

package com.ctc.restservice.models;

import com.ctc.restservice.models.helpers.SocialSkillsHelper;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "social_skills")
public class SocialSkills {
	public SocialSkills() {

	}

	public SocialSkills(SocialSkillsHelper helper, CharacterStats stats) {
		this.animalKen = helper.getAnimalKen();
		this.charm = helper.getCharm();
		this.command = helper.getCommand();
		this.deceive = helper.getDeceive();
		this.disguise = helper.getDisguise();
		this.intimidation = helper.getIntimidation();
		this.performer = helper.getPerformer();
		this.persuasion = helper.getPersuasion();
		this.scrutiny = helper.getScrutiny();
		this.stats = stats;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "animal_ken", columnDefinition = "integer default 0")
	private Integer animalKen;

	@Column(name = "charm", columnDefinition = "integer default 0")
	private Integer charm;

	@Column(name = "command", columnDefinition = "integer default 0")
	private Integer command;

	@Column(name = "deceive", columnDefinition = "integer default 0")
	private Integer deceive;

	@Column(name = "disguise", columnDefinition = "integer default 0")
	private Integer disguise;

	@Column(name = "intimidation", columnDefinition = "integer default 0")
	private Integer intimidation;

	@Column(name = "performer", columnDefinition = "integer default 0")
	private Integer performer;

	@Column(name = "persuasion", columnDefinition = "integer default 0")
	private Integer persuasion;

	@Column(name = "scrutiny", columnDefinition = "integer default 0")
	private Integer scrutiny;

	public Integer getAnimalKen() {
		return animalKen;
	}

	public Integer getCharm() {
		return charm;
	}

	public Integer getCommand() {
		return command;
	}

	public Integer getDeceive() {
		return deceive;
	}

	public Integer getDisguise() {
		return disguise;
	}

	public Integer getIntimidation() {
		return intimidation;
	}

	public Integer getPerformer() {
		return performer;
	}

	public Integer getPersuasion() {
		return persuasion;
	}

	public Integer getScrutiny() {
		return scrutiny;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private CharacterStats stats;
}

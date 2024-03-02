package com.ctc.restservice.models;

import org.hibernate.annotations.Type;

import com.ctc.restservice.controllers.characters.NewCharacterRequest;
import com.ctc.restservice.models.helpers.Characteristics;
import com.ctc.restservice.models.helpers.MentalSkillsHelper;
import com.ctc.restservice.models.helpers.PhysicalSkillsHelper;
import com.ctc.restservice.models.helpers.SocialSkillsHelper;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

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

	@Column(name = "size", columnDefinition = "integer default 4")
	private Integer size;

	@Column(name = "xp", columnDefinition = "bigint default 600")
	private Long xp;

	@Column(name = "level", columnDefinition = "integer default 1")
	@Positive
	private Integer level;

//	@PositiveOrZero
//	@Max(value=10)
//	@Column(name = "devotion")
//	private Integer devotion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition="uuid", referencedColumnName="id", updatable=false)
	private Character character;

	@OneToOne(mappedBy = "stats", cascade = CascadeType.ALL)
	private MentalSkills mentalSkills;

	@OneToOne(mappedBy = "stats", cascade = CascadeType.ALL)
	private PhysicalSkills physicalSkills;

	@OneToOne(mappedBy = "stats", cascade = CascadeType.ALL)
	private SocialSkills socialSkills;

	public CharacterStats() {

	}

	public CharacterStats(NewCharacterRequest req, Character character) {
		MentalSkillsHelper mental = req.mentalSkills();
		PhysicalSkillsHelper physical = req.physicalSkills();
		SocialSkillsHelper social = req.socialSkills();

		this.mentalSkills = new MentalSkills(mental, this);
		this.physicalSkills = new PhysicalSkills(physical, this);
		this.socialSkills = new SocialSkills(social, this);

		Characteristics chars = req.characterisitics();

		this.intelligence = chars.getIntelligence();
		this.wisdom = chars.getWisdom();
		this.willpower = chars.getWillpower();
		this.strength = chars.getStrength();
		this.dexterity = chars.getDexterity();
		this.constitution = chars.getConstitution();
		this.charisma = chars.getCharisma();
		this.fellowship = chars.getFellowship();
		this.composure = chars.getComposure();

		this.size = req.size();

		req.xp().ifPresent(exp -> this.xp = exp);
		req.level().ifPresent(lvl -> this.level = lvl);

		this.character = character;
	}

	@Override
	public String toString() {
		return this.id.toString();
	}

	public Long getId() {
		return id;
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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getXp() {
		return xp;
	}

	public void setXp(Long xp) {
		this.xp = xp;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public MentalSkills getMentalSkills() {
		return mentalSkills;
	}

	public PhysicalSkills getPhysicalSkills() {
		return physicalSkills;
	}

	public SocialSkills getSocialSkills() {
		return socialSkills;
	}

}

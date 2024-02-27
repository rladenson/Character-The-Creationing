package com.ctc.restservice.models;

import com.ctc.restservice.controllers.characters.NewCharacterRequest;
import com.ctc.restservice.middleware.Characteristics;
import com.ctc.restservice.middleware.MentalSkills;
import com.ctc.restservice.middleware.PhysicalSkills;
import com.ctc.restservice.middleware.SocialSkills;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Column(name = "academic_lore", columnDefinition = "integer default 0")
	private Integer academicLore;

	@Column(name = "arcana", columnDefinition = "integer default 0")
	private Integer arcana;

	@Column(name = "common_lore", columnDefinition = "integer default 0")
	private Integer commonLore;

	@Column(name = "crafts", columnDefinition = "integer default 0")
	private Integer crafts;

	@Column(name = "forbidden_lore", columnDefinition = "integer default 0")
	private Integer forbiddenLore;

	@Column(name = "medicae", columnDefinition = "integer default 0")
	private Integer medicae;

	@Column(name = "perception", columnDefinition = "integer default 0")
	private Integer perception;

	@Column(name = "politics", columnDefinition = "integer default 0")
	private Integer politics;

	@Column(name = "tech_use", columnDefinition = "integer default 0")
	private Integer techUse;

	@Column(name = "acrobatics", columnDefinition = "integer default 0")
	private Integer acrobatics;

	@Column(name = "athletics", columnDefinition = "integer default 0")
	private Integer athletics;

	@Column(name = "drive", columnDefinition = "integer default 0")
	private Integer drive;

	@Column(name = "larceny", columnDefinition = "integer default 0")
	private Integer larceny;

	@Column(name = "pilot", columnDefinition = "integer default 0")
	private Integer pilot;

	@Column(name = "stealth", columnDefinition = "integer default 0")
	private Integer stealth;

	@Column(name = "ballistics", columnDefinition = "integer default 0")
	private Integer ballistics;

	@Column(name = "brawl", columnDefinition = "integer default 0")
	private Integer brawl;

	@Column(name = "weaponry", columnDefinition = "integer default 0")
	private Integer weaponry;

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

//	@PositiveOrZero
//	@Max(value=10)
//	@Column(name = "devotion")
//	private Integer devotion;

	public CharacterStats() {

	}

	public CharacterStats(NewCharacterRequest req) {
		Characteristics chars = req.characterisitics().get();
		MentalSkills mental = req.skills().get().getMental();
		PhysicalSkills physical = req.skills().get().getPhysical();
		SocialSkills social = req.skills().get().getSocial();

		this.intelligence = chars.getIntelligence();
		this.wisdom = chars.getWisdom();
		this.willpower = chars.getWillpower();
		this.strength = chars.getStrength();
		this.dexterity = chars.getDexterity();
		this.constitution = chars.getConstitution();
		this.charisma = chars.getCharisma();
		this.fellowship = chars.getFellowship();
		this.composure = chars.getComposure();
		
		this.academicLore = mental.getAcademicLore();
		this.arcana = mental.getArcana();
		this.commonLore = mental.getCommonLore();
		this.crafts = mental.getCrafts();
		this.forbiddenLore = mental.getForbiddenLore();
		this.medicae = mental.getMedicae();
		this.perception = mental.getPerception();
		this.politics = mental.getPolitics();
		this.techUse = mental.getTechUse();
		
		this.acrobatics = physical.getAcrobatics();
		this.athletics = physical.getAthletics();
		this.drive = physical.getDrive();
		this.larceny = physical.getLarceny();
		this.pilot = physical.getPilot();
		this.stealth = physical.getStealth();
		this.ballistics = physical.getBallistics();
		this.brawl = physical.getBrawl();
		this.weaponry = physical.getWeaponry();
		
		this.animalKen = social.getAnimalKen();
		this.charm = social.getCharm();
		this.command = social.getCommand();
		this.deceive = social.getDeceive();
		this.disguise = social.getDisguise();
		this.intimidation = social.getIntimidation();
		this.performer = social.getPerformer();
		this.persuasion = social.getPersuasion();
		this.scrutiny = social.getScrutiny();

		req.size().ifPresent(s -> this.size = s);
		req.xp().ifPresent(exp -> this.xp = exp);
		req.level().ifPresent(lvl -> this.level = lvl);
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

	public Integer getAcademicLore() {
		return academicLore;
	}

	public void setAcademicLore(Integer academicLore) {
		this.academicLore = academicLore;
	}

	public Integer getArcana() {
		return arcana;
	}

	public void setArcana(Integer arcana) {
		this.arcana = arcana;
	}

	public Integer getCommonLore() {
		return commonLore;
	}

	public void setCommonLore(Integer commonLore) {
		this.commonLore = commonLore;
	}

	public Integer getCrafts() {
		return crafts;
	}

	public void setCrafts(Integer crafts) {
		this.crafts = crafts;
	}

	public Integer getForbiddenLore() {
		return forbiddenLore;
	}

	public void setForbiddenLore(Integer forbiddenLore) {
		this.forbiddenLore = forbiddenLore;
	}

	public Integer getMedicae() {
		return medicae;
	}

	public void setMedicae(Integer medicae) {
		this.medicae = medicae;
	}

	public Integer getPerception() {
		return perception;
	}

	public void setPerception(Integer perception) {
		this.perception = perception;
	}

	public Integer getPolitics() {
		return politics;
	}

	public void setPolitics(Integer politics) {
		this.politics = politics;
	}

	public Integer getTechUse() {
		return techUse;
	}

	public void setTechUse(Integer techUse) {
		this.techUse = techUse;
	}

	public Integer getAcrobatics() {
		return acrobatics;
	}

	public void setAcrobatics(Integer acrobatics) {
		this.acrobatics = acrobatics;
	}

	public Integer getAthletics() {
		return athletics;
	}

	public void setAthletics(Integer athletics) {
		this.athletics = athletics;
	}

	public Integer getDrive() {
		return drive;
	}

	public void setDrive(Integer drive) {
		this.drive = drive;
	}

	public Integer getLarceny() {
		return larceny;
	}

	public void setLarceny(Integer larceny) {
		this.larceny = larceny;
	}

	public Integer getPilot() {
		return pilot;
	}

	public void setPilot(Integer pilot) {
		this.pilot = pilot;
	}

	public Integer getStealth() {
		return stealth;
	}

	public void setStealth(Integer stealth) {
		this.stealth = stealth;
	}

	public Integer getBallistics() {
		return ballistics;
	}

	public void setBallistics(Integer ballistics) {
		this.ballistics = ballistics;
	}

	public Integer getBrawl() {
		return brawl;
	}

	public void setBrawl(Integer brawl) {
		this.brawl = brawl;
	}

	public Integer getWeaponry() {
		return weaponry;
	}

	public void setWeaponry(Integer weaponry) {
		this.weaponry = weaponry;
	}

	public Integer getAnimalKen() {
		return animalKen;
	}

	public void setAnimalKen(Integer animalKen) {
		this.animalKen = animalKen;
	}

	public Integer getCharm() {
		return charm;
	}

	public void setCharm(Integer charm) {
		this.charm = charm;
	}

	public Integer getCommand() {
		return command;
	}

	public void setCommand(Integer command) {
		this.command = command;
	}

	public Integer getDeceive() {
		return deceive;
	}

	public void setDeceive(Integer deceive) {
		this.deceive = deceive;
	}

	public Integer getDisguise() {
		return disguise;
	}

	public void setDisguise(Integer disguise) {
		this.disguise = disguise;
	}

	public Integer getIntimidation() {
		return intimidation;
	}

	public void setIntimidation(Integer intimidation) {
		this.intimidation = intimidation;
	}

	public Integer getPerformer() {
		return performer;
	}

	public void setPerformer(Integer performer) {
		this.performer = performer;
	}

	public Integer getPersuasion() {
		return persuasion;
	}

	public void setPersuasion(Integer persuasion) {
		this.persuasion = persuasion;
	}

	public Integer getScrutiny() {
		return scrutiny;
	}

	public void setScrutiny(Integer scrutiny) {
		this.scrutiny = scrutiny;
	}

}

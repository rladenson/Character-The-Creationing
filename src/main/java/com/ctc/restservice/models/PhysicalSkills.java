package com.ctc.restservice.models;

import com.ctc.restservice.models.helpers.PhysicalSkillsHelper;

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
@Table(name = "physical_skills")
public class PhysicalSkills {
	public PhysicalSkills() {

	}

	public PhysicalSkills(PhysicalSkillsHelper helper, CharacterStats stats) {
		this.acrobatics = helper.getAcrobatics();
		this.athletics = helper.getAthletics();
		this.drive = helper.getDrive();
		this.larceny = helper.getLarceny();
		this.pilot = helper.getPilot();
		this.stealth = helper.getStealth();
		this.ballistics = helper.getBallistics();
		this.brawl = helper.getBrawl();
		this.weaponry = helper.getWeaponry();
		this.stats = stats;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public Integer getAcrobatics() {
		return acrobatics;
	}

	public Integer getAthletics() {
		return athletics;
	}

	public Integer getDrive() {
		return drive;
	}

	public Integer getLarceny() {
		return larceny;
	}

	public Integer getPilot() {
		return pilot;
	}

	public Integer getStealth() {
		return stealth;
	}

	public Integer getBallistics() {
		return ballistics;
	}

	public Integer getBrawl() {
		return brawl;
	}

	public Integer getWeaponry() {
		return weaponry;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private CharacterStats stats;
}

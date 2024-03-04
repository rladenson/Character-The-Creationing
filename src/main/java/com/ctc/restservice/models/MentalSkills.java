package com.ctc.restservice.models;

import com.ctc.restservice.models.helpers.MentalSkillsHelper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mental_skills")
public class MentalSkills {
	public MentalSkills() {

	}

	public MentalSkills(MentalSkillsHelper helper) {
		this.academicLore = helper.getAcademicLore();
		this.arcana = helper.getArcana();
		this.commonLore = helper.getCommonLore();
		this.crafts = helper.getCrafts();
		this.forbiddenLore = helper.getForbiddenLore();
		this.medicae = helper.getMedicae();
		this.perception = helper.getPerception();
		this.politics = helper.getPolitics();
		this.techUse = helper.getTechUse();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public Integer getAcademicLore() {
		return academicLore;
	}

	public Integer getArcana() {
		return arcana;
	}

	public Integer getCommonLore() {
		return commonLore;
	}

	public Integer getCrafts() {
		return crafts;
	}

	public Integer getForbiddenLore() {
		return forbiddenLore;
	}

	public Integer getMedicae() {
		return medicae;
	}

	public Integer getPerception() {
		return perception;
	}

	public Integer getPolitics() {
		return politics;
	}

	public Integer getTechUse() {
		return techUse;
	}
}

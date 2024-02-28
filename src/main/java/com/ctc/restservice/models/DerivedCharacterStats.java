package com.ctc.restservice.models;

import org.hibernate.annotations.View;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@View(query = "select 10 + 3*s.wisdom + 3*s.dexterity - 2*s.size as static_defense,"
		+ "	2 * (s.willpower + s.constitution) as max_hp,"
		+ "	5 + (5*s.composure) as mental_def,"
		+ "	s.willpower + s.composure as resolve,"
		+ "	s.strength + s.dexterity as speed,"
		+ "	1 + CEILING((s.size + s.level) / 2) as resilience,"
		+ "	s.dexterity + s.composure as initiative,"
		+ "	s.character_id as character_id"
		+ " FROM character_stats s;")
public class DerivedCharacterStats {

	@Column(name = "static_defense")
	private Integer staticDefense;

	@Column(name = "max_hp")
	private Integer maxHP;

	@Column(name = "mental_def")
	private Integer MentalDefense;

	@Column(name = "resolve")
	private Integer Resolve;

	@Column(name = "speed")
	private Integer speed;

	@Column(name = "resilience")
	private Integer resilience;

	@Column(name = "initiative")
	private Integer initiative;

	@Id
	@Column(name = "character_id")
	private Long characterId;

	public DerivedCharacterStats() {

	}

	public Integer getStaticDefense() {
		return staticDefense;
	}

	public Integer getMaxHP() {
		return maxHP;
	}

	public Integer getMentalDefense() {
		return MentalDefense;
	}

	public Integer getResolve() {
		return Resolve;
	}

	public Integer getSpeed() {
		return speed;
	}

	public Integer getResilience() {
		return resilience;
	}

	public Integer getInitiative() {
		return initiative;
	}

	public Long getCharacterId() {
		return characterId;
	}
}

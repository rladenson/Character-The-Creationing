package com.ctc.restservice.models;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Immutable
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
	@Column(name = "stats_id")
	private Long statsId;

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

	public Long getStatsId() {
		return statsId;
	}
}

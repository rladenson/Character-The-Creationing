package com.ctc.restservice.models.helpers;

import java.util.Optional;

public class PhysicalSkillsHelper {
	public PhysicalSkillsHelper(Optional<Integer> acrobatics, Optional<Integer> athletics, Optional<Integer> drive,
			Optional<Integer> larceny, Optional<Integer> pilot, Optional<Integer> stealth, Optional<Integer> ballistics,
			Optional<Integer> brawl, Optional<Integer> weaponry) {
		acrobatics.ifPresentOrElse(a -> this.acrobatics = a, () -> this.acrobatics = 0);
		athletics.ifPresentOrElse(a -> this.athletics = a, () -> this.athletics = 0);
		drive.ifPresentOrElse(a -> this.drive = a, () -> this.drive = 0);
		larceny.ifPresentOrElse(a -> this.larceny = a, () -> this.larceny = 0);
		pilot.ifPresentOrElse(a -> this.pilot = a, () -> this.pilot = 0);
		stealth.ifPresentOrElse(a -> this.stealth = a, () -> this.stealth = 0);
		ballistics.ifPresentOrElse(a -> this.ballistics = a, () -> this.ballistics = 0);
		brawl.ifPresentOrElse(a -> this.brawl = a, () -> this.brawl = 0);
		weaponry.ifPresentOrElse(a -> this.weaponry = a, () -> this.weaponry = 0);

	}

	private Integer acrobatics;
	private Integer athletics;
	private Integer drive;
	private Integer larceny;
	private Integer pilot;
	private Integer stealth;
	private Integer ballistics;
	private Integer brawl;
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
}

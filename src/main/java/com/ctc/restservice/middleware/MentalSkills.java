package com.ctc.restservice.middleware;

import java.util.Optional;

public class MentalSkills {
	public MentalSkills(Optional<Integer> academicLore, Optional<Integer> arcana, Optional<Integer> commonLore,
			Optional<Integer> crafts, Optional<Integer> forbiddenLore, Optional<Integer> medicae,
			Optional<Integer> perception, Optional<Integer> politics, Optional<Integer> techUse) {
		academicLore.ifPresentOrElse(a -> this.academicLore = a, () -> this.academicLore = 0);
		arcana.ifPresentOrElse(a -> this.arcana = a, () -> this.arcana = 0);
		commonLore.ifPresentOrElse(a -> this.commonLore = a, () -> this.commonLore = 0);
		crafts.ifPresentOrElse(a -> this.crafts = a, () -> this.crafts = 0);
		forbiddenLore.ifPresentOrElse(a -> this.forbiddenLore = a, () -> this.forbiddenLore = 0);
		medicae.ifPresentOrElse(a -> this.medicae = a, () -> this.medicae = 0);
		perception.ifPresentOrElse(a -> this.perception = a, () -> this.perception = 0);
		politics.ifPresentOrElse(a -> this.politics = a, () -> this.politics = 0);
		techUse.ifPresentOrElse(a -> this.techUse = a, () -> this.techUse = 0);

	}

	private Integer academicLore;
	private Integer arcana;
	private Integer commonLore;
	private Integer crafts;
	private Integer forbiddenLore;
	private Integer medicae;
	private Integer perception;
	private Integer politics;
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

package com.ctc.restservice.middleware;

import java.util.Optional;

public class SocialSkills {
	public SocialSkills(Optional<Integer> animalKen, Optional<Integer> charm, Optional<Integer> command,
			Optional<Integer> deceive, Optional<Integer> disguise, Optional<Integer> intimidation,
			Optional<Integer> performer, Optional<Integer> persuasion, Optional<Integer> scrutiny) {
		animalKen.ifPresentOrElse(a -> this.animalKen = a, () -> this.animalKen = 0);
		charm.ifPresentOrElse(a -> this.charm = a, () -> this.charm = 0);
		command.ifPresentOrElse(a -> this.command = a, () -> this.command = 0);
		deceive.ifPresentOrElse(a -> this.deceive = a, () -> this.deceive = 0);
		disguise.ifPresentOrElse(a -> this.disguise = a, () -> this.disguise = 0);
		intimidation.ifPresentOrElse(a -> this.intimidation = a, () -> this.intimidation = 0);
		performer.ifPresentOrElse(a -> this.performer = a, () -> this.performer = 0);
		persuasion.ifPresentOrElse(a -> this.persuasion = a, () -> this.persuasion = 0);
		scrutiny.ifPresentOrElse(a -> this.scrutiny = a, () -> this.scrutiny = 0);

	}

	private Integer animalKen;
	private Integer charm;
	private Integer command;
	private Integer deceive;
	private Integer disguise;
	private Integer intimidation;
	private Integer performer;
	private Integer persuasion;
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
}

package com.ctc.restservice.models.helpers;

public class Skills {
	public Skills(MentalSkills mental, PhysicalSkills physical, SocialSkills social) {
		this.mental = mental;
		this.physical = physical;
		this.social = social;
	}

	private MentalSkills mental;
	private PhysicalSkills physical;
	private SocialSkills social;

	public MentalSkills getMental() {
		return mental;
	}

	public PhysicalSkills getPhysical() {
		return physical;
	}

	public SocialSkills getSocial() {
		return social;
	}
}

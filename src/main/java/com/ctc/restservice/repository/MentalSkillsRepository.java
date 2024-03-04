package com.ctc.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.MentalSkills;

public interface MentalSkillsRepository extends JpaRepository<MentalSkills, Long> {
	
}

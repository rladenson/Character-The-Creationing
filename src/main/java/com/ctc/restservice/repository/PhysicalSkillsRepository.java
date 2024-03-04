package com.ctc.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.PhysicalSkills;

public interface PhysicalSkillsRepository extends JpaRepository<PhysicalSkills, Long> {
	
}

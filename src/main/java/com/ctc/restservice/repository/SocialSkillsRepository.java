package com.ctc.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.SocialSkills;

public interface SocialSkillsRepository extends JpaRepository<SocialSkills, Long> {
	
}

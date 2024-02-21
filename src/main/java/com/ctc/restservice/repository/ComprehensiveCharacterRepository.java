package com.ctc.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.Character;
import com.ctc.restservice.models.ComprehensiveCharacter;

public interface ComprehensiveCharacterRepository extends JpaRepository<ComprehensiveCharacter, Long> {
	List<Character> findByUserId(Long userId);
}

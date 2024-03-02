package com.ctc.restservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.Character;

public interface CharacterRepository extends JpaRepository<Character, UUID> {
	List<Character> findByUserId(Long userId);
}

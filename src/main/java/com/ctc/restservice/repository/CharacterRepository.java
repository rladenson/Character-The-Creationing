package com.ctc.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctc.restservice.models.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}

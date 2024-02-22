package com.ctc.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.CharacterStats;

public interface CharacterStatsRepository extends JpaRepository<CharacterStats, Long> {
}

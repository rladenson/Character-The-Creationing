package com.ctc.restservice.repository;

import java.util.UUID;

import com.ctc.restservice.models.DerivedCharacterStats;

public interface DerivedCharacterStatsRepository extends ReadOnlyRepository<DerivedCharacterStats, Long> {
	DerivedCharacterStats findByCharacterId(UUID id);
}

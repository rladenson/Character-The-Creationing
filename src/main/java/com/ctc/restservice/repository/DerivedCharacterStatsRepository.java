package com.ctc.restservice.repository;

import com.ctc.restservice.models.DerivedCharacterStats;

public interface DerivedCharacterStatsRepository extends ReadOnlyRepository<DerivedCharacterStats, Long> {
	DerivedCharacterStats findByStatsId(Long statsId);
}

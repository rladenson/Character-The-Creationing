package com.ctc.restservice.controllers.characters;

import com.ctc.restservice.models.Character;
import com.ctc.restservice.models.DerivedCharacterStats;

public record FullCharacterResponse(Character character, DerivedCharacterStats derivedStats, Long userId, String userName) {

}

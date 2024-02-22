package com.ctc.restservice.controllers.characters;

import com.ctc.restservice.models.CharacterStats;
import com.ctc.restservice.models.Character;

public record FullCharacterResponse(Character character, CharacterStats stats, Long userId, String userName) {

}

package com.ctc.restservice.controllers.characters;

import com.ctc.restservice.models.Character;

public record FullCharacterResponse(Character character, Long userId, String userName) {

}

package com.ctc.restservice.controllers.characters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.restservice.controllers.MessageResponse;
import com.ctc.restservice.models.Character;
import com.ctc.restservice.models.CharacterStats;
import com.ctc.restservice.models.DerivedCharacterStats;
import com.ctc.restservice.models.User;
import com.ctc.restservice.repository.CharacterRepository;
import com.ctc.restservice.repository.CharacterStatsRepository;
import com.ctc.restservice.repository.DerivedCharacterStatsRepository;
import com.ctc.restservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CharacterRepository characterRepository;
	@Autowired
	CharacterStatsRepository statsRepository;
	@Autowired
	DerivedCharacterStatsRepository derivedRepository;
	private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

	@PostMapping("/new")
	public ResponseEntity<?> newCharacter(Authentication authentication,
			@Valid @RequestBody NewCharacterRequest newCharacterRequest) {
		String userName = authentication.getName();
		User user = userRepository.findByUsername(userName).get();

		Character character = new Character(user, newCharacterRequest);

		characterRepository.save(character);

		return ResponseEntity.status(HttpStatus.CREATED).body(new CharacterResponse(character));
	}

	@GetMapping("")
	public CharacterList getMyCharacters(Authentication authentication) {
		String userName = authentication.getName();
		User user = userRepository.findByUsername(userName).get();
		List<Character> characters = characterRepository.findByUserId(user.getId());

		return new CharacterList(characters);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCharacter(@PathVariable UUID id) {
		Optional<Character> characterMaybe = characterRepository.findById(id);
		if (characterMaybe.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Character character = characterMaybe.get();
		DerivedCharacterStats derived = derivedRepository.findByCharacterId(character.getId());

		return ResponseEntity.ok().body(new FullCharacterResponse(character, derived, character.getUser().getId(),
				character.getUser().getUsername()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCharacter(Authentication authentication, @PathVariable UUID id) {
		Optional<Character> characterMaybe = characterRepository.findById(id);
		if (characterMaybe.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Character character = characterMaybe.get();

		String userName = authentication.getName();

		if (!character.getUser().getUsername().equals(userName)) {
			return new ResponseEntity<>("Can only delete your own members", HttpStatus.UNAUTHORIZED);
		}
		characterRepository.delete(character);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	public ResponseEntity<?> updateCharacter(Authentication authentication, @PathVariable UUID id,
			@RequestBody JsonPatch patch) {
		Optional<Character> characterMaybe = characterRepository.findById(id);
		if (characterMaybe.isEmpty())
			return ResponseEntity.notFound().build();
		Character character = characterMaybe.get();

		User user = character.getUser();
		if (!user.getUsername().equals(authentication.getName()))
			return new ResponseEntity<>("Can only edit your own members", HttpStatus.UNAUTHORIZED);

		try {
			Character patchedCharacter = applyPatchToCharacter(patch, character);
			patchedCharacter.setUser(user);
			characterRepository.save(patchedCharacter);
			return ResponseEntity.ok(patchedCharacter);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	private Character applyPatchToCharacter(JsonPatch patch, Character target)
			throws JsonPatchException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode patched = patch.apply(objectMapper.convertValue(target, JsonNode.class));
		return objectMapper.treeToValue(patched, Character.class);
	}
}

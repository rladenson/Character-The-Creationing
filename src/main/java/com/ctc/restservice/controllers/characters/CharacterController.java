package com.ctc.restservice.controllers.characters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.restservice.controllers.MessageResponse;
import com.ctc.restservice.models.Character;
import com.ctc.restservice.models.User;
import com.ctc.restservice.repository.CharacterRepository;
import com.ctc.restservice.repository.UserRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CharacterRepository characterRepository;
	
	@PostMapping("/new")
	public ResponseEntity<?> newCharacter(Authentication authentication, @Valid @RequestBody NewCharacterRequest newCharacterRequest) {
		String userName = authentication.getName();
		User user = userRepository.findByUsername(userName).get();
		Character character = new Character(user, newCharacterRequest);
		
		characterRepository.save(character);
		
		return ResponseEntity.ok(new MessageResponse("Yay!"));
	}
	
	@GetMapping("")
	public CharacterList getMyCharacters(Authentication authentication) {
		String userName = authentication.getName();
		User user = userRepository.findByUsername(userName).get();
		List<Character> characters = characterRepository.findByUserId(user.getId());
		
		return new CharacterList(characters);
	}
}

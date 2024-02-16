package com.ctc.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctc.restservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// if this was a list: List<User> findByUsername(String username);
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}

package com.ctc.restservice.controllers.authentication;

import java.util.List;

public record JwtResponse(String accessToken, Long id, String username, List<String> roles) {}

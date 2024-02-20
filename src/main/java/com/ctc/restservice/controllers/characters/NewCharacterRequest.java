package com.ctc.restservice.controllers.characters;

public record NewCharacterRequest(String name) {
	public String getName() {
		return name;
	}
}

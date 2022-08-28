package com.cognizant.signup.model;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class SignupResponse {
	
	private String requestId;
	private String message;

}

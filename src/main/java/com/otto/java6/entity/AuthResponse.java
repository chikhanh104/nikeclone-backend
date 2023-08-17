package com.otto.java6.entity;

import lombok.Builder;


@Builder
public class AuthResponse {
	String token;

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
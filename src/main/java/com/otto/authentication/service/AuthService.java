package com.otto.authentication.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.otto.authentication.entity.AuthResponse;
import com.otto.authentication.entity.Role;
import com.otto.authentication.entity.User;
import com.otto.authentication.jwt.JwtService;
import com.otto.authentication.repository.UserRepository;
import com.otto.authentication.request.LoginRequest;
import com.otto.authentication.request.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthResponse login(LoginRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
		return AuthResponse.builder().token(token).build();

	}

	public AuthResponse register(RegisterRequest request) {
		User user = User.builder().username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword())).firstname(request.getFirstname())
				.lastname(request.lastname).country(request.getCountry()).role(Role.USER).build();

		userRepository.save(user);

		return AuthResponse.builder().token(jwtService.getToken(user)).build();

	}
}

package com.otto.java6.service;

import java.util.Optional;

import com.otto.java6.entity.User;

public interface PasswordResetTokenService {

	String validatePasswordResetToken(String theToken);

	Optional<User> findUserByPasswordResetToken(String theToken);

	void resetPassword(User theUser, String password);

	void createPasswordResetTokenForUser(User user, String passwordResetToken);
}

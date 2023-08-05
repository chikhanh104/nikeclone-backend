package com.otto.java6.service;

import java.util.List;

import com.otto.java6.entity.User;

public interface UserService {
	
	User SAVEUSER(User user);
	
	List<User> GETALLUSER();
	
	
	
}

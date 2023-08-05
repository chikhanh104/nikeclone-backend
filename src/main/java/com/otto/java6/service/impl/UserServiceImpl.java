package com.otto.java6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otto.java6.entity.User;
import com.otto.java6.repository.UserRepository;
import com.otto.java6.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User SAVEUSER(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> GETALLUSER() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
}

package com.pontinhos.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontinhos.models.User;
import com.pontinhos.repositories.UserRepository;
import com.pontinhos.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String name) {
		return userRepository.getUserByName(name);
	}
	
}

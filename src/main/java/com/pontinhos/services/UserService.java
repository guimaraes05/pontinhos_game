package com.pontinhos.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pontinhos.models.User;

public interface UserService {
	
	List<User> findAll();
	
	User getUser(String name);
}

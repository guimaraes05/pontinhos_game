package com.pontinhos.services;

import java.util.List;

import com.pontinhos.dto.Users;
import com.pontinhos.models.User;

public interface UserService {
	
	List<User> findAll();
	
	User getUser(String name);
	
	void updateUserTologged(List<String> name);
	
	void updateAllToNotLogged();
	
	void updatePoints(Users users);
}

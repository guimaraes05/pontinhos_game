package com.pontinhos.services;

import com.pontinhos.dto.Users;
import com.pontinhos.models.User;

public interface SessionService {
	
	public void save(User user);
	
	public Users getSessionUsers();
}

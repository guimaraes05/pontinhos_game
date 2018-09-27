package com.pontinhos.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontinhos.dto.Users;
import com.pontinhos.models.User;
import com.pontinhos.repositories.SessionRepository;
import com.pontinhos.services.SessionService;

@Service
public class SessionServiceImpl implements SessionService{
	@Autowired
	private SessionRepository repository;
	
	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public Users getSessionUsers() {
		return repository.getSessionUsers();
	}

}

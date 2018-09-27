package com.pontinhos.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontinhos.dto.Users;
import com.pontinhos.models.Standings;
import com.pontinhos.models.User;
import com.pontinhos.repositories.SessionRepository;
import com.pontinhos.repositories.StandingsRepository;
import com.pontinhos.repositories.UserRepository;
import com.pontinhos.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StandingsRepository standingsRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String name) {
		return userRepository.getUserByName(name);
	}

	@Override
	public void updateUserTologged(List<String> names) {
		names.forEach(i -> userRepository.updateUserTologged(i));
		
	}

	@Override
	public void updateAllToNotLogged() {
		List<User> users = findAll();
		
		Standings standing = new Standings();
		standing.setSession(users);
		
		standingsRepository.save(standing);
		
		users.forEach(i -> userRepository.updateAllToNotLogged(i.getName()));
	}

	@Override
	public void updatePoints(Users users) {
		users.getUsers().forEach(i -> userRepository.updateUserPoints(i.getName(), i.getPoints()));
	} 
	
}

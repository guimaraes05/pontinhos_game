package com.pontinhos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pontinhos.dto.Users;
import com.pontinhos.models.User;
import com.pontinhos.services.SessionService;
import com.pontinhos.services.UserService;

@RestController
public class SessionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionService sessionService; 
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/session", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createSession(@RequestBody List<String> names) {
		
		userService.updateUserTologged(names);
		
		List<User> users = userService.findAll().stream()
												.filter(user -> user.getLoggedIn() == true)
												.map(i -> {i.setPoints(0); return i;})
												.collect(Collectors.toList());
		
		users.forEach(user -> sessionService.save(user));
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/destroy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void destroySession() {
		userService.updateAllToNotLogged();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/updatePoints", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updatePoints(@RequestBody List<User> users) {
		Users user = new Users();
		user.setUsers(users);
		userService.updatePoints(user);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usersSession", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Users usersSession() {
		return sessionService.getSessionUsers();
	}
}

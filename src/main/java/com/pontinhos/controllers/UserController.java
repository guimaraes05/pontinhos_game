package com.pontinhos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pontinhos.dto.Users;
import com.pontinhos.models.User;
import com.pontinhos.services.UserService;

@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String teste() {
		
		return "vaiiiiiiiiiiiiiiiii";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Users getUsers() {
		Users users = new Users();
		List<User> usersPersisted = userService.findAll();
		users.setUsers(usersPersisted);
		return users;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable("name") String userName) {
		String name = userName.toUpperCase();
		return userService.getUser(name);
	}
}

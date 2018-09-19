package com.pontinhos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pontinhos.models.User;
import com.pontinhos.services.UserService;

@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable("name") String userName) {
		String name = userName.toUpperCase();
		return userService.getUser(name);
	}
}

package com.pontinhos.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pontinhos.config.MongoConfig;
import com.pontinhos.dto.Users;
import com.pontinhos.models.User;

@Repository
public class SessionRepository {
	
	@Autowired
	private MongoConfig mongo; 
	
	public void save(User user) {
		mongo.operation().save(user, "session");
	}
	
	public Users getSessionUsers() {
		Users users = new Users();
		List<User> usersPersisted = mongo.operation().findAll(User.class, "session");
		users.setUsers(usersPersisted);
		return users;
	}
	
	public List<User> findAll() {
		List<User> users = mongo.operation().findAll(User.class);
		return users;
	} 
}

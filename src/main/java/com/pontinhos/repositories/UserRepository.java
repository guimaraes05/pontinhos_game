package com.pontinhos.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pontinhos.config.MongoConfig;
import com.pontinhos.models.User;

@Repository
public class UserRepository {
	
	@Autowired
	private MongoConfig mongo; 
	
	public List<User> findAll() {
		List<User> users = mongo.operation().findAll(User.class);
		return users;
	} 
	
	public User getUserByName(String name) {
		Query searchUserQuery = new Query(Criteria.where("name").is(name));
		User user = mongo.operation().findOne(searchUserQuery, User.class);
		return user;
	} 
}

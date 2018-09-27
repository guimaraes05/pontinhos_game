package com.pontinhos.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Standings {
	
	List<User> session;
	
	public Standings() {}
	
	public Standings(List<User> session) {
		super();
		this.session = session;
	}
	
	public List<User> getSession() {
		return session;
	}
	
	public void setSession(List<User> session) {
		this.session = session;
	}

}

package com.pontinhos.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class User {
	
	@Id
	private ObjectId _id;
	
	private String name;
	private String nVictories;
	
	public User() {}
	public User(ObjectId _id, String name, String nVictories) {
		super();
		this._id = _id;
		this.name = name;
		this.nVictories = nVictories;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getnVictories() {
		return nVictories;
	}
	
	public void setnVictories(String nVictories) {
		this.nVictories = nVictories;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
}

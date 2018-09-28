package com.pontinhos.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(new MongoClientURI("mongodb://teste:guimaraes05@ds117773.mlab.com:17773/heroku_d6f9mb39"));
	}

	@Override
	protected String getDatabaseName() {
		return "heroku_d6f9mb39";
	}

	public ApplicationContext applicationContext() {
		return new AnnotationConfigApplicationContext(MongoConfig.class);
	}
	
	public MongoOperations operation() {
		return (MongoOperations) applicationContext().getBean("mongoTemplate");
	}
}
package com.pontinhos.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("localhost");
	}

	@Override
	protected String getDatabaseName() {
		return "pontinhos";
	}

	
	
	public ApplicationContext applicationContext() {
		return new AnnotationConfigApplicationContext(MongoConfig.class);
	}
	
	public MongoOperations operation() {
		return (MongoOperations) applicationContext().getBean("mongoTemplate");
	}
}
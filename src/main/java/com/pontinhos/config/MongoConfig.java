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
		return new MongoClient("mongodb://<dbuser>:<dbpassword>@ds031651.mlab.com:31651/heroku_zftqfprt");
	}

	@Override
	protected String getDatabaseName() {
		return "heroku_zftqfprt";
	}

	
	
	public ApplicationContext applicationContext() {
		return new AnnotationConfigApplicationContext(MongoConfig.class);
	}
	
	public MongoOperations operation() {
		return (MongoOperations) applicationContext().getBean("mongoTemplate");
	}
}
package com.pontinhos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pontinhos.config.MongoConfig;
import com.pontinhos.models.Standings;

@Repository
public class StandingsRepository {
	
	@Autowired
	private MongoConfig mongo; 
	
	public void save(Standings standings) {
		mongo.operation().save(standings, "standings");
	}

}

package com.luv2code.springdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class Config {
	
	//define bean for fortune service:
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	//define bean for swim coach
	@Bean
	public Coach footballCoach() {
		return new FootballCoach(happyFortuneService());
	}
}

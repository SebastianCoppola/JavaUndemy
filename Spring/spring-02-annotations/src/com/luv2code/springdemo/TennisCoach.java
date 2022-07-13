package com.luv2code.springdemo;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	//dependencies:
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//constructor:
	public TennisCoach(){};
	
	//init and destroy methods:
	@PostConstruct
	public void myPostConstructMethod() {
		System.out.println("Object builded correctly");
	}
	@PreDestroy
	public void myPreDestroyMethod() {
		System.out.println("Object will be destroyed");
	}
	
	//super methods:
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}

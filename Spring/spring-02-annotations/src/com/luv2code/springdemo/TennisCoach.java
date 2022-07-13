package com.luv2code.springdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	//dependencies:
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//constructor:
	public TennisCoach(){};
	
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

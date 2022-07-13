package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	@Value("${email}")
	private String email;
	@Value("${team}")
	private String team;
	
	//constructor:
	public SwimCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	//super methods:
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meter.";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


	//toString:
	public String toString() {
		return "Swim coach's email: " + email + "\nSwim coach's team: " + team ;
	}

}

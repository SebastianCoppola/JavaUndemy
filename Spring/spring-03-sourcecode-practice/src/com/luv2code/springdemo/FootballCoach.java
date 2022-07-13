package com.luv2code.springdemo;


public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//constructor:
	public FootballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	//super methods:
	@Override
	public String getDailyWorkout() {
		return "Kick 10 penalties.";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}

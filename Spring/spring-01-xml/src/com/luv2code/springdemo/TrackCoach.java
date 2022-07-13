package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	//define a private field
	private FortuneService fortuneService;

		
	//no args Constructor
	public TrackCoach(){};
	
	//getters & setter method
	public FortuneService getFortuneService() {
		return this.fortuneService;
	}
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

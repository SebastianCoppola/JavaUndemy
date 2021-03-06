package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define a private field
	private FortuneService fortuneService;
	//define a constructor
	public BaseballCoach(){};
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use my fortune service
		return fortuneService.getFortune();
	}
	
	//init-method
	public void myInitMethod() {
		System.out.println("My Init Method");
	}
	//destroy-method
	public void myDestroyMethod() {
		System.out.println("My Destroy Method");
	}
}

package com.luv2code.springdemo;

public class TennisCoach implements Coach{
	
	//define a private field
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	//no args Constructor
	public TennisCoach(){};
	//getters & setter method
	public FortuneService getFortuneService() {
		return this.fortuneService;
	}
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	public String getEmailAddress() {
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	
	@Override
	public String getDailyWorkout() {
		return "Do 100 pushups";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}

package com.luv2code.springdemo;

public class TennisCoach implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "Do 100 pushups";
	}
}

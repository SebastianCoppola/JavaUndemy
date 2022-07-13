package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoachMainApp {

	public static void main(String[] args) {
		
		//read configuration class:
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);

		//get bean from spring container:
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call bean methods:
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close context:
		context.close();

	}

}

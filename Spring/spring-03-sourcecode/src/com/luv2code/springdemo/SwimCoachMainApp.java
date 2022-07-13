package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachMainApp {

	public static void main(String[] args) {
		
		//read configuration class:
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(SportConfig.class);

		//get bean from spring container:
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		//call bean methods:
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach);
		
		//close context:
		context.close();

	}

}

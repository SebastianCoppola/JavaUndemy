package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read config file:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//get bean:
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call bean methods:
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	
		//close context:
		context.close();

	}

}

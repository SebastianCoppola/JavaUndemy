package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMainApp {

	public static void main(String[] args) {
		
		//load spring configuration file:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retreivebean from container: 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println("Couch says: " + theCoach.getDailyWorkout());
		System.out.println("Couch says: " + theCoach.getDailyFortune());

		//close context:
		context.close();
	}

}

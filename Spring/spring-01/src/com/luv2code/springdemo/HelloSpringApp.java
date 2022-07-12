package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		//retrieve bean from the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theTrackCoach = context.getBean("myTrackCoach", Coach.class);
		Coach theTennisCoach = context.getBean("myTennisCoach", Coach.class);
		
		//call coach methods:
		System.out.println("Couch says: " + theCoach.getDailyWorkout());
		System.out.println("Couch says: " + theCoach.getDailyFortune());
		System.out.println("");
		
		//call the tennis couch methods:
		System.out.println("Tennis Couch says: " + theTennisCoach.getDailyWorkout());
		System.out.println("Tennis Couch says: " + theTennisCoach.getDailyFortune());
		System.out.println("Tennis Couch Email: " + ((TennisCoach)theTennisCoach).getEmailAddress());
		System.out.println("Tennis Couch Email: " + ((TennisCoach)theTennisCoach).getTeam());
		System.out.println("");
		
		//call the track couch methods:
		System.out.println("Track Couch says: " + theTrackCoach.getDailyWorkout());
		System.out.println("Track Couch says: " + theTrackCoach.getDailyFortune());
		
		//close the context
		context.close();

	}

}

package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring configuration file:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retreivebean from container: 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they point to the same area of memory
		boolean result = (theCoach == alphaCoach);
		System.out.println("Pointion to the same object? " + result);
		System.out.println("theCoach location: " + theCoach);
		System.out.println("alphaCoach location: " + alphaCoach);
	}

}

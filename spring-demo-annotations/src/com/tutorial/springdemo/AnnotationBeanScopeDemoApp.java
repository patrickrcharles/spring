package com.tutorial.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach",TennisCoach.class);
		

		// call a method
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
	}

}

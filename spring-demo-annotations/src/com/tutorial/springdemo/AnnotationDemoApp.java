package com.tutorial.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		// call a method
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		//close context
		context.close();
	}
}

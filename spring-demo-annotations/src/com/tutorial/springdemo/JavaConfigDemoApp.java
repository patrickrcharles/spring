package com.tutorial.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println(theCoach.getDailyFortune());
		
		// get email/team info
		//theCoach.getInfo();
		
		//close context
		context.close();
	}
}

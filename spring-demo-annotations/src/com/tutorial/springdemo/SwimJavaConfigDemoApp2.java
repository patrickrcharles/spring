package com.tutorial.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp2 {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method
		System.out.println(theCoach.getDailyWorkout());
		
		// get fortune
		System.out.println(theCoach.getDailyFortune());
		
		// get email/team info
		//theCoach.getInfo();
		
		//call new swim coach methods with props file injection
		System.out.println("	email :: "+ theCoach.getEmail());
		System.out.println("	team :: "+ theCoach.getTeam());
		
		//close context
		context.close();
	}
}

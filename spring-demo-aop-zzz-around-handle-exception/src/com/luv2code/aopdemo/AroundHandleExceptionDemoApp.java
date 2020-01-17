package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program : AroundDemoApp");
		System.out.println("...calling Fortune");
		
		boolean tripWire = true;		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("my fortune is : " + data);
		System.out.println("...finished");
		
		// close the context
		context.close();
	}

}

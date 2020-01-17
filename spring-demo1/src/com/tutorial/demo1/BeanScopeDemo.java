package com.tutorial.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {

		// load the spring config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to same object : "+result);
		System.out.println("\nMemeory location : theCoach : "+ theCoach);
		System.out.println("\nMemeory location : alphacoach : "+ alphaCoach + "\n");
		
		context.close();
	}

}

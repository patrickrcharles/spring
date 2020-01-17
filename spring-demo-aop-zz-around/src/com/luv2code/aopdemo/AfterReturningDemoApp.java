package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		// display the account
		System.out.println("*********************************************");
		System.out.println("Main Program: AfterReturningDemoAoo");
		System.out.println("---------------------------------------------");
		System.out.println(theAccounts);
		System.out.println("\n*********************************************");
		
		
		// close the context
		context.close();
	}

}

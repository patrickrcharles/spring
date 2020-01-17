package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call business method 
		Account myAccount = new Account();
		myAccount.setName("Rick");
		myAccount.setLevel("Executive");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		//call get/set methods
		theAccountDAO.setName("Jimmy");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		
		// get membership from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call membershipDAO method
		theMembershipDAO.addAccount();
		theMembershipDAO.sleep();
		
		// close the context
		context.close();
	}

}

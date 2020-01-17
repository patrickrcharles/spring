package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount() {
		System.out.println(getClass() + ": MembershipDAO : Adding an membership account");
		return true;
	}
	
	public void sleep() {
		System.out.println(getClass() + ": sleep()");
	}
}

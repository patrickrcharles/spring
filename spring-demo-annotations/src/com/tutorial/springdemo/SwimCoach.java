package com.tutorial.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;	    
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		System.out.println("SwimCoach :: public voidSwimCoach()");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {;
	System.out.println("SwimCoach :: public String getDailyWorkout()");
		return "Swim like a donkey";
	}
	
	@Override
	public String getDailyFortune() {
		System.out.println("SwimCoach :: public String getDailyFortune()");
		return fortuneService.getFortune();
	}

	public void getInfo() {
		System.out.println("SwimCoach :: public void getInfo() {");
		System.out.println("	email :: " + email);
		System.out.println("	team  :: " + team);
	}

	public String getEmail() {
		System.out.println("SwimCoach :: public void getEmail() {");
		return email;
	}

	public String getTeam() {
		System.out.println("SwimCoach :: public void getTeam() {");
		return team;
	}
	

}

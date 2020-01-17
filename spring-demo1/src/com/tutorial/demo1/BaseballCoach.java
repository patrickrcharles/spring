package com.tutorial.demo1;

public class BaseballCoach implements Coach{
	
	// define a private field
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection.
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		//use fortuneService to get a fortune	
		return fortuneService.getFortune();
	}
}

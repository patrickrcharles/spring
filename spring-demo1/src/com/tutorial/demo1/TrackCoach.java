package com.tutorial.demo1;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: "+ fortuneService.getFortune();
	}
	
	// add init method
	public void doMyInitStuff() {
		System.out.println("TrackCoach : doMyInitStuff ");
	}
	
	//add destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : doMyCleanupStuff ");
	}
}

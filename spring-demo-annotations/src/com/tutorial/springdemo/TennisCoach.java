package com.tutorial.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// constructor injection
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		System.out.println("public class TennisCoach :: theFortuneService = " + theFortuneService);
//		fortuneService = theFortuneService;
//	}
	
	public TennisCoach() {
		System.out.println("TennisCoach :: public void TennisCoach()");
	}
	
	//define init method
	@PostConstruct
	public void startup() {
		System.out.println("TennisCoach :: startup()");
	}
	
	//define destroy method
	@PreDestroy
	public void destroy() {
		System.out.println("TennisCoach :: destroy()");
	}

	@Override
	public String getDailyWorkout() {;
	System.out.println("TennisCoach :: public String getDailyWorkout()");
		return "Practice backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

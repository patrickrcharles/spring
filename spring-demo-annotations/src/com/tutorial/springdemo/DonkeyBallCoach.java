package com.tutorial.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DonkeyBallCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do some donkey stuff";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.tutorial.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("HappyFortuneService :: public String getFortune()");
		return "Today is your lucky day";
	}

	@Override
	public String setFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

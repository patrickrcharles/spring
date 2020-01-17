package com.tutorial.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("RESTFortuneService :: public String getFortune()");
		return null;
	}

	@Override
	public String setFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

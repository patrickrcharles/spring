package com.tutorial.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		System.out.println("DatabaseFortuneService :: public String getFortune()");
		return null;
	}

	@Override
	public String setFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.tutorial.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You gonna cry, little girl?";
	}

	@Override
	public String setFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

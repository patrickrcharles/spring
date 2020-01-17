package com.tutorial.springdemo;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create array of strings
	private String[] data = {
			"sup dork",
			"wazzzzzzuuuupppp",
			"up yours, honky",
			"lol"};
	private Random randFortune = new Random();
	
	@Override
	public String getFortune() {
		System.out.println("RandomFortuneService :: public String getFortune()");
		
		// create random fortune
		int index = randFortune.nextInt(data.length);
		System.out.println("	int index :: "+ index);
		String theFortune = data[index];
		System.out.println("	String theFortune :: "+ theFortune);
		return theFortune;
	}

	@Override
	public String setFortune() {
		return null;
	}

}

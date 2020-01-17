package com.tutorial.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

public class FileFortuneService implements FortuneService {

	private String fileName = "src/fortunes.properties";
	private ArrayList<String> theFortunes;

	// create a random number generator
	private Random myRandom = new Random();

	public FileFortuneService() {

		System.out.println(">> FileFortuneService: inside default constructor");
	}

	@PostConstruct
	private void loadTheFortunesFile() {

		System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

		File theFile = new File(fileName);

		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());

		// initialize array list
		theFortunes = new ArrayList<String>();
		

		// read fortunes from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			
			System.out.println("try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {");
			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
				System.out.println("templine :: "+ tempLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		System.out.println("FileFortuneService :: public String getFortune()");
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		
		System.out.println("	index        :: " + index);
		System.out.println("	tempFortune  :: " + tempFortune);

		return tempFortune;
	}
	

	@Override
	public String setFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject coach/team name

	@Value("${coach.name}")
	private  String coachname;

	@Value("${team.name}")
	private  String teamName;

	// expose new enpoint for 'teaminfo'
	@GetMapping("/teaminfo")
	public String getTeamInfo(){
		return "Coach : "+ coachname + " , Team name : "+ teamName;
	}

	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// expose a new endpoint for 'workout'
	@GetMapping("/workout")
	public String getDailyWorkout(){
		return "run a hard 5k";
	}

	// expose a new endpoint for 'fortune'
	@GetMapping("/fortune")
	public String getDailyFortune(){
		return "beware the night. draculas are afoot";
	}

}













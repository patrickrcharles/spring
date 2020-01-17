package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		System.out.println("DemoController: showHome()");
		
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		System.out.println("DemoController: showLeaders()");
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems() {
		System.out.println("DemoController: showSystems()");
		
		return "systems";
	}
	
	
	
}

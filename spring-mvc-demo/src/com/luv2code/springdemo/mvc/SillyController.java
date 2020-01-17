package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	public String displayTheForm() {
		return "silly";
	}
	
	//controller method to show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";		
	}

	//controller method to process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
}

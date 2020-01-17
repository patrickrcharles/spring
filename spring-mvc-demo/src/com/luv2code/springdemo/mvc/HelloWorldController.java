package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
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
	
	//new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		
		//read the request parameter from html form
		String theName = request.getParameter("studentName");
		
		//convert data to uppercase
		theName = theName.toUpperCase();
		
		//create the message
		String result ="Ayyyyy lol wazzuuuppp " + theName;
				
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	//new controller method to read form data and add data to model
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, Model model) {
		
		//convert data to uppercase
		theName = theName.toUpperCase();
		
		//create the message
		String result ="What up, " + theName;
				
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}

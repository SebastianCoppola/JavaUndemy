package com.mavenmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//show the initial htmlForm
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read request param from html form
		String theName = request.getParameter("studentName");
		//convert data to UPPERCASE
		theName = theName.toUpperCase();
		//create a message
		String result = "Yo! " + theName;
		//add message to model
		model.addAttribute("message",result);
		
		return "helloworld-confirmation";
	}
	
	//read and add to model from AnnotationParam
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		//convert data to UPPERCASE
		theName = theName.toUpperCase();
		//create a message
		String result = "Hey " + theName;
		//add message to model
		model.addAttribute("message",result);
		
		return "helloworld-confirmation";
	}
	
	
}

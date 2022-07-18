package com.mavenmvc.controller;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add initBinder to convert or trim input strings
	//remover leading and trailing whitespace
	//resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
		
	//showing form:
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	//processing & validation method:
	@RequestMapping("/processForm")
	public String processForm(
		@Valid @ModelAttribute("customer") Customer theCustomer,
		BindingResult theBindingResult) {
		
		System.out.println("lastName: | " + theCustomer.getLastName() + " |");
		
		if(theBindingResult.hasErrors()){
			return "customer-form";
		}else{
			return "customer-confirmation";
		}
	}
	
}

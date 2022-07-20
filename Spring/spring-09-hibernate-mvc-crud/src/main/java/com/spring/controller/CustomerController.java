package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.CustomerDAO;
import com.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject DAO:
	@Autowired
	private CustomerDAO customerDAO;
		
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from DAO:
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add customers to the spring-mvc model:
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
	
}

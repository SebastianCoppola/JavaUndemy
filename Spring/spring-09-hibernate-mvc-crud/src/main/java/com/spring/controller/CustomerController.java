package com.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;
import com.spring.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject CustomerService:
	@Autowired
	private CustomerService customerService;
		
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from DAO:
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the spring-mvc model:
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		//save the customer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId") int customerId,
								Model theModel) {
		//get customer from database:
		Customer theCustomer = customerService.getCustomer(customerId);
		
		//set customer as model to pre-populate form:
		theModel.addAttribute("customer",theCustomer);
		
		//send to form:
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId){
		//delete customer from database:
		customerService.deleteCustomer(customerId);
		//send to form:
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customer";        
    }
	@GetMapping("/sort")
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
		// get customers from the service
		List<Customer> theCustomers = null;
		
		// check for sort field
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);			
		}
		else {
			// no sort field provided ... default to sorting by last name
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
	
}

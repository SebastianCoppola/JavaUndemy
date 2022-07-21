package com.spring.dao;

import java.util.List;
import com.spring.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String theSearchName);

	public List<Customer> getCustomers(int theSortField);
	
}

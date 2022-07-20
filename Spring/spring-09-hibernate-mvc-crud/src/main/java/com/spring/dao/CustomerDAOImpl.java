package com.spring.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject  session factory:
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
	
		//get current hibernate session:
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query:
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
				
		//execute query and get result list:
		List<Customer> customers = theQuery.getResultList();
		
		//return the results:
		return customers;
	}	
}

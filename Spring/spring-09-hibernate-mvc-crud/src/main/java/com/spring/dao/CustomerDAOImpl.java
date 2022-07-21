package com.spring.dao;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.entity.Customer;
import com.spring.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject  session factory:
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get current hibernate session:
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query:
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
				
		//execute query and get result list:
		List<Customer> customers = theQuery.getResultList();
		
		//return the results:
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get current hibernate session:
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save customer or update customer:
			//session.save(customer);
			//session.update(customer);
			//session.saveOrUpdate(customer); --> Si no existe el Id lo guarda!
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		//get current hibernate session:
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get customer from db:
		Customer tempCustomer = currentSession.get(Customer.class,customerId);
		
		return tempCustomer;
	}

	@Override
	public void  deleteCustomer(int customerId) {
		//get current hibernate session:
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get customer from db with primaryKey:
		Customer theCustomer = currentSession.get(Customer.class,customerId);
		
		//delete customer:
		currentSession.delete(theCustomer);
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;
        
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0){
            theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName","%" + theSearchName.toLowerCase() + "%");
        }
        else {
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        // return the results        
        return customers;
	}

	@Override
	public List<Customer> getCustomers(int theSortField) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		// determine sort field
		String theFieldName = null;
				
		switch (theSortField) {
			case SortUtils.FIRST_NAME: 
				theFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				theFieldName = "lastName";
			}
				
		String queryString = "from Customer order by " + theFieldName;
		Query<Customer> theQuery = currentSession.createQuery(queryString, Customer.class);
				
		List<Customer> customers = theQuery.getResultList();
						
		return customers;
	}	
	
	
}

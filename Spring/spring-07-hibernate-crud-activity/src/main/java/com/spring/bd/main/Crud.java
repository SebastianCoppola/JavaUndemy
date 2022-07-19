package com.spring.bd.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.bd.entity.Employee;

public class Crud {
	
	public static void main(String[] args) {

		//CREATE EMPLOYEE:
		//syntax: createEmployee("firstName","lastName","company");
			//createEmployee("Vilma","Palma","MercadoLibre");
			//createEmployee("Lio","Messi","Ayi");
		
		
		//SEARCH EMPLOYEE BY ID:
		//syntax: searchEmployee(employeeId);
			//searchEmployee(2);
		
		
		//SEARCH COMPANY'S EMPLOYEES:
		//syntax: searchCompanyEmployees("company");
			//searchCompanyEmployees("MercadoLibre");
		
		
		//DELETE EMPLOYEE BY ID:
		//syntax: deleteEmployee(employeeId);
			//deleteEmployee(4);

	}

	private static void createEmployee(String firstName, String lastName, String company) {
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		//create employee:
		try{
			Employee tempEmployee = new Employee(firstName,lastName,company);
			session.beginTransaction();
			session.save(tempEmployee);
			session.getTransaction().commit();
			System.out.println("Employee saved.");
		}finally{
			factory.close();
		}
	}
	private static void searchEmployee(int employeeId) {
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		//search employee:
		try{
			session.beginTransaction();
			Employee myEmployee = session.get(Employee.class,employeeId);
			System.out.println(myEmployee);
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
	private static void searchCompanyEmployees(String company) {
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		//search employee:
		try{
			session.beginTransaction();
			List<Employee> theEmployee = session.createQuery("from Employee s where s.company='"+company+"'").list();
			System.out.println("Employees who work for '" + company + "':");
			for(Employee tempEmployees : theEmployee) {
				System.out.println(tempEmployees);
			}
			session.getTransaction().commit();
		}finally{
			factory.close();
		}
	}
	private static void deleteEmployee(int employeeId) {
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		//search employee:
		try{
			session.beginTransaction();
			Employee myEmployee = session.get(Employee.class, employeeId);
			session.delete(myEmployee);
			session.getTransaction().commit();
			System.out.println("Employee deleted.");
		}finally{
			factory.close();
		}
	}
}

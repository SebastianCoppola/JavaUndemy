package com.spring.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.jdbc.entity.Student;

public class CreateStudentDefault {

	public static void main(String[] args) {
		
		//create session factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		//create a new student
		try {
			//create a Student object
			System.out.println("Creating a new StudentObject.");
			Student tempStudent = new Student("Pedro","Picapiedra","pedro@picapiedra.com");
			
			//start a transaction:
			session.beginTransaction();
			
			//save the student object:
			System.out.println("Saving the Student.");
			session.save(tempStudent);
			
			//commit transaction:
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally{
			factory.close();
		}
	}
}

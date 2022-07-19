package com.spring.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.jdbc.entity.Student;

public class ReadStudentId {

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
			Student tempStudent = new Student("Alfredo","Casero","alfredo@casero.com");
			
			//start a transaction:
			session.beginTransaction();
			
			//save the student object:
			System.out.println("Saving the Student.");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction:
			session.getTransaction().commit();
			
			//READING STUDENT:
				//find student id(primarykey):
				System.out.println("Student saved. Generated id: " + tempStudent.getId());
				//get a new session and start transaction:
				session = factory.getCurrentSession();
				session.beginTransaction();
				//retrieve student based on the id:
				System.out.println("Getting student with the id: " + tempStudent.getId());
				Student myStudent = session.get(Student.class, tempStudent.getId());
				System.out.println("Get complete: " + myStudent);
				//commit transaction
				session.getTransaction().commit();
				System.out.println("Done!");
		}finally{
			factory.close();
		}
	}
}

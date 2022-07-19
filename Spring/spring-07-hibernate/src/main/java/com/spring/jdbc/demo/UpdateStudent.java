package com.spring.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.jdbc.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		
		//create session factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		try {
			
			//UPDATE 1 STUDENT: 
				int studentId = 1;
				//get new session and start a transaction:
				session = factory.getCurrentSession();
				session.beginTransaction();
				//retrieve student based on the id:
				System.out.println("\nGetting student with id: " + studentId);
				Student myStudent = session.get(Student.class, studentId);
				System.out.println("Updating student...");
				myStudent.setFirstName("Ricadinho");
				//commit transaction:
				session.getTransaction().commit();
			
			//UPDATE MANY STUDENT: 
				//new transaction:
				session = factory.getCurrentSession();
				session.beginTransaction();
				//update email for all students: 
				session.createQuery("update Student set email='test@test.com'").executeUpdate();
				session.getTransaction().commit();

			System.out.println("Done!");
			
		}finally{
			
			factory.close();
		}
	}
}

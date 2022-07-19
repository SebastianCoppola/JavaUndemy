package com.spring.jdbc.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;


public class ReadStudentQuery {

	public static void main(String[] args) {
		
		//create session factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction:
			session.beginTransaction();
			
			//query students:
				//all students:
				List<Student> theStudents = session.createQuery("from Student").list();
				System.out.println("\nAll Students:");
				displayStudents(theStudents);
				
				//lastName = '':
				theStudents = session.createQuery("from Student s where s.lastName='Luis'").list();
				System.out.println("Students which last name is 'Luis':");
				displayStudents(theStudents);
				
				//lastName = '' OR firstName = '':
				theStudents = session.createQuery("from Student s where s.lastName='Luis' OR s.firstName='Vilma'").list();
				System.out.println("Students which last name is 'Luis' OR first name is 'Vilma':");
				displayStudents(theStudents);
				
				//email like "@palma.com":
				theStudents = session.createQuery("from Student s where s.email LIKE '%@palma.com'").list();
				System.out.println("Students whos mail ends with '@palma.com'");
				displayStudents(theStudents);
				
			//commit transaction:
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}

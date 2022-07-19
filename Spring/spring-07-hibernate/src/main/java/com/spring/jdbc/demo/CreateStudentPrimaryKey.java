package com.spring.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.jdbc.entity.Student;

public class CreateStudentPrimaryKey {

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
			System.out.println("Creating 3 new StudentObject.");
			Student tempStudent1 = new Student("Miguel","Mateo","miguel@mateo.com");
			Student tempStudent2 = new Student("Mario","Luis","mario@luis.com");
			Student tempStudent3 = new Student("Vilma","Palma","vilma@palma.com");
					
			//start a transaction:
			session.beginTransaction();
					
			//save the student object:
			System.out.println("Saving the Student.");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
					
			//commit transaction:
			session.getTransaction().commit();
			System.out.println("Done!");
					
		}finally{
			factory.close();
		}
	}
}

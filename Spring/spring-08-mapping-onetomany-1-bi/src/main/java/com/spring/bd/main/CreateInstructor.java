package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;

public class CreateInstructor {
	
	public static void main(String[] args) {
		
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
				
		//create new instructor and save it:
		try{
			Instructor tempInstructor = 
					new Instructor("Lilita","Carrió","lilita@gmail.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("@lilita","Misa");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			//will save Instructor and Detail 'cause the cascade.ALL
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Instructor saved: " + tempInstructor);
		}finally{
			session.close();
			factory.close();
		}
	}
}
package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;

public class CreateCourse {
	
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
			session.beginTransaction();
			int instructorId= 1;
			Instructor tempInstructor = session.get(Instructor.class,instructorId);
			
			Course tempCourse1 = new Course("Guitarra Eléctrica");
			Course tempCourse2 = new Course("Macramé");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			session.getTransaction().commit();
			System.out.println("Courses saved.");
		}finally{
			session.close();
			factory.close();
		}
	}
}
package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class CreateCourse {
	
	public static void main(String[] args) {
		
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
				
		//create new instructor and save it:
		try{
			session.beginTransaction();
			int instructorId1= 3;
			Instructor tempInstructor1 = session.get(Instructor.class,instructorId1);
			
			Course tempCourse1 = new Course("Cursoito2");
			Course tempCourse2 = new Course("Cursoito3");
			
			tempInstructor1.add(tempCourse1);
			tempInstructor1.add(tempCourse2);
			
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
package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class ReadInstructorInfo {
	
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
			int instructorId= 2;
			Instructor tempInstructor = session.get(Instructor.class,instructorId);
			System.out.println("Intructor: " + tempInstructor);
			System.out.println("Detail: " + tempInstructor.getInstructorDetail());
			System.out.println("Courses: " + tempInstructor.getCourses());
			session.getTransaction().commit();
		}finally{
			session.close();
			factory.close();
		}
	}
}
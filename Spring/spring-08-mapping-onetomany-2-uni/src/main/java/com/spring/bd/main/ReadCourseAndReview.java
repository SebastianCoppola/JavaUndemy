package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;

public class ReadCourseAndReview {
	
	public static void main(String[] args) {
		
		//create factory:
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		//create a session:
		Session session = factory.getCurrentSession();
				
		//create new instructor and save it:
		try{
			session.beginTransaction();
			
			int courseId = 10;
			
			Course tempCourse = session.get(Course.class,courseId);
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.getTransaction().commit();
		
		}finally{
			session.close();
			factory.close();
		}
	}
}
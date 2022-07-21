package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class CreateReview {
	
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
				
		try{
			session.beginTransaction();
			
			int courseId1 = 10; 
			int courseId2 = 11; 
			
			Course tempCourse1 = session.get(Course.class,courseId1);
			Course tempCourse2 = session.get(Course.class,courseId2);
			
			Review tempReview1 = new Review("Review1");
			Review tempReview2 = new Review("Review2");
			Review tempReview3 = new Review("Review3");
			Review tempReview4 = new Review("Review4");
			
			tempCourse1.addReview(tempReview1);
			tempCourse1.addReview(tempReview2);
			tempCourse2.addReview(tempReview3);
			tempCourse2.addReview(tempReview4);
			
			session.save(tempReview1);
			session.save(tempReview2);
			session.save(tempReview3);
			session.save(tempReview4);
			
			session.getTransaction().commit();
			
			System.out.println("Reviews saved.");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
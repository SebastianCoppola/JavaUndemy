package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;

public class CreateCourseAndReview {
	
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
			
			Course tempCourse = new Course("Macramé");
			Review tempReview1 = new Review("Boring");
			Review tempReview2 = new Review("Lazy");
			tempCourse.addReview(tempReview1);
			tempCourse.addReview(tempReview2);
			
			//va a guardar el curso y las reviews x cascada:
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Courses saved.");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
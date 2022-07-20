package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class CreateCourseAndStudent {
	
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
			
			//create & save the course:
			Course tempCourse1 = new Course("Tiro");
			Course tempCourse2 = new Course("Malambo");
			//Review tempReview1 = new Review("Boring");
			//Review tempReview2 = new Review("Lazy");
			//tempCourse.addReview(tempReview1);
			//tempCourse.addReview(tempReview2);
			session.save(tempCourse1);
			session.save(tempCourse2);
						
			//create & add & save the students:
			Student tempStudent1 = new Student("Mario","Luis","mario@gmail.com");
			tempCourse1.addStudent(tempStudent1);
			tempCourse2.addStudent(tempStudent1);
			session.save(tempStudent1);
			
			//commit transaction:
			session.getTransaction().commit();
			
			System.out.println("Courses saved.");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
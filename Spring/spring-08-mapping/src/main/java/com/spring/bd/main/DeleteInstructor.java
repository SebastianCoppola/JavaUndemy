package com.spring.bd.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class DeleteInstructor {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Review.class)
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();

		Session session = factory.getCurrentSession();
				
		try{
			session.beginTransaction();
			
			int instructorId = 3;
			
			Instructor tempInstructor = session.get(Instructor.class,instructorId);
			
			List<Course> tempCourses = tempInstructor.getCourses();
			for(int i=0; i<tempCourses.size(); i++) {
				tempCourses.get(i).setInstructor(null);
			}
			
			session.delete(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Instructor deleted.");
		
		}finally{
			factory.close();
		}
	}
}

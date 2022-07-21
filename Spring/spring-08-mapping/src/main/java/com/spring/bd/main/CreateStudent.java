package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.bd.entity.Course;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;
import com.spring.bd.entity.Review;
import com.spring.bd.entity.Student;

public class CreateStudent {
	
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
			Course tempCourse1 = session.get(Course.class, courseId1);
			Course tempCourse2 = session.get(Course.class, courseId2);
		
			Student tempStudent = new Student("Student2","Student2","student2@test.com");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Student saved.");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
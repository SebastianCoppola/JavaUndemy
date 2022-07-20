package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;

public class DeleteInstructorDetail {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();

		Session session = factory.getCurrentSession();
				
		try{
			session.beginTransaction();
			int instructorDetailId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,instructorDetailId);
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
	}
}

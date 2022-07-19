package com.spring.bd.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.spring.bd.entity.Instructor;
import com.spring.bd.entity.InstructorDetail;

public class DeleteDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();

		Session session = factory.getCurrentSession();
				
		try{
			session.beginTransaction();
			
			int instructorId = 1;
			Instructor tempInstructor = session.get(Instructor.class,instructorId);
			if(tempInstructor != null) {
				//Esto va a eliminar los detalles también porque cascade.ALL.
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();
			System.out.println("Instructor deleted: " + tempInstructor);
		}finally{
			factory.close();
		}
	}
}

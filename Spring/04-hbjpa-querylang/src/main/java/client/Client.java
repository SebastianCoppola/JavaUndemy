package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Guide;
import entity.Student;

public class Client{
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("querylang");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
	
			//Create Guide:
			Guide guide1 = new Guide("ABS45","Pedro Pablo",3000);
			Guide guide2 = new Guide("ABS48","Maria Laura",4000);
			em.persist(guide1);
			em.persist(guide2);
			System.out.println("Guide created: " + guide1);
			System.out.println("Guide created: " + guide2);
			
			//Create Students sin Guide:
			Student student1 = new Student("2014BE50558", "Mario Luis");
			em.persist(student1);
			System.out.println("Student created: " + student1);
			Student student2 = new Student("2014BE50558", "Mario Luis");
			em.persist(student2);
			System.out.println("Student created: " + student2);

			//Create Student con Guide:
			Student student3 = new Student("2014BE50558", "Alfio Basile",guide2);
			Student student4 = new Student("2014BE50558", "Emilia Lopez",guide2);
			guide2.addStudent(student3);
			guide2.addStudent(student4);
			em.persist(student3);
			em.persist(student4);
			System.out.println("Student created: " + student3);
			System.out.println("Student created: " + student4);
			
		
			
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}















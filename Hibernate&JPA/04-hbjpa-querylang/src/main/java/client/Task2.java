package client;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

public class Task2 {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("querylang");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		//Retrieve Guides without Students:
		try {
			
			Query query = em.createQuery("select g.name, g.staffId from Guide g where size(g.students) is 0"); //2
			List<Object[]> guides = query.getResultList();
			for (Object[] guide : guides) {
				System.out.println("Student [name: " + guide[0] + ", staffId: " + guide[1] + "]");				
			}

			em.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			em.close();
		}	
	}
}



































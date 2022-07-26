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

public class Task3 {
	public static void main(String[] args) {		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("querylang");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		//Retrieve Guides with Students whose name starts with "A":
		try {
		
			Query query = em.createQuery(" select g from Guide g join g.students s where s.name like 'A%' ");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
			System.out.println(guide);				
			}

			em.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			em.close();
		}	
	}
}



































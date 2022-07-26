
package client;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Task1 {
	public static void main(String[] args) {		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("querylang");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		//Retrieve Students without Guide:
		try{
			Query query = em.createQuery("select s.name, s.enrollmentId from Student s where s.guide is null");
			List<Object[]> students = query.getResultList();
			for (Object[] student : students) {
				System.out.println("Student [name: " + student[0] + ", enrollmentId: " + student[1] + "]");				
			}

			em.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			em.close();
		}	
	}
}



































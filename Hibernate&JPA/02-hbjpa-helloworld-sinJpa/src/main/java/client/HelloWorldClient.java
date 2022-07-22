package client;

import org.hibernate.Session;
import util.HibernateUtil;
import domain.Message;

public class HelloWorldClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
        
    	Message message = new Message( "Holiiiis" );
        
    	session.save(message);    
        
    	session.getTransaction().commit();
    	session.close();
	
	}
}


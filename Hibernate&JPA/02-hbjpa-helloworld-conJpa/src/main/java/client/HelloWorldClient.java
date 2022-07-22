package client;

import org.hibernate.Session;
import util.HibernateUtil;
import entity.Message;

public class HelloWorldClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
        
    	//CREATE:
//    	Message message = new Message( "KEONDA" );
//      session.save(message);    
        
    	//READ:
//    	long messageId = 8;
//    	Message theMessage = session.get(Message.class, messageId);
//    	System.out.println(theMessage);

    	//UPDATE
//    	long messageId = 3;
//    	Message theMessage = session.get(Message.class, messageId);
//    	theMessage.setText("Hola locuras");
//    	System.out.println(theMessage);
   	
    	//DELETE
    	long messageId = 4;
    	Message theMessage = session.get(Message.class, messageId);
    	session.delete(theMessage);
    	
    	session.getTransaction().commit();
    	session.close();
	
	}
}


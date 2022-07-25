package client;

import org.hibernate.Session;
import entity.Book;
import entity.Chapter;
import entity.ChapterId;
import entity.Publisher;
import util.HibernateUtil;

public class BookStoreClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		//persisting object graph of Book
//		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");
//		Book book = new Book("9781615890459", "Java Hibernate", publisher);
//
//		ChapterId chapter1Id = new ChapterId(book.getIsbn(),1);
//		Chapter chapter1 = new Chapter(chapter1Id,"Basics");
//		book.addChapter(chapter1);
//		
//		ChapterId chapter2Id = new ChapterId(null,2);
//		Chapter chapter2 = new Chapter(chapter2Id,"Fundamentals");
//		book.addChapter(chapter2);
//		
//		session.persist(book);
		
		//retrieving Book from DB:
		Book theBook = (Book) session.get(Book.class, "9781615890459");
		System.out.println("Book: " + theBook);		
		System.out.println("Publisher: " + theBook.getPublisher());		
		System.out.println("Chapters: " + theBook.getChapters());		
		
		
		session.getTransaction().commit();
		session.close();
		
	}
}






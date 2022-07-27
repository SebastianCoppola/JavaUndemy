package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="BOOK_NAME")
	private String name;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="PUBLISHER_CODE")
	private Publisher publisher;
	
	@OneToMany(mappedBy="book", cascade= {CascadeType.PERSIST})
	private Set<Chapter> chapters = new HashSet<Chapter>();
	
	//Constructors:
	public Book() {}
	public Book(String isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}
	
	//Add & Remove Chapter:
	public void addChapter(Chapter chapter) {
		this.chapters.add(chapter);
		chapter.setBook(this);
	}
	public void removeChapter(Chapter chapter) {
		this.chapters.remove(chapter);
		chapter.setBook(null);
	}
	
	//Getters & Setters:
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Chapter> getChapters() {
		return chapters;
	}
	//toString:
	@Override
	public String toString() {
		return "[isbn: " + isbn + ", name:" + name + "]";
	}
}













































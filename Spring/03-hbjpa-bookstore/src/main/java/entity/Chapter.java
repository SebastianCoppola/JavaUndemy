package entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Chapter {
	
	@EmbeddedId
	private ChapterId chapterId;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ISBN")
	@MapsId("isbn")
	private Book book;
	
	@Column(name="TITLE", nullable = false, length = 100)
	private String title;
	
	
	//Constructors:
	public Chapter() {}	
	public Chapter(ChapterId chapterId, String title) {
		this.title = title;
		this.chapterId = chapterId;
	}

	//Getters & Setters
	public void setBook(Book book) {
		this.book = book;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "title: " + chapterId ; 
	}	
}















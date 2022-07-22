package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;

	@Column(name="TEXT")	
	private String text;
	
	//CONSTRUCTOR:
	public Message() {}
	public Message(String text) {
		this.text = text;
	}
	//GETTERS & SETTERS:	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	//TOSTRING:
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}	
	
}













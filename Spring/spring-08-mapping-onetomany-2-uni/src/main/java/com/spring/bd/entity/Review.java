package com.spring.bd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="comment")
	private String comment;

	//constructors:
	public Review(){};
	public Review(String comment) {
		this.comment = comment;
	}
	
	//getters & setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	//toString:
	@Override
	public String toString() {return "Review id: " + id + ", comment: " + comment  + ".";}
	
	
	
	
	
	
	
	
}

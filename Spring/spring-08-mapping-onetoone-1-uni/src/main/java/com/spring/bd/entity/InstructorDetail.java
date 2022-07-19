package com.spring.bd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	//fields:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="youtube_channel")
	private String youTubeChannel;
	@Column(name="hobby")
	private String hobby;
	
	//constructors:
	public InstructorDetail(){};
	public InstructorDetail(String youTubeChannel, String hobby) {
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}
	
	
	//getters & setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYouTubeChannel() {
		return this.youTubeChannel;
	}
	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}
	public String getHobby() {
		return this.hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	//toString
	@Override
	public String toString() {
		return "IntructorDetail (id: " + id + ", youTubeChannel: " + youTubeChannel + ", hobby:" + hobby + ")";
	}
	
}

package com.spring.bd.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	//fields:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName; 
	@Column(name="last_name")
	private String lastName; 
	@Column(name="email")
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	@OneToMany(fetch=FetchType.LAZY, 
				mappedBy="instructor",
				cascade={CascadeType.PERSIST,CascadeType.MERGE,
				CascadeType.DETACH,CascadeType.REFRESH})
	private List<Course> courses;

	//constructors:
	public Instructor() {};
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	//getters & setters:
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public InstructorDetail getInstructorDetail() {
		return this.instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	public List<Course> getCourses() {
		return this.courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	//method for bi directional relationships:
	public void add(Course tempCourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
	
	
	//toString:
	@Override
	public String toString() {
		return "Instructor (id:" + id + ", firstName: " + firstName + ", lastName: " + lastName + ", email: " + email
				+ ", instructorDetail: " + instructorDetail + ")";
	}
		
}

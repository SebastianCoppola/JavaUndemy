package com.mavenmvc.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import com.mavenmvc.validation.CourseCode;

public class Customer {

	//attributes:
	private String firstName;
	
	@NotNull(message="can't be empty")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greather than or equals to zero")
	@Max(value=10, message="must be less than or equals to ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{4}", message="only 4 digits")
	private String postalCode;
	
	@CourseCode(value="TOPS",message="must start with TOPS")
	private String courseCode;
	
	//getters & setters:
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
	public Integer getFreePasses() {
		return this.freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return this.courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}

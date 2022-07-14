package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	//Attributes:
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage; 
	private String operatingSystems; 
	
	//languages
	private LinkedHashMap<String, String> favoriteLanguageOptions;

	//Constructors:
	public Student(){
		// populate favorite language options
        favoriteLanguageOptions = new LinkedHashMap<>();
        // parameter order: value, display label
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("PHP", "PHP");
        favoriteLanguageOptions.put("Ruby", "Ruby");    
	};

	//Getters & Setters:
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

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return this.favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return this.favoriteLanguageOptions;
    }

	public String getOperatingSystems() {
		return this.operatingSystems;
	}

	public void setOperatingSystems(String operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
}

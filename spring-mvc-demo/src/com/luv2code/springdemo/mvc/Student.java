package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	
	// data for programming-languages
	private LinkedHashMap<String, String> programmingLanguages;
	
	/* 
	 * dictionary for countries (e.g. external from database, ...)
	 * Realized by external data-file in the end!
	 * 
	 */
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		
		programmingLanguages = new LinkedHashMap<String, String>();
		programmingLanguages.put("Java", "Java");
		programmingLanguages.put("Cpp", "C++");
		programmingLanguages.put("JS", "JavaScript");
		programmingLanguages.put("Python", "Python");
		programmingLanguages.put("Ruby", "Ruby");
		
		// populate country key-value dictionary (e.g. from database)
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("AT", "Austria");
		
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public LinkedHashMap<String, String> getProgrammingLanguages() {
		return programmingLanguages;
	}


	public void setProgrammingLanguages(LinkedHashMap<String, String> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}
	
}

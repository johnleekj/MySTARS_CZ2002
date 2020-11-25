package com.mySTARS.Entities;

import java.io.Serializable;

public class PersonInformation implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1576088124912146149L;
	private String name;
	private String gender;
	private String nationality;

	public PersonInformation(String name, String gender, String nationality) {
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}







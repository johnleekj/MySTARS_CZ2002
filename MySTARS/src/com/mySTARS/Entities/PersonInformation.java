package com.mySTARS.Entities;

import java.io.Serializable;

/**
 * PersonInformation holds information about a person
 * Use to define as a parent class for the child classes.
 * See child: StaffInformation, StudentInformation
 * 
 */
public class PersonInformation implements Serializable  {
	
	private static final long serialVersionUID = 1576088124912146149L;
	private String name;
	private String gender;
	private String nationality;

	
	/**
	 * 
	 * Constructor for making a generic person
	 * 
	 * @param name Name of person
	 * @param gender Gender of person 
	 * @param nationality Nationality of person
	 */
	public PersonInformation(String name, String gender, String nationality) {
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
	}

	
	/**
	 * Get the person's name.
	 * 
	 * @return return name of person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change the name for the current person.
	 * 
	 * @param name The updated name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the person's gender.
	 * 
	 * @return return name of gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Change the gender for the current person.
	 * 
	 * @param gender The updated gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the person's nationality.
	 * 
	 * @return return name of nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Change the current nationality for the current person.
	 * 
	 * @param nationality The updated nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}







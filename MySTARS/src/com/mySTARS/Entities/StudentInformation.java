package com.mySTARS.Entities;

/**
 * Holds information about a student. 
 * Inherits PersonalInformation
 * 
 */
public class StudentInformation extends PersonInformation {

	private String matricNo;
	
	/**
	 * Constructor for making a student information.
	 *  
	 * Takes in the basic information of a student and makes a student.
	 * 
	 * @param name Name of student
	 * @param gender Gender of student 
	 * @param nationality Nationality of student
	 * @param matricNo Matriculation number of student
	 *
	 */
	public StudentInformation(String name, String gender, String nationality, String matricNo) {
		super(name, gender, nationality);
		this.matricNo = matricNo;
	}
	
	
	/**
	 * Get the person's matriculation number
	 * 
	 * @return return matriculation number of student
	 */
	public String getMatricNo() {
		return matricNo;
	}

	/**
	 * Change the matriculation number for the current student.
	 * 
	 * @param gender The updated matriculation number
	 */
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	
	/**
	 * 
	 * Class static method: Makes and return student information containing information of student.
	 * 
	 * @param name Name of student
	 * @param gender Gender of student 
	 * @param nationality Nationality of student
	 * @param matricNo Matriculation number of student
	 * @return
	 */
	public static StudentInformation makeStudentInformation	(
			String name,
			String gender,
			String nationality,
			String matricNo) {
		return new StudentInformation(name, gender, nationality, matricNo);
	}

}
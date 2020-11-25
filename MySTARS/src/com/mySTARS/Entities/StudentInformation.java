package com.mySTARS.Entities;

public class StudentInformation extends PersonInformation {

	private String matricNo;

	public StudentInformation(String name, String gender, String nationality, String matricNo) {
		super(name, gender, nationality);
		this.matricNo = matricNo;
	}

	public String getMatricNo() {
		return matricNo;
	}

	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	
	public static StudentInformation makeStudentInformation	(
			String name,
			String gender,
			String nationality,
			String matricNo) {
		return new StudentInformation(name, gender, nationality, matricNo);
	}

}
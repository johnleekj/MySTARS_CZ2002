package com.mySTARS.Entities;

import java.io.Serializable;

public class StudentCourseHistory implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -291571114891644217L;
	String courseCode;
	String courseName;
	char grade;
	
	public StudentCourseHistory(String courseCode, String courseName, char grade) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}

	
	
	
	
	
	
}

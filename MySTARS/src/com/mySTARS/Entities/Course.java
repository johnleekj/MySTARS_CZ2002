package com.mySTARS.Entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.mySTARS.ENUMS.SCHOOL;

public class Course implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4312433106299807902L;
	private String courseCode;
	private String courseName;
	private int courseUnits;
	private SCHOOL schoolName;
	private ArrayList<IndexDetail> indexesInfo;
	
	public Course(String courseCode, String courseName, int courseUnits, SCHOOL schoolName, ArrayList<IndexDetail> indexesInfo) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseUnits = courseUnits;
		this.indexesInfo = indexesInfo;
		this.schoolName = schoolName;
	}
	
	@Override
	public String toString() {
		return 	"Course Code: " + this.courseCode + "\n" + 
				"Course Name: " + this.courseName + "\n" +
				"Course Units: " + this.courseUnits + "AU \n" +
				"School: " + this.schoolName.toString() + "\n" +
				"Course Indexes: " + this.indexesInfo.toString();
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void updateCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void updateCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseUnits() {
		return this.courseUnits;
	}

	public void updateCourseUnits(int courseUnits) {
		if (courseUnits < 0) {
			this.courseUnits = 3;
		} else {
			this.courseUnits = courseUnits;
		}
	}
	
	public SCHOOL SchoolName() {
		return schoolName;
	}

	public SCHOOL getSchoolName() {
		return this.schoolName;
	}
	
	public void setSchoolName(SCHOOL schoolName) {
		this.schoolName = schoolName;
	}
	
	public ArrayList<IndexDetail> getIndexDetail() {
		return this.indexesInfo;
	}
		
	public ArrayList<Lesson> getLesson(int index) {
		ArrayList<Lesson> returningList = null;
		for (IndexDetail detail : indexesInfo) {
			if (detail.getIndex() == index) {
				returningList = detail.getLessonList();
				return returningList;
			}
		}
		return null;
	}
	
	public void addLesson(int index, Lesson lesson) {
		for (IndexDetail detail : indexesInfo) {
			if (detail.getIndex() == index) {
				detail.addLesson(lesson);
				break;
			}
		}
	}

	public void addNewIndexDetail(int index, int capacity) {
		// Add a placeholder for index. Lesson and WaitList can be added later
		IndexDetail newDetail = new IndexDetail(index, capacity, new ArrayList<Lesson>(), new ArrayList<String>());
		indexesInfo.add(newDetail);
	}
	
	public void dropIndex(int index) {
		for (int i = 0; i < indexesInfo.size(); i++) {
			if (indexesInfo.get(i).getIndex() == index) {
				indexesInfo.remove(i);
			}
		}
	}

	public static Course makeEmptyCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName
			) {
		// Just make empty course without index detail
		return new Course(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
	}

	public static Course makeCourse(
			String courseCode, 
			String courseName, 
			int courseUnits, 
			SCHOOL schoolName,
			ArrayList<IndexDetail> indexesDetails) {
		// TODO Auto-generated method stub
		
		// Just make empty course without index detail
		return new Course(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
	}

	public void setCourseName(String updatedCourseCode) {
		this.courseCode = updatedCourseCode;
	}

}



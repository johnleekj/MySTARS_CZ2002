package com.mySTARS.Entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.mySTARS.ENUMS.SCHOOL;
/**
 * Course class holds the methods that handle implementation of code related to the courses
 * 
 *
 */
public class Course implements Serializable   {

	private static final long serialVersionUID = 4312433106299807902L;
	private String courseCode;
	private String courseName;
	private int courseUnits;
	private SCHOOL schoolName;
	private ArrayList<IndexDetail> indexesInfo;
	
	/** 
	 * Constructor for making a course. Takes in the basic details of a course and returns a valid Course object
	 * 
	 * @param courseCode courseCode that is uniquely tied to a particular course 
	 * @param courseName Name of a course
	 * @param courseUnits Number of academic units of a course
	 * @param schoolName Name of the school that the course is under
	 * @param indexesInfo Array list holding all the information related to the indexes
	 */
	public Course(String courseCode, String courseName, int courseUnits, SCHOOL schoolName, ArrayList<IndexDetail> indexesInfo) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseUnits = courseUnits;
		this.indexesInfo = indexesInfo;
		this.schoolName = schoolName;
	}
	
	/** 
	 * Returns the user input in String format
	 */
	@Override
	public String toString() {
		return 	"Course Code: " + this.courseCode + "\n" + 
				"Course Name: " + this.courseName + "\n" +
				"Course Units: " + this.courseUnits + "AU \n" +
				"School: " + this.schoolName.toString() + "\n" +
				"Course Indexes: " + this.indexesInfo.toString();
	}

	/**
	 * Method to get the courseCode of a course
	 * 
	 * @return Returns courseCode that is read
	 */
	public String getCourseCode() {
		return this.courseCode;
	}
	
	/**
	 * Method to update the courseCode of a course
	 * 
	 * @param courseCode Course code of course
	 */
	public void updateCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Method to get course name
	 * 
	 * @return Returns courseName that is read
	 */
	public String getCourseName() {
		return this.courseName;
	}

	/**
	 * Method to update the courseName of a course
	 * 
	 * @param courseName Name of the course
	 */
	public void updateCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Method to get academic units of a course
	 * 
	 * @return Returns academic units of course
	 */
	public int getCourseUnits() {
		return this.courseUnits;
	}

	/**
	 * Method to update the number of academic units of a course
	 * 
	 * @param courseUnits Number of academic units that a course holds
	 */
	public void updateCourseUnits(int courseUnits) {
		if (courseUnits < 0) {
			this.courseUnits = 3;
		} else {
			this.courseUnits = courseUnits;
		}
	}
	
	/**
	 * Method to return the school name that course is tagged to
	 * 
	 * @return Returns name of school
	 */
	public SCHOOL SchoolName() {
		return schoolName;
	}

	/**
	 * Method to get the school name
	 * 
	 * @return Returns name of school
	 */
	public SCHOOL getSchoolName() {
		return this.schoolName;
	}
	
	/**
	 * Method to set the school name of a new course created
	 * 
	 * @param schoolName Name of school that course is under
	 */
	public void setSchoolName(SCHOOL schoolName) {
		this.schoolName = schoolName;
	}
	
	/**
	 * Arraylist that holds index information, retrieved from IndexDetail class
	 * 
	 * @return Returns index information
	 */
	public ArrayList<IndexDetail> getIndexDetail() {
		return this.indexesInfo;
	}
	
	/**
	 * Arraylist that holds lesson information, retrieved from Lesson class
	 * 
	 * @param index Refers to a specific index number
	 * @return Returns list of lessons under that particular index number
	 */
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
	
	/**
	 * Method to add a new lesson
	 * 
	 * @param index Refers to a specific index number
	 * @param lesson Holds a new lesson
	 */
	public void addLesson(int index, Lesson lesson) {
		for (IndexDetail detail : indexesInfo) {
			if (detail.getIndex() == index) {
				detail.addLesson(lesson);
				break;
			}
		}
	}

	/**
	 * Method to add a new index to a course
	 * 
	 * @param index Refers to a specific index number
	 * @param capacity Refers to the capacity of that index number, meaning the number of students that that index number can hold
	 */
	public void addNewIndexDetail(int index, int capacity) {
		// Add a placeholder for index. Lesson and WaitList can be added later
		IndexDetail newDetail = new IndexDetail(index, capacity, new ArrayList<Lesson>(), new ArrayList<String>());
		indexesInfo.add(newDetail);
	}
	
	/**
	 * Method to drop index number of course
	 * 
	 * @param index Refers to a specific index number
	 */
	public void dropIndex(int index) {
		for (int i = 0; i < indexesInfo.size(); i++) {
			if (indexesInfo.get(i).getIndex() == index) {
				indexesInfo.remove(i);
			}
		}
	}

	/**
	 * Method to create an empty course to input details of new course that admin wishes to create
	 * 
	 * @param courseCode Course code that is tagged to each course
	 * @param courseName Name of course
	 * @param courseUnits Number of academic units that course has
	 * @param schoolName Name of school that course is under
	 * @return Returns the empty course
	 */
	public static Course makeEmptyCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName
			) {
		// Just make empty course without index detail
		return new Course(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
	}

	/**
	 * Method to make that course, using empty course created above
	 * 
	 * @param courseCode Course code that is tagged to each course
	 * @param courseName Name of course
	 * @param courseUnits Number of academic units that course has
	 * @param schoolName Name of school that course is under
	 * @param indexesDetails Details of indexes under a particular course
	 * @return Returns the new course that has been created
	 */
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

	/**
	 * Method to set a new courseCode for a particular course
	 * 
	 * @param updatedCourseCode To hold user input of the new courseCode
	 */
	public void setCourseName(String updatedCourseCode) {
		this.courseCode = updatedCourseCode;
	}

}



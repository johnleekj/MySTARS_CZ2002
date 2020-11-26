package com.mySTARS.Entities;

import java.util.ArrayList;

/**
 * Holds information of student account and also student information.
 * Inherits Account class.
 */


public class StudentAccount extends Account {
	
	// Stores Student Information in student account
	private StudentInformation studentInfo; 
	
	// Stores indexes of courses, that are bound to be uniquely identifable.
	private ArrayList<Integer> coursesRegisteredList;
	private ArrayList<Integer> courseOnWaitList;
	private ArrayList<Integer> courseHistoryList; // Assuming that each index stays unique, even if there is no slots.
	
	/**
	 * Constructor for making a student account.
	 * 
	 * Takes in basic information of student and its account details to make an account
	 * Also holds information on the courses that they students are registering for or those already taken.
	 * 
	 * @param loginID The username used to access an account that is registered under MySTARS
	 * @param hashedPassword The password that is tagged respectively under the respective account.
	 * @param email The email address that is tagged respectively under the respective account
	 * @param studentInfo contains the studentInfo object. 
	 * @param coursesRegistered A list of course registered
	 * @param courseOnWaitList A list of course on the waitList
	 * @param courseHistory A list of course previously taken.
	 */
	public StudentAccount(
			String loginID, 
			String password, 
			String email, 
			StudentInformation studentInfo,
			ArrayList<Integer> coursesRegistered, 
			ArrayList<Integer> courseOnWaitList, 
			ArrayList<Integer> courseHistory
			) {
		super(loginID, password, email);
		this.studentInfo = studentInfo;
		this.coursesRegisteredList = coursesRegistered;
		this.courseOnWaitList = courseOnWaitList;
		this.courseHistoryList = courseHistory;
	}
	
	/**
	 * Return all the course index from registered, wait list and course taken previously.
	 * 
	 * @return all related integer course indexes
	 */
	public ArrayList<Integer> getAllCourseIndex() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < courseHistoryList.size(); i++) {
			temp.add(courseHistoryList.get(i));
		}
		for (int i = 0; i < courseOnWaitList.size(); i++) {
			temp.add(courseOnWaitList.get(i));
		}
		for (int i = 0; i < coursesRegisteredList.size(); i++) {
			temp.add(coursesRegisteredList.get(i));
		}
		
		return temp;
	}
	
	/**
	 * Return all the course index from registered, wait list.
	 * Exclude course taken previously
	 * 
	 * @return all related integer course indexes
	 */
	public ArrayList<Integer> getCombinedWaitandRegisteredList() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < courseOnWaitList.size(); i++) {
			temp.add(courseOnWaitList.get(i));
		}
		for (int i = 0; i < coursesRegisteredList.size(); i++) {
			temp.add(coursesRegisteredList.get(i));
		}
		return temp;
	}

	/**
	 * Returns more details of student account.
	 * 
	 * @return returns student information of current student account.
	 */
	public StudentInformation getStudentInfo() {
		return studentInfo;
	}

	/**
	 * Sets the current account with an updated set of student information
	 * 
	 * @param studentInfo
	 */
	public void setStudentInfo(StudentInformation studentInfo) {
		this.studentInfo = studentInfo;
	}

	/**
	 * Returns the list of courses registered.
	 * 
	 * @return returns list of courses registered of current student account
	 *
	 */
	public ArrayList<Integer> getListCoursesRegistered() {
		return coursesRegisteredList;
	}
	
	/**
	 * Returns the list of registered courses for current student excluding the index specified 
	 * 
	 * @param index the index to be excluded.
	 * @return
	 */
	public ArrayList<Integer> filterListCoursesRegistered(int index) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for (int i =0; i < this.coursesRegisteredList.size(); i++) {
			int currentIndex = this.coursesRegisteredList.get(i);
			if (currentIndex != index) {
				resultList.add(currentIndex);
			}
		}
		return resultList;
	}
	
	/**
	 * Drop index from list of registered courses
	 * 
	 * @param droppingIndex Index that will be dropped.
	 * @return
	 */
	public int dropFromCoursesRegistered(int droppingIndex) {
		for (int i = 0 ; i < this.coursesRegisteredList.size() ; i++) {
			if (this.coursesRegisteredList.get(i) == droppingIndex) {
				this.coursesRegisteredList.remove(i);
				return droppingIndex;
			}
		}
		return -1; // Reach here means failed.
	}
	
	/**
	 * Get course index from list. Returns -1 if course index does not exist
	 * 
	 * @param index_in
	 * @return
	 */
	public int getCourseFromLists(int index_in) {
		for (int index : this.courseOnWaitList) {
			if (index == index_in) {
				return index_in;
			}
		}
		for (int index : this.coursesRegisteredList) {
			if (index == index_in) {
				return index_in;
			}
		}
		return -1; // Reach here means failed as cannot find index
	}

	/**
	 * Returns the list of courses previously taken.
	 * 
	 * @return returns list of courses courses previously taken for current student account.
	 *
	 */
	public ArrayList<Integer> getCourseHistoryList() {
		return courseHistoryList;
	}

	/**
	 * Sets the list of courses previously taken.
	 * 
	 * @params courseHistory courses previously taken.
	 *
	 */
	public void setCourseHistory(ArrayList<Integer> courseHistory) {
		this.courseHistoryList = courseHistory;
	}
	
	/**
	 * 
	 * Add index to registered course. Return false if the course is already taken, registered, or on the waitlist.
	 * 
	 * @param index_in index of course to be added
	 * @return returns a boolean if the course can be added or not
	 */
	public boolean addToRegisteredCourse(int index_in) {
		// Important since this class do not know of timing, it will be checked before this method is called
		// Also, the vacancies will be checked as well before passing, see 
		
		// Check if course exists already
		int queryC = getCourseFromLists(index_in); // Using own method
		if (queryC != -1) {
			return false; // Since course found already, cannot add even if on wait list.
		}
		
		// Save to add here since course not found.
		this.coursesRegisteredList.add(index_in);
		return true;
	}
	
	/**
	 * 
	 * Add index to wait list. Return false if the course is already taken, registered, or on the waitlist.
	 * 
	 * @param index_in index of course to be added
	 * @return
	 */
	public boolean addToWaitList(int index_in) {
		// Important since this class do not know of timing, it will be checked before this method is called
		// Also, the vacancies will be checked as well before passing, see 
		
		// Check if course exists already
		int queryC = getCourseFromLists(index_in); // Using own method
		if (queryC != -1) {
			return false; // Since course found already, cannot add even if on wait list.
		}
		
		// Save to add here since course not found.
		this.courseOnWaitList.add(index_in);
		return true;
	}
	
	/**
	 * 
	 * Check if the student is currently registered for a current index.
	 * 
	 * @param index index of course to be checked
	 * 	 * @return boolean on if student is currently taking the course.
	 */
	public boolean isTakingCourse(int index) {
		for (Integer i : this.getListCoursesRegistered()) {
			if (i == index) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Class static Method to make account
	 * Takes in all required parameters and return a full StudentAcount.
	 * 
	 * 
	 * @param loginID The username used to access an account that is registered under MySTARS
	 * @param password The password that is tagged respectively under the respective account.
	 * @param email The email address that is tagged respectively under the respective account
	 * @param name Name of student
	 * @param gender Gender of student 
	 * @param nationality Nationality of student
	 * @param matricNo Matriculation number of student
	 * 
	 * @return Return student account made.
	 */
	public static StudentAccount makeAccount(	
			String login,
			String password,
			String email,
			String name, 
			String gender, 
			String nationality, 
			String matricNo) {
		
		StudentInformation info = null;
		StudentAccount newAccount = null;
		// DO NOT check if there is a dupilicate with the system backend -> Should the logic of the controller outside of entity.
		info = StudentInformation.makeStudentInformation(name,gender,nationality,matricNo);
		newAccount = new StudentAccount(login, 
										password, 
										email, 
										info, 
										new ArrayList<Integer>(),
										new ArrayList<Integer>(),
										new ArrayList<Integer>());
		return newAccount;	
	}

	
	/**
	 * Moves a course index from the wait list to the list of courses registeed
	 * 
	 * 
	 * @param index index to be shifted
	 */
	public void moveWaitListToRegistered(int index) {
		// TODO Auto-generated method stub
		int poppedIndex = -1;
		
		for (int i = 0; i < this.courseOnWaitList.size(); i++) {
			int currentIndex = this.courseOnWaitList.get(i);
			if (currentIndex == index) {
				poppedIndex = this.courseOnWaitList.remove(i);
			}
		}
		this.addToRegisteredCourse(poppedIndex);
	}

}

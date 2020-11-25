package com.mySTARS.Entities;

import java.util.ArrayList;


public class StudentAccount extends Account {
	
	private StudentInformation studentInfo; // Stores Student Information in account
	
	// Stores indexes of courses, that are bound to be uniquely identifable.
	private ArrayList<Integer> coursesRegisteredList;
	private ArrayList<Integer> courseOnWaitList;
	private ArrayList<Integer> courseHistoryList; // Assuming that each index stays unique, even if there is no slots.
	
	// To make account
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

	public StudentInformation getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInformation studentInfo) {
		this.studentInfo = studentInfo;
	}

	public ArrayList<Integer> getListCoursesRegistered() {
		return coursesRegisteredList;
	}
	
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
	
	public int dropFromCoursesRegistered(int droppingIndex) {
		for (int i = 0 ; i < this.coursesRegisteredList.size() ; i++) {
			if (this.coursesRegisteredList.get(i) == droppingIndex) {
				this.coursesRegisteredList.remove(i);
				return droppingIndex;
			}
		}
		return -1; // Reach here means failed.
	}
	
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


	public ArrayList<Integer> getCourseHistoryList() {
		return courseHistoryList;
	}

	public void setCourseHistory(ArrayList<Integer> courseHistory) {
		this.courseHistoryList = courseHistory;
	}
	
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
	
	public boolean isTakingCourse(int index) {
		for (Integer i : this.getListCoursesRegistered()) {
			if (i == index) {
				return true;
			}
		}
		return false;
	}

	
	// Static Methods that the StudentAccount class holds
	// 1) Adding Student Account
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

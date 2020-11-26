package com.mySTARS.Control;


import java.util.ArrayList;

import com.mySTARS.Entities.Course;
import com.mySTARS.Entities.IndexDetail;
import com.mySTARS.Entities.StudentAccount;
import com.mySTARS.Entities.SystemBackend;
/**
 * user manager class that handling of student objects
 * @author user
 *
 */
public class UserMgr {
	/**
	 * check vacancies of a course index
	 * @param indexReading index of course
	 * @return vacancies in index of course
	 */
	public static int checkVacancies(int indexReading) {
		int vacancies = SystemBackend.getClassVacancies(indexReading);
		return vacancies;
	}
	/**
	 * boolean value on whether a course can be found
	 * @param index course index
	 * @return returns boolean value true / false
	 */
	public static boolean canFindCourse(int index) { 
		Course tryGetCourse = SystemBackend.getCourse(index);
		if (tryGetCourse == null) {
			return false; // Cannot get cause
		} else {
			return true;
		}
	}
	/**
	 * add course into student account
	 * @param index index of course to be added
	 * @param account account that course will be added into
	 * @return returns course that is to be added
	 */
	public static String addCourse(int index, StudentAccount account) {
		String result = null;
		
			Course incomingCourse = SystemBackend.getCourse(index);
			
			if (incomingCourse == null) {
				result = "Course index to be added not found. Please check index and try again";
				return result;
			} 
			boolean indexExist = SystemBackend.indexExistInCourse(incomingCourse, index);
			if (!indexExist) {
				result = "Index does not exist in course";
				return result;
			}

			// Check if code matches any in the wait list, previously taken (history) or currently registered;
			ArrayList<Integer> retrievedList = account.getAllCourseIndex();
		
				// Retrieve course object using index and Add all related courses index to Course.
			ArrayList<Course> listOfCoursesTaken = SystemBackend.retrieveCourseListByIndexList(retrievedList);
			
				// Check if course code match in past records with the current courses
			boolean match = SystemBackend.checkMatchingCourseCode(listOfCoursesTaken, incomingCourse);
			
			if (match) {
				result = "Course either taken, registered, or already on waitList. Unable to take again!";
				return result;
			}
			
			ArrayList<Integer> currentTimeTableIndexes = account.getCombinedWaitandRegisteredList();
			boolean clash = SystemBackend.checkTimingClashes(currentTimeTableIndexes, index);
			
			if (clash) {
				result = "Course timetable clash with current index";
				return result;
			}
			
			// Check if no vacancy
			IndexDetail retrievedIndexDetail = SystemBackend.getIndexDetails(index);
			if (retrievedIndexDetail.getVacancy() == 0) {
				// Add to waitlist for student instead
				SystemBackend.addCourseWaitListForStudent(index, account);
				result = ("Course: " + incomingCourse.getCourseCode() + ". Index: " + index + " has no vacancy left. You will be placed on the waitList.");
				NotificationMgr.AddCourseToWaitList(account.getEmail(),index);
				return result;
			} else {
				SystemBackend.addCourseForStudent(index, account);
				result = ("Course: " + incomingCourse.getCourseCode() + ". Index: " + index + " added successfully!");
				NotificationMgr.SuccessfulAddCourse(account.getEmail(), index);
				return result;
			}		
	}
	/**
	 * drop course from student account
	 * @param index index of course to be dropped
	 * @param account account that course will be dropped from
	 * @return returns course that is dropped
	 */
	public static String dropCourse(int index, StudentAccount account) {
		String result = null;
		boolean canFindCourse1 = UserMgr.canFindCourse(index);
		if(!canFindCourse1) {
			result = "Invalid index. Course not found";
			return result;
		} else if (!account.isTakingCourse(index)) { // Must check if account takes the course.
			result = "Your are not taking the course. Unable to drop.";
			return result;
		} else {
			account.dropFromCoursesRegistered(index);
			SystemBackend.dropCourse(index, account);
			result = "Course " + index + " dropped successfuly\n" + "Currently Registered Courses:\n" + getCoursesRegistered(account).toString();
			// Check waitlist for currentCourse
			SystemBackend.handlingPopOfWaitList(index);
			NotificationMgr.SuccesfulDropCourse(account.getEmail(), index);
			return result;
		}
		
	}
	/**
	 * change index of a registered course
	 * @param indexReadingOld old index
	 * @param indexReadingNew new index
	 * @param account account that registerd course index will be changed in
	 * @return returns changed index
	 */
	public static String changeIndex(int indexReadingOld, int indexReadingNew, StudentAccount account) {
		String result;
		
//		// Check if both indexes are valid
		Course yourCourse = SystemBackend.getCourse(indexReadingOld);
		Course otherStudentCourse = SystemBackend.getCourse(indexReadingNew);
		if ((yourCourse == null ) || (otherStudentCourse == null)) {
			result = "Error. Please enter a valid index";
			return result;
		} else if (!yourCourse.getCourseCode().equalsIgnoreCase(otherStudentCourse.getCourseCode())) {
			result = "Courses are not the same! Please enter the correct indexes";
			return result;
		}

		// drop old index		
		SystemBackend.dropCourse(indexReadingOld, account);
		
		// check for timing clash with new index
		ArrayList<Integer> TimeTable = account.getListCoursesRegistered();
		boolean yourClash = SystemBackend.checkTimingClashes(TimeTable, indexReadingNew);
		
		// add back either old index or new index
		if (!yourClash) {
			SystemBackend.addCourseForStudent(indexReadingNew, account);
			NotificationMgr.IndexChange(account.getEmail(), indexReadingOld, indexReadingNew);
			result = "Index succesfully changed";
		} else {
			SystemBackend.addCourseForStudent(indexReadingOld, account);
			result = "Timing clash, index not changed";
		}
		
		return result;
	}
	/**
	 * returns a string of courses registered for display
	 * @param account account of registered courses we want to display
	 * @return returns courses registered by student
	 */
	public static String getCoursesRegistered(StudentAccount account) {
		String string = SystemBackend.getCoursesRegisteredString(account);
		return string;
	}
	/**
	 * swapping of index between 2 students
	 * @param yourIndex index of student 1
	 * @param otherIndex index of student 2
	 * @param yourAccount account of student 1
	 * @param username username of student 2 for verification
	 * @param password password of student 2 for verification
	 * @return returns swapped index result
	 */
	public static String swopIndex(int yourIndex, int otherIndex, StudentAccount yourAccount, String username, String password) {
		
		String result;
		
		// Check if both indexes are valid
		Course yourCourse = SystemBackend.getCourse(yourIndex);
		Course otherStudentCourse = SystemBackend.getCourse(otherIndex);
		if ((yourCourse == null ) || (otherStudentCourse == null)) {
			result = "Error. Please enter a valid index";
			return result;
		} else if (!yourCourse.getCourseCode().equalsIgnoreCase(otherStudentCourse.getCourseCode())) {
			result = "Courses are not the same! Please enter the correct indexes";
			return result;
		}
		
		// Check if otherAccount is valid
		StudentAccount otherAccount = SystemBackend.retrieveStudentRecord(username.toUpperCase(), password);
		if (otherAccount == null) {
			result = "Error. Please check that the other account is valid.";
			return result;
		}
		
		// Check if both taking index
		if (!(yourAccount.isTakingCourse(yourIndex)) || !(otherAccount.isTakingCourse(otherIndex))) {
			result = "Error. Please ensure that both swappeers takes the specified index";
		}
		
		// Retrieve intermediate timetable (all indexes except the ones to be swap)
		ArrayList<Integer> yourTimeTable = yourAccount.filterListCoursesRegistered(yourIndex); // Still includes all index
		ArrayList<Integer> otherTimeTable = otherAccount.filterListCoursesRegistered(otherIndex); // STill includes all index

//		System.out.println(yourTimeTable);
//		System.out.println(otherTimeTable);
		
		// Check timing clashes
		boolean yourClash = SystemBackend.checkTimingClashes(yourTimeTable, otherIndex);
		boolean otherClash = SystemBackend.checkTimingClashes(otherTimeTable, yourIndex);
		if (yourClash || otherClash) {
			result = "There is a timing clash in one of the timetables. Unable to swap";
			return result;
		}
			
		// Safe to perform swop
		SystemBackend.changeIndex(yourIndex, otherIndex, yourAccount);
		NotificationMgr.IndexChange(yourAccount.getEmail(), yourIndex, otherIndex);
		SystemBackend.changeIndex(otherIndex, yourIndex, otherAccount);
		NotificationMgr.IndexChange(otherAccount.getEmail(), otherIndex, yourIndex);
		result = "Swapped " + yourIndex + " [" + yourAccount.getLoginID() + "] with " + otherIndex + " [" + otherAccount.getLoginID() + "]";
		return result;	
	}
}

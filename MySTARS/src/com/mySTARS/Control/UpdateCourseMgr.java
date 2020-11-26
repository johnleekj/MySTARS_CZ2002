package com.mySTARS.Control;

import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.SystemBackend;
/**
 * Class to handle the updating of course interactions
 */
public class UpdateCourseMgr {
	/**
	 * Updates course code of course in SystemBackend class
	 * @param currentCourseCode the initial course code
	 * @param newCourseCode the updated course code
	 * @return returns changed course code
	 */
	public static String changeCourseCode(String currentCourseCode, String newCourseCode) {
		/*
		* Updates course code of course in SystemBackend class
		*/
		return SystemBackend.updateCourseCode(currentCourseCode, newCourseCode);
	}
	/**
	 * Updates school of course in SystemBackend class
	 * @param currentCourseCode course code to be changed
	 * @param newSchool School value for updating
	 */
	public static void changeSchool(String currentCourseCode, SCHOOL newSchool) {
		/*
		* Updates school of course in SystemBackend class
		*/
		SystemBackend.updateCourseSchool(currentCourseCode, newSchool);		
	}
	/**
	 * Updates course index of course in SystemBackend class
	 * @param currentCourseCode course code to be changed
	 * @param newCourseIndex index to be added
	 * @param capacity holds the index capacity of added index number
	 */
	public static void addIndexToExistingCourse(String currentCourseCode, int newCourseIndex, int capacity) {
		/*
		* Updates course index of course in SystemBackend class
		*/
		SystemBackend.addNewCourseIndex(currentCourseCode, newCourseIndex, capacity);
	}
	/**
	 * Removes course index of existing course in SystemBackend class
	 * @param currentCourseCode course code to be changed
	 * @param currentCourseIndex course index to be removed
	 */
	public static void removeIndexFromExistingCourse(String currentCourseCode, int currentCourseIndex) {
		/*
		* Removes course index of existing course in SystemBackend class
		*/
		SystemBackend.removeCurrentCourseIndex(currentCourseCode, currentCourseIndex);
	}
	/**
	 * Updates index capacity in SystemBackend class
	 * @param currentCourseCode course code to be changed
	 * @param currentCourseIndex5 course index to be changed
	 * @param updateValue update value to change to
	 */
	public static void changeIndexCourseVacancy(String currentCourseCode, int currentCourseIndex5, int updateValue) {
		SystemBackend.updateIndexCapacity(currentCourseCode, currentCourseIndex5, updateValue);
	}
	/**
	 *  Adds lesson to existing index number in SystemBackend class
	 * @param currentCourseCode course code to be changed
	 * @param index course index to be changed
	 * @param day day value of new lesson
	 * @param type type value of new lesson
	 * @param group group value of new lesson
	 * @param location location of new lesson
	 * @param lessonWeeks lesson weeks of new lesson
	 * @param remarks remarks of new lesson 
	 * @param startTime start time of new lesson
	 * @param endTime end time of new lesson
	 */
	public static void addLessonToIndex(String currentCourseCode, int index,
			DAY day, String type, String group, String location, WEEK lessonWeeks, String remarks, String startTime, String endTime) {
		SystemBackend.addLessonToExistingIndex(currentCourseCode, index,
				day, type, group, location, lessonWeeks, remarks, startTime, endTime);		
	}	
}

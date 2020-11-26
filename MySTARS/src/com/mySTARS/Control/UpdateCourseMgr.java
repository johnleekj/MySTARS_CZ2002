package com.mySTARS.Control;

import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.SystemBackend;

public class UpdateCourseMgr {
	
	public static String changeCourseCode(String currentCourseCode, String newCourseCode) {
		/**
		* @param Updates course code of course in SystemBackend class
		*/
		return SystemBackend.updateCourseCode(currentCourseCode, newCourseCode);
	}

	public static void changeSchool(String currentCourseCode, SCHOOL newSchool) {
		/**
		* @param Updates school of course in SystemBackend class
		*/
		SystemBackend.updateCourseSchool(currentCourseCode, newSchool);		
	}

	public static void addIndexToExistingCourse(String currentCourseCode, int newCourseIndex, int capacity) {
		/**
		* @param Updates course index of course in SystemBackend class
		*/
		SystemBackend.addNewCourseIndex(currentCourseCode, newCourseIndex, capacity);
	}

	public static void removeIndexFromExistingCourse(String currentCourseCode, int currentCourseIndex) {
		/**
		* @param Removes course index of existing course in SystemBackend class
		*/
		SystemBackend.removeCurrentCourseIndex(currentCourseCode, currentCourseIndex);
	}

	public static void changeIndexCourseVacancy(String currentCourseCode, int currentCourseIndex5, int updateValue) {
		/**
		* @param Updates index capacity in SystemBackend class
		*/
		SystemBackend.updateIndexCapacity(currentCourseCode, currentCourseIndex5, updateValue);
	}

	public static void addLessonToIndex(String currentCourseCode, int index,
			DAY day, String type, String group, String location, WEEK lessonWeeks, String remarks, String startTime, String endTime) {
		/**
		* @param Adds lesson to existing index number in SystemBackend class
		*/
		SystemBackend.addLessonToExistingIndex(currentCourseCode, index,
				day, type, group, location, lessonWeeks, remarks, startTime, endTime);		
	}	
}

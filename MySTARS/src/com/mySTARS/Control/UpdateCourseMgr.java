package com.mySTARS.Control;

import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.SystemBackend;

public class UpdateCourseMgr {
	
	public static String changeCourseCode(String currentCourseCode, String newCourseCode) {
		return SystemBackend.updateCourseCode(currentCourseCode, newCourseCode);
	}

	public static void changeSchool(String currentCourseCode, SCHOOL newSchool) {
		SystemBackend.updateCourseSchool(currentCourseCode, newSchool);		
	}

	public static void addIndexToExistingCourse(String currentCourseCode, int newCourseIndex, int capacity) {
		SystemBackend.addNewCourseIndex(currentCourseCode, newCourseIndex, capacity);
	}

	public static void removeIndexFromExistingCourse(String currentCourseCode, int currentCourseIndex) {
		SystemBackend.removeCurrentCourseIndex(currentCourseCode, currentCourseIndex);
	}

	public static void changeIndexCourseVacancy(String currentCourseCode, int currentCourseIndex5, int updateValue) {
		SystemBackend.updateIndexCapacity(currentCourseCode, currentCourseIndex5, updateValue);
	}

	public static void addLessonToIndex(String currentCourseCode, int indexNumber, DAY day, String endTime,
			String endTime2, String endTime3, WEEK lessonWeeks, String endTime4, String endTime5, String endTime6) {
		SystemBackend.addLessonToExistingIndex(currentCourseCode, indexNumber, day, endTime, endTime, endTime, lessonWeeks, endTime, endTime, endTime);		
	}	
}

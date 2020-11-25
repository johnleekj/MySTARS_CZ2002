package com.mySTARS.Boundary;

import java.util.Scanner;

import com.mySTARS.Control.AdminMgr;
import com.mySTARS.Control.CourseMgr;
import com.mySTARS.Control.SystemMgr;
import com.mySTARS.Control.UpdateCourseMgr;
import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.Account;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.SystemBackend;

public class UpdateCourseScreen {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void enterUpdateScreen(StaffAccount staffAcc) {
		
		String currentCourseCode = null;
		String newCourseCode = null;
		SCHOOL newSchool = null;
		String updatedCourseCode = null;
		String oldCourseSchool = null;
		String addedLesson = null;
		
		int newCourseIndex;
		int currentCourseIndex;
		int oldCourseIndex = 0;
		int updatedCourseIndex;
		int indexNumber;
		int capacity;
		int addedCourseIndex;
		// Read in data for Course
		currentCourseCode = GenericBoundary.readStringInputUPPER("Enter course code of course that you wish to change: ");
		while (!AdminMgr.ifCourseCodeClash(currentCourseCode)) {
			currentCourseCode = GenericBoundary.readStringInputUPPER("Course code invalid. Please try again: ");
		}
		int sel;
		boolean toLogout = false;
		do {
			displayUpdateCourseMenu(staffAcc.getLoginID());
			sel = GenericBoundary.readIntInputFromUser();
			switch (sel) {
				case 1:
					System.out.println("Change Course Code");
					newCourseCode = GenericBoundary.readStringInputUPPER("Enter new course code: ");
					// Update courseCode to new course code while changing.
					currentCourseCode = UpdateCourseMgr.changeCourseCode(currentCourseCode, newCourseCode);
					break;
				case 2:
					System.out.println("Change Course School");
					newSchool = GenericBoundary.readSchool();
					UpdateCourseMgr.changeSchool(currentCourseCode, newSchool);
					break;
				case 3:
					System.out.println("Add new index number to existing course");
					newCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Enter new index to add");
					while (SystemBackend.ifIndexClash(currentCourseCode, newCourseIndex)) {
						newCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Index already exists. Please try again: ");
					}
					capacity = GenericBoundary.readIntInputFromUser("Enter capacity for index for " + currentCourseCode + ": ");
					UpdateCourseMgr.addIndexToExistingCourse(currentCourseCode, newCourseIndex, capacity);
					break;
				case 4:
					System.out.println("Remove index number from existing course");
					currentCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Enter index to remove");
					while (!SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex)) {
						currentCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Wrong index for course. Please try again: ");
					}
					UpdateCourseMgr.removeIndexFromExistingCourse(currentCourseCode, currentCourseIndex);
					break;
				case 5:
					System.out.println("Change Index Course Vacancy");
					int currentCourseIndex5 = GenericBoundary.readPositiveIntInputFromUser("Enter index number of course that you wish to change: ");
					if(SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex5)) {
						int updateValue = GenericBoundary.readPositiveIntInputFromUser("Enter the capacity value that you would like to change to:  ");
						UpdateCourseMgr.changeIndexCourseVacancy(currentCourseCode, currentCourseIndex5, updateValue);
					}
					break;
				case 6:
					System.out.println("Add Lesson to Existing Index");
					indexNumber = GenericBoundary.readPositiveIntInputFromUser("Enter index number of course that you wish to change: ");
					if(SystemBackend.ifIndexClash(currentCourseCode, indexNumber)) {
						DAY day = GenericBoundary.readDay();
						String type = GenericBoundary.readStringInputUPPER("Enter Lesson type: ");
						String location = GenericBoundary.readStringInputUPPER("Enter lesson location: ");
						WEEK lessonWeeks = GenericBoundary.readWeek();
						String remarks =  GenericBoundary.readStringInputCaseSensitive("Enter lesson remarks: ");
						String startTime = GenericBoundary.readStringInputCaseSensitive("Enter start time(24hr clock): ");
						String endTime = GenericBoundary.readStringInputCaseSensitive("Enter end time(24hr clock): ");
						UpdateCourseMgr.addLessonToIndex(currentCourseCode, indexNumber, day, endTime, endTime, endTime, lessonWeeks, endTime, endTime, endTime);			
					}
					break;
				case 7:
					toLogout = true;
					break;
				default:
					System.out.println("Invalid choice, try again");
			} 
		} while (!toLogout);
	}
	

	public static void displayUpdateCourseMenu(String identifier) {
		System.out.println(	"\n===== CHANGES MENU =====");
		System.out.println(	"Hi " + identifier + ", what changes would you like to make to the course?\n" +
				"1. Change Course Code\n" +
				"2. Change Course School\n" +
				"3. Add new index number to existing course\n" +
				"4. Remove index number from existing course\n" +
				"5. Change Course Vacancy\n" +
				"6. Add Lesson to Existing Index\n" +
				"7. Quit");
	}

}
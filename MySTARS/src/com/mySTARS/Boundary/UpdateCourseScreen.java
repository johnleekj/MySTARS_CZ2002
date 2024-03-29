package com.mySTARS.Boundary;

import java.util.Scanner;

import com.mySTARS.Control.AdminMgr;
import com.mySTARS.Control.SystemMgr;
import com.mySTARS.Control.UpdateCourseMgr;
import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.Account;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.SystemBackend;
/**
 * Screen for handling update course interactions
 *
 */
public class UpdateCourseScreen {
	
	public static Scanner scanner = new Scanner(System.in);
	/**
	 * Loads necessary data for update of courses. Displays menu to select course
	 * update interactions.
	 * @param staffAcc admin account with access permissions required.
	 */
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
		/*
		* (currentCourseCode = GenericBoundary.readStringInputUPPER()) (Calling GenericBoundary class to read in string input from user and use it as the courseCode that admin wishes to change)
		*/
		currentCourseCode = GenericBoundary.readStringInputUPPER("Enter course code of course that you wish to change: ");
		/*
		* (while (!AdminMgr.ifCourseCodeClash(currentCourseCode)) (Checking that course code that is entered is valid)
		*/
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
					/*
					* Admin chooses to change the course code of this particular course
					*/
					System.out.println("Change Course Code");
					newCourseCode = GenericBoundary.readStringInputUPPER("Enter new course code: ");
					/*
					* (currentCourseCode = UpdateCourseMgr.changeCourseCode(currentCourseCode, newCourseCode)) (Calling UpdateCourseMgr class which changes old courseCode to the new one read in from admin user, newCourseCode)
					*/
					currentCourseCode = UpdateCourseMgr.changeCourseCode(currentCourseCode, newCourseCode);
					break;
				case 2:
					/*
					* Admin chooses to change the school that this particular course is under
					*/
					System.out.println("Change Course School");
					newSchool = GenericBoundary.readSchool();
					/*
					*  (UpdateCourseMgr.changeSchool(currentCourseCode, newCourseCode)) (Calling UpdateCourseMgr class which changes old school to the new one read in from admin user, newSchool)
					*/
					UpdateCourseMgr.changeSchool(currentCourseCode, newSchool);
					break;
				case 3:
					/*
					* Admin chooses to add a new index number to existing course
					*/
					System.out.println("Add new index number to existing course");
					newCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Enter new index to add");
					/*
					* (while (SystemBackend.ifIndexClash(currentCourseCode, newCourseIndex)) (Calls SystemBackend class that calls IndexDetail class to check if the new index that is added does not clash with an index that already exists)
					*/
					while (SystemBackend.ifIndexClash(currentCourseCode, newCourseIndex)) {
						newCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Index already exists. Please try again: ");
					}
					/*
					* (capacity = GenericBoundary.readIntInputFromUser("Enter capacity for index for " + currentCourseCode + ": ")) (Calls GenericBoundary class to read in int input from user and use it as the capacity for new index that is added)
					* (UpdateCourseMgr.addIndexToExistingCourse(currentCourseCode, newCourseIndex, capacity)) (Calling UpdateCourseMgr class which calls Course and IndexDetail class to update database with this new index number)
					*/
					capacity = GenericBoundary.readIntInputFromUser("Enter capacity for index for " + currentCourseCode + ": ");
					UpdateCourseMgr.addIndexToExistingCourse(currentCourseCode, newCourseIndex, capacity);
					break;
				case 4:
					/*
					* Admin chooses to remove index number from existing course
					*/
					System.out.println("Remove index number from existing course");
					currentCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Enter index to remove");
					/*
					* (while (!SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex)) (Calls SystemBackend class that calls IndexDetail class to check if the index is tagged to the correct course)
					*/
					while (!SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex)) {
						currentCourseIndex = GenericBoundary.readPositiveIntInputFromUser("Wrong index for course. Please try again: ");
					}
					/*
					* (UpdateCourseMgr.removeIndexFromExistingCourse(currentCourseCode, currentCourseIndex)) (Calling UpdateCourseMgr class which calls Course and IndexDetail class to remove index number from database)
					*/
					UpdateCourseMgr.removeIndexFromExistingCourse(currentCourseCode, currentCourseIndex);
					break;
				case 5:
					/*
					* Admin chooses to change the capacity of an existing index number
					*/
					System.out.println("Change Index Course Vacancy");
					int currentCourseIndex5 = GenericBoundary.readPositiveIntInputFromUser("Enter index number of course that you wish to change: ");
					/*
					* (if(SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex5)) (Calls SystemBackend class that calls IndexDetail class to check if the index entered is valid)
					* (UpdateCourseMgr.removeIndexFromExistingCourse(currentCourseCode, currentCourseIndex5, updateValue)) (Calling UpdateCourseMgr class which calls Course and IndexDetail class to change the capacity of the index number from database)
					*/
					if(SystemBackend.ifIndexClash(currentCourseCode, currentCourseIndex5)) {
						int updateValue = GenericBoundary.readPositiveIntInputFromUser("Enter the capacity value that you would like to change to:  ");
						UpdateCourseMgr.changeIndexCourseVacancy(currentCourseCode, currentCourseIndex5, updateValue);
					}
					break;
				case 6:
					/*
					* Admin chooses to add lesson to existing index number
					*/
					System.out.println("Add Lesson to Existing Index");
					indexNumber = GenericBoundary.readPositiveIntInputFromUser("Enter index number of course that you wish to change: ");
					/*
					* (if(SystemBackend.ifIndexClash(currentCourseCode, indexNumber)) (Calls SystemBackend class that calls IndexDetail class to check if the index entered is valid)
					* Methods below just checks for lesson type, location, remarks, and the start and end time of lesson
					*/
					if(SystemBackend.ifIndexClash(currentCourseCode, indexNumber)) {
						DAY day = GenericBoundary.readDay();
						String type = GenericBoundary.readStringInputUPPER("Enter Lesson type (e.g.Lec/tut/lab): ");
						String groupname = GenericBoundary.readStringInputUPPER("Enter course group (e.g.CS2): ");
						String location = GenericBoundary.readStringInputUPPER("Enter lesson location: ");
						WEEK lessonWeeks = GenericBoundary.readWeek();
						String remarks =  GenericBoundary.readStringInputCaseSensitive("Enter lesson remarks: ");
						String startTime = GenericBoundary.readStringInputCaseSensitive("Enter start time(24hr clock e.g.0900): ");
						String endTime = GenericBoundary.readStringInputCaseSensitive("Enter end time(24hr clock e.g.0900): ");
						UpdateCourseMgr.addLessonToIndex(currentCourseCode, indexNumber,
								day, type, groupname, location, lessonWeeks, remarks, startTime, endTime);			
					}
					break;
				case 7:
					/*
					* Admin has successfully made whatever changes are necessary and wants to exit changes menu
					*/
					toLogout = true;
					break;
				default:
					/*
					* Default case that is activated should the user input not be an integer type within the given cases
					*/
					System.out.println("Invalid choice, try again");
			} 
		} while (!toLogout);
	}
	
	/**
	 * Display menu of interaction options admins can carry out.
	 * @param identifier To identify the admin using the system.
	 */
	public static void displayUpdateCourseMenu(String identifier) {
		/*
		* Changes Menu that only admin sees if they wish to update an existing course's details
		*/
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
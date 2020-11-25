package com.mySTARS.Boundary;

import com.mySTARS.Control.SystemMgr;
import com.mySTARS.Control.UserMgr;
import com.mySTARS.Entities.Course;
import com.mySTARS.Entities.StudentAccount;

public class UserScreen {

	public static void enterStudent(StudentAccount studentAccount) {
		//			"1. Add Course\n" +
		//					"2. Drop Course\n" +
		//					"3. Print Courses Registered\n" +
		//					"4. Check Vacancies Available\n" +
		//					"5. Change Index Number of Course\n" +
		//					"6. Swap Index Number With Another Student\n" +
		//					"7. Quit");
		int sel;
		boolean toLogout = false;
		String result = null;
		do {
			displayUserMenu();
			sel = GenericBoundary.readIntInputFromUser();
			switch (sel) {
			case 1:
				System.out.println("[Adding Course]");
				int indexReading1 = GenericBoundary.readPositiveIntInputFromUser("Please enter the course index that you want to add:");
				result = UserMgr.addCourse(indexReading1, studentAccount);
				System.out.println(result);
				break;
			case 2:
				System.out.println("Drop Course");
				int indexReading2 = GenericBoundary.readPositiveIntInputFromUser("Please enter the course index that you want to drop:");
				result = UserMgr.dropCourse(indexReading2, studentAccount);
				System.out.println(result);
				break;
			case 3:
				System.out.println("[Printing Courses Registered]");
				String formattedText = UserMgr.getCoursesRegistered(studentAccount);
				System.out.println("---List of current courses---\n");
				System.out.println(formattedText);
				break;
			case 4:
				System.out.println("[Checking Vacancies Available]");
				int indexReading4 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to check vacancies");
				int vacancies = UserMgr.checkVacancies(indexReading4);
				if (vacancies < 0) {
					System.out.println("Error. Index not found.");
				} else {
					System.out.println("Vacancies for Course [" + indexReading4 + "] : " + vacancies);
				}
				break;
			case 5:
				System.out.println("Change Index Number of Course");
				int indexReadingOld = GenericBoundary.readPositiveIntInputFromUser("Please enter index to swap");
				int indexReadingNew = GenericBoundary.readPositiveIntInputFromUser("Please enter new index");
				result = UserMgr.changeIndex(indexReadingOld, indexReadingNew, studentAccount);
				System.out.println(result);
				break;
			case 6:
				System.out.println("[Swaping Index Number With Another Student]");
				int yourIndex = GenericBoundary.readIntInputFromUser("Please enter your index: ");
				int otherIndex = GenericBoundary.readIntInputFromUser("Please enter the other student's index: ");
				String username = MainScreen.readUsername(); 
				String password = MainScreen.readPassword();
				String status = UserMgr.swopIndex(yourIndex, otherIndex, studentAccount, username, password);
				System.out.println(status); 
				break;
			case 7:
				printCourseList();
				break;
			case 8:
				toLogout = true;
				break;
			default:
				System.out.println("Invalid choice, try again");
			}
		} while (!toLogout);	
	}
	
	
	public static void displayUserMenu() {
		System.out.println("[USER MENU]");
		System.out.println(	"Hi, what would you like to do now?\n" +
							"1. Add Course\n" +
							"2. Drop Course\n" +
							"3. Print Courses Registered\n" +
							"4. Check Vacancies Available\n" +
							"5. Change Index Number of Course\n" +
							"6. Swop Index Number With Another Student\n" +
							"7. Print General Course List\n" +
							"8. Logout");
		
	}

	public static void printCourseList() {
		System.out.println("Here are the list of courses");
		System.out.println("============================================================");
		System.out.println(SystemMgr.getGeneralCourseList());
		System.out.println("============================================================");
	}
}

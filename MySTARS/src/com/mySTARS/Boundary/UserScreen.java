package com.mySTARS.Boundary;

import com.mySTARS.Control.EncryptionMgr;
import com.mySTARS.Control.SystemMgr;
import com.mySTARS.Control.UserMgr;
import com.mySTARS.Entities.Course;
import com.mySTARS.Entities.StudentAccount;
/**
 * User Screen class to handle admin interactions.
 *
 */
public class UserScreen {
	
	/**
	 * Logs student account into system. Displays menu options for student interactions.
	 * @param studentAccount
	 */
	public static void enterStudent(StudentAccount studentAccount) {
		int sel;
		boolean toLogout = false;
		String result = null;
		do {
			displayUserMenu();
			sel = GenericBoundary.readIntInputFromUser();
			switch (sel) {
			case 1:
				/*
				* Student chooses to add course to their timetable
				*/
				System.out.println("[Adding Course]");
				/*
				* (GenericBoundary.readPositiveIntInputFromUser()) (GenericBoundary class is called to read in input from user, to which it must be positive integer)
				* (result = UserMgr.addCourse(indexReading1, studentAccount)) (Calls UserMgr to call course class where course is added)
				*/
				int indexReading1 = GenericBoundary.readPositiveIntInputFromUser("Please enter the course index that you want to add:");
				result = UserMgr.addCourse(indexReading1, studentAccount);
				System.out.println(result);
				break;
			case 2:
				/*
				* Student chooses to drop course from their timetable
				*/
				System.out.println("Drop Course");
				int indexReading2 = GenericBoundary.readPositiveIntInputFromUser("Please enter the course index that you want to drop:");
				/*
				* (result = UserMgr.dropCourse(indexReading2, studentAccount)) (Calls UserMgr to call course class where course would be dropped)
				*/
				result = UserMgr.dropCourse(indexReading2, studentAccount);
				System.out.println(result);
				break;
			case 3:
				/*
				* Student chooses to print courses that have already been registered in their timetable
				*/
				System.out.println("[Printing Courses Registered]");
				/*
				* (formattedText = UserMgr.getCoursesRegistered(studentAccount)) (Calls UserMgr to call course class where list of courses that user has added to their timetable would be printed)
				*/
				String formattedText = UserMgr.getCoursesRegistered(studentAccount);
				System.out.println("---List of current courses---\n");
				System.out.println(formattedText);
				break;
			case 4:
				/*
				* Student chooses to check the number of vacant slots that are available in a particular index
				*/
				System.out.println("[Checking Vacancies Available]");
				int indexReading4 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to check vacancies");
				/*
				* (vacancies = UserMgr.checkVacancies(indexReading4)) (Calls UserMgr to call indexdetail class to check the number of vacancies that are available in a particular index number)
				*/
				int vacancies = UserMgr.checkVacancies(indexReading4);
				if (vacancies < 0) {
					/*
					* Error message is printed if index that is entered is invalid
					*/
					System.out.println("Error. Index not found.");
				} else {
					System.out.println("Vacancies for Course [" + indexReading4 + "] : " + vacancies);
				}
				break;
			case 5:
				/*
				* Student chooses to change a current index number that they have chosen to take for a particular course in their timetable
				*/
				System.out.println("Change Index Number of Course");
				int indexReadingOld = GenericBoundary.readPositiveIntInputFromUser("Please enter index to swap");
				int indexReadingNew = GenericBoundary.readPositiveIntInputFromUser("Please enter new index");
				/*
				* (result = UserMgr.changeIndex(indexReadingOld, indexReadingNew, studentAccount)) (Calls UserMgr to call indexdetail class to change the index number that user is taking)
				*/
				result = UserMgr.changeIndex(indexReadingOld, indexReadingNew, studentAccount);
				System.out.println(result);
				break;
			case 6:
				/*
				* Student chooses to swap an index number that they have taken with another student
				*/
				System.out.println("[Swapping Index Number With Another Student]");
				int yourIndex = GenericBoundary.readIntInputFromUser("Please enter your index: ");
				int otherIndex = GenericBoundary.readIntInputFromUser("Please enter the other student's index: ");
				/*
				* Reads in username of student that they are swapping index with
				*/
				String username = EncryptionMgr.readUsername();
				/*
				* Prompts for student password again to ensure change made is validated
				*/
				String password = EncryptionMgr.readPassword();
				/*
				* (status = UserMgr.swopIndex(yourIndex, otherIndex, studentAccount, username, password)) (Calls UserMgr to call indexdetail class to swap the index number with another student user)
				*/
				String status = UserMgr.swopIndex(yourIndex, otherIndex, studentAccount, username, password);
				System.out.println(status); 
				break;
			case 7:
				/*
				* Print entire course list so that student is able to check which index numbers are available
				*/
				printCourseList();
				break;
			case 8:
				/*
				* Student logout
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
	 * Displays the user menu
	 */
	public static void displayUserMenu() {
		/*
		* Student Menu that users see upon successfully logging into their account
		*/
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
	/**
	 * displays list of courses
	 */
	public static void printCourseList() {
		System.out.println("Here are the list of courses");
		System.out.println("============================================================");
		System.out.println(SystemMgr.getGeneralCourseList());
		System.out.println("============================================================");
	}
}

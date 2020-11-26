package com.mySTARS.Boundary;

import java.util.Scanner;

import com.mySTARS.Control.AdminMgr;
import com.mySTARS.Control.SystemMgr;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.Entities.IndexDetail;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.SystemBackend;
/**	
 * 
 * Admin Screen class to handle admin interactions.
 *
 */
public class AdminScreen {
	
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Logs admin account into system. Displays menu options for admin interactions.
	 * @param staffAcc account of staff
	 */
	
	public static void enterAdmin(StaffAccount staffAcc) {
		int sel;
		boolean toLogout = false;
		
		do {
			displayAdminMenu();
			sel = GenericBoundary.readIntInputFromUser();
			switch (sel) {
				case 1:
					/*
					* Admin chooses to edit the access period that students can access MySTARS
					*/
					System.out.println("[Editing Access Period]");
					String startAccess = null;
					String endAccess = null;
					System.out.print("Please enter start of access date (Format: yyyy-MM-dd) ");
					/*
					* (startAccess = scanner.nextLine().trim()) (Reads in user input for START of access DATE)
					*/
					startAccess = scanner.nextLine().trim();
					System.out.print("Please enter start of access time (Format: HH:mm:ss) ");
					/*
					* (startAccess = scanner.nextLine().trim()) (Reads in user input for START of access TIME)
					*/
					startAccess += " at " + scanner.nextLine().trim();
					System.out.print("Please enter end of access date (Format: yyyy-MM-dd) ");
					/*
					* (startAccess = scanner.nextLine().trim()) (Reads in user input for END of access DATE)
					*/
					endAccess = scanner.nextLine().trim();
					System.out.print("Please enter end of access time (Format: HH:mm:ss) ");
					/*
					*(startAccess = scanner.nextLine().trim()) (Reads in user input for END of access TIME)
					*/
					endAccess += " at " + scanner.nextLine().trim();
					/*
					* (SystemMgr.editAccessPeriod(startAccess, endAccess)) (Calls SystemMgr to edit the access period data)
					*/
					SystemMgr.editAccessPeriod(startAccess, endAccess);
					break;
				case 2:
					/*
					* Admin chooses to add student to the database
					*/
					System.out.println("[Adding Student]");
					String login = null;
					String password = null;
					String email = null;
					String name = null;
					String gender = null;
					String nationality = null;
					String matricNo = null;
					/*
					* (login = GenericBoundary.readStringInputUPPER()) (Calling GenericBoundary class to read in string input from user and use it as student account data)
					*/
					login = GenericBoundary.readStringInputUPPER("Enter new loginID: ");
					/*
					* (while (AdminMgr.ifLoginClash(login))) (Ensuring that the loginID is unique)
					*/
					while (AdminMgr.ifLoginClash(login)) {
						login = GenericBoundary.readStringInputUPPER("LoginID taken. Enter another loginID: ");
					}
					password = GenericBoundary.readStringInputCaseSensitive("Enter new password: ");
					email = GenericBoundary.readStringInputUPPER("Enter student email: ");
					/*
					* Here is where the name, gender, nationality, matricNo is read in as data to be part of student account
					*/
					name = GenericBoundary.readStringInputUPPER("Enter student name: ");
					gender = GenericBoundary.readStringInputUPPERnoInt("Enter student gender: ");
					nationality = GenericBoundary.readStringInputUPPERnoInt("Enter student nationality: ");
					matricNo = GenericBoundary.readStringInputUPPER("Enter student matriculationNo: ");
				
					/*
					* (AdminMgr.addStudentAccounts()) (Calling AdminMgr class which calls StudentAccount and SystemBackend class to add the data input as a new student account that is to be added in the database)
					*/
					AdminMgr.addStudentAccounts(
							staffAcc,
							login,
							password,
							email,
							name,
							gender,
							nationality,
							matricNo
							);
					System.out.println("Added new student and account.");
					break;
				case 3:
					/*
					* Admin chooses to add new course to the database
					*/
					System.out.println("[Adding new Course]");
					String courseCode = null;
					String courseName = null;
					int courseUnits = 0;
					SCHOOL schoolName = null;
					/*
					* (courseCode = GenericBoundary.readStringInputUPPER()) (Calling GenericBoundary class to read in string input from user and use it as the new courseCode)
					*/
					courseCode = GenericBoundary.readStringInputUPPER("Enter new course code: ");
					/*
					* (while (AdminMgr.ifCourseCodeClash(courseCode))) (Calling AdminMgr class which calls Course class to check courseCode entered by admin does not already exist)
					*/
					while (AdminMgr.ifCourseCodeClash(courseCode)) {
						courseCode = GenericBoundary.readStringInputUPPER("Course code taken. Enter another course code: ");
					}
					courseName = GenericBoundary.readStringInputUPPER("Enter new course name: ");
					courseUnits = GenericBoundary.readPositiveIntInputFromUser("Enter course units: ");
					schoolName = GenericBoundary.readSchool();
					
					/*
					* (AdminMgr.addCourse()) (Calling AdminMgr class which calls Course and SystemBackend class to add the data input as a new course that is to be added in the database)
					*/
					AdminMgr.addCourse(
							courseCode,
							courseName,
							courseUnits,
							schoolName);
					System.out.println("Added new course.");
					break;
				case 4:
					/*
					* Admin chooses to update details of an existing course
					*/
					System.out.println("[Updating Course]");
					/*
					* (AdminMgr.enterUpdateScreen()) (Calls AdminMgr class which calls updateCourseScreen class to display the changes menu from which admin can choose from)
					*/
					AdminMgr.enterUpdateScreen(staffAcc);
					break;
				case 5:
					/*
					* Admin chooses to check how many available slots are there in a class
					*/
					System.out.println("[Checking available slots in class]");
					int indexReading5 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to check vacancies");
					int vacancies = AdminMgr.checkVacancies(indexReading5);
					/*
					* (if (vacancies < 0)) (Checks if index number entered by admin is even valid)
					* (else()) (Returns number of vacancies by calling indexDetail class to check for number of vacancies)
					*/
					if (vacancies < 0) {
						System.out.println("Error. Index not found.");
					} else {
						System.out.println("Vacancies for Course [" + indexReading5 + "] : " + vacancies);
					}
					break;
				case 6:
					/*
					* Admin chooses to print student list by index number
					*/
					System.out.println("[Printing student list by index number]");
					int indexReading6 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to print list by: ");
					/*
					* (formatByIndex = AdminMgr.getStudentList()) (Calls AdminMgr class which calls SystemBackend and IndexDetail class to check for students that are in each index, then it checks against StudentInformation class for the student detailss)
					*/
					String formatByIndex = AdminMgr.getStudentList(indexReading6);
					System.out.println("List of student taking index number: [" + indexReading6 +"]");
					System.out.println(formatByIndex);
					break;
				case 7:
					/*
					* Admin chooses to print student list by course
					*/
					System.out.println("[Printing student list by course]");
					System.out.println("Print student list by course");
					String courseNameFilter = GenericBoundary.readStringInputUPPER("Please enter course to print list by: ");
					/*
					* (formatByCourse = AdminMgr.getStudentList()) (Calls AdminMgr class which calls SystemBackend and Course class to check for students that are in each index, then it checks against StudentInformation class for the student detailss)
					*/
					String formatByCourse = AdminMgr.getStudentList(courseNameFilter);
					System.out.println("List of student taking course: [" + courseNameFilter +"]");
					System.out.println(formatByCourse);
					break;
				case 8:
					/*
					* Print entire course list for admin
					*/
					printCourseList();
					break;
				case 9:
					/*
					* Admin logout
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
	 * Displays the admin menu
	 */
	
	public static void displayAdminMenu() {
		/*
		* Admin Menu that users see upon successfully logging into their account
		*/
		System.out.println(	"[ADMIN MENU]");
		System.out.println(	"Hi, what would you like to do now?\n" +
							"1. Edit student access period\n" +
						 	"2. Add a student (name, matric number, gender, nationality, etc)\n" +
							"3. Add a course (course code, school, its index numbers and vacancy)\n" +
							"4. Update a course (course code, school, its index numbers and vacancy)\n" +
							"5. Check available slot for an index number (vacancy in a class)\n" +
							"6. Print student list by index number\n" +
							"7. Print student list by course (all students registered for the selected course)\n" +
							"8. Print full course list\n" +
							"9. Logout");
	}
	/**
	 * Print list of courses
	 */
	public static void printCourseList() {
		System.out.println("Here are the list of courses");
		System.out.println("============================================================");
		System.out.println(SystemMgr.getGeneralCourseList());
		System.out.println("============================================================");
	}
}

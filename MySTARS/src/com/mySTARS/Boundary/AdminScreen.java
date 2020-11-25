package com.mySTARS.Boundary;

import java.util.Scanner;

import com.mySTARS.Control.AdminMgr;
import com.mySTARS.Control.SystemMgr;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.Entities.IndexDetail;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.SystemBackend;

public class AdminScreen {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void enterAdmin(StaffAccount staffAcc) {
//		"1. Edit student access period\n" +
//	 	"2. Add a student (name, matric number, gender, nationality, etc)\n" +
//		"3. Add a course (course code, school, its index numbers and vacancy)\n" +
//		"4. Update a course (course code, school, its index numbers and vacancy)\n" +
//		"5. Check available slot for an index number (vacancy in a class)\n" +
//		"6. Print student list by index number\n" +
//		"7. Print student list by course (all students registered for the selected course)\n" +\
//		"8. Print full course list"
//		"9. Quit");
		int sel;
		boolean toLogout = false;
		
		do {
			displayAdminMenu();
			sel = GenericBoundary.readIntInputFromUser();
			switch (sel) {
				case 1:
					System.out.println("[Editing Access Period]");
					String startAccess = null;
					String endAccess = null;
					System.out.print("Please enter start of access date (Format: yyyy-MM-dd) ");
					startAccess = scanner.nextLine().trim();
					System.out.print("Please enter start of access time (Format: HH:mm:ss) ");
					startAccess += " at " + scanner.nextLine().trim();
					System.out.print("Please enter end of access date (Format: yyyy-MM-dd) ");
					endAccess = scanner.nextLine().trim();
					System.out.print("Please enter end of access time (Format: HH:mm:ss) ");
					endAccess += " at " + scanner.nextLine().trim();
					SystemMgr.editAccessPeriod(startAccess, endAccess);
					break;
				case 2:
					System.out.println("[Adding Student]");
					String login = null;
					String password = null;
					String email = null;
					String name = null;
					String gender = null;
					String nationality = null;
					String matricNo = null;
					// Read in data for StudentAccount
					login = GenericBoundary.readStringInputUPPER("Enter new loginID: ");
					// Verify login is unique
					while (AdminMgr.ifLoginClash(login)) {
						login = GenericBoundary.readStringInputUPPER("LoginID taken. Enter another loginID: ");
					}
					password = GenericBoundary.readStringInputCaseSensitive("Enter new password: ");
					email = GenericBoundary.readStringInputUPPER("Enter student email: ");
					// Read in data for Student Info
					name = GenericBoundary.readStringInputUPPER("Enter student name: ");
					gender = GenericBoundary.readStringInputUPPER("Enter student gender: ");
					nationality = GenericBoundary.readStringInputUPPER("Enter student nationality: ");
					matricNo = GenericBoundary.readStringInputUPPER("Enter student matriculationNo: ");
					
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
					System.out.println("[Adding new Course]");
					String courseCode = null;
					String courseName = null;
					int courseUnits = 0;
					SCHOOL schoolName = null;
					// Read in data for Course and make an empty course here.
					courseCode = GenericBoundary.readStringInputUPPER("Enter new course code: ");
					while (AdminMgr.ifCourseCodeClash(courseCode)) {
						courseCode = GenericBoundary.readStringInputUPPER("Course code taken. Enter another course code: ");
					}
					courseName = GenericBoundary.readStringInputUPPER("Enter new course name: ");
					courseUnits = GenericBoundary.readPositiveIntInputFromUser("Enter course units: ");
					schoolName = GenericBoundary.readSchool();
					AdminMgr.addCourse(
							courseCode,
							courseName,
							courseUnits,
							schoolName);
					System.out.println("Added new course.");
					break;
				case 4:			
					System.out.println("[Updating Course]");
					AdminMgr.enterUpdateScreen(staffAcc);
					break;
				case 5:
					System.out.println("[Checking available slots in class]");
					int indexReading5 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to check vacancies");
					int vacancies = AdminMgr.checkVacancies(indexReading5);
					if (vacancies < 0) {
						System.out.println("Error. Index not found.");
					} else {
						System.out.println("Vacancies for Course [" + indexReading5 + "] : " + vacancies);
					}
					break;
				case 6:
					System.out.println("[Printing student list by index number]");
					int indexReading6 = GenericBoundary.readPositiveIntInputFromUser("Please enter course index to print list by: ");
					String formatByIndex = AdminMgr.getStudentList(indexReading6);
					System.out.println("List of student taking index number: [" + indexReading6 +"]");
					System.out.println(formatByIndex);
					break;
				case 7:
					System.out.println("[Printing student list by course]");
					System.out.println("Print student list by course");
					String courseNameFilter = GenericBoundary.readStringInputUPPER("Please enter course to print list by: ");
					String formatByCourse = AdminMgr.getStudentList(courseNameFilter);
					System.out.println("List of student taking course: [" + courseNameFilter +"]");
					System.out.println(formatByCourse);
					break;
				case 8:
					printCourseList();
					break;
				case 9:
					toLogout = true;
					break;
				default:
					System.out.println("Invalid choice, try again");
				}
		} while (!toLogout);
	}
	
	public static void displayAdminMenu() {
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
	
	public static void printCourseList() {
		System.out.println("Here are the list of courses");
		System.out.println("============================================================");
		System.out.println(SystemMgr.getGeneralCourseList());
		System.out.println("============================================================");
	}
}

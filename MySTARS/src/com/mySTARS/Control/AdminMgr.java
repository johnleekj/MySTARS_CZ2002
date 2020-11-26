package com.mySTARS.Control;

import java.util.ArrayList;

import com.mySTARS.Boundary.UpdateCourseScreen;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.Entities.Account;
import com.mySTARS.Entities.Course;
import com.mySTARS.Entities.IndexDetail;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.StudentAccount;
import com.mySTARS.Entities.SystemBackend;
/**
 * Admin manager class that handling of Admin objects
 *
 */
public class AdminMgr {

	/**
	* @param (addStudentAccounts) (Calls StudentAccount class to carry out implementation of adding students
	*/
	public static void addStudentAccounts(
			Account adminAccount,
			String login,
			String password,
			String email,
			String name,
			String gender,
			String nationality,
			String matricNo
			) {

		/*
		* (if (adminAccount.isAdmin())) (Checks if the user has admin rights)
		*/
		System.out.println(adminAccount.getAccountRights());
		if (adminAccount.isAdmin()) {
			/*
			* (StudentAccount.makeAccount()) (Loads new student data using StudentAccount class)
			* (SystemBackend.addStudentAccounts(account)) (Adds data into database stored in SystemBackend class)
			*/
			StudentAccount account = StudentAccount.makeAccount(login, password, email, name, gender, nationality, matricNo);
			SystemBackend.addStudentAccounts(account);
		} else {
			System.out.println("Error! You do not have admin rights to insert account!");
		}
	}
	
	/**
	 * method to add courses to the database of courses
	 * @param courseCode course code to add
	 * @param courseName course name to add
	 * @param courseUnits course units to add
	 * @param schoolName course school name to add
	 * @return integer value that indicates success of action
	 */
	public static int addCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName) {
		/*
		* (if (SystemBackend.checkCourseExist(courseCode))) (Checks if the course exists based on whether the courseCode is available in SystemBackend database)
		*/
		if (SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		/*
		* (Course.makeCourse()) (Loads new course data using Course class)
		* (SystemBackend.addCourse(newCourse)) (Adds data into database stored in SystemBackend class)
		*/
		Course newCourse = Course.makeCourse(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
		SystemBackend.addCourse(newCourse);
		return 0;
	}
	/**
	 *	method to drop courses to the database of courses
	 * @param courseCode course code to add
	 * @param courseName course name to add
	 * @param courseUnits course units to add
	 * @param schoolName course school name to add
	 * @return integer value that indicates success of action
	 */
	public static int updateCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName) {
		/*
		* (if (!SystemBackend.checkCourseExist(courseCode))) (Checks if the course exists based on whether the courseCode is available in SystemBackend database)
		*/
		if (!SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		return 0;
	}
	/**
	 * Brings admin to changes menu if admin chooses to update course, option 4 of admin display screen
	 * @param staffAcc admin account required to access update course interactions
	 */
	public static void enterUpdateScreen(StaffAccount staffAcc) {
		/*
		* Brings admin to changes menu if admin chooses to update course, option 4 of admin display screen
		*/
		UpdateCourseScreen.enterUpdateScreen(staffAcc);
	}
	/**
	 * Checks against SystemBackend if the login done by user is valid
	 * @param login login by the user
	 * @return
	 */
	public static boolean ifLoginClash(String login) {
		/*
		* Checks against SystemBackend if the login done by user is valid
		*/
		boolean exist = SystemBackend.checkLoginExist(login);
		return exist;
	}
	/**
	 * Checks against SystemBackend if the course is valid
	 * @param courseCode course code to be checked
	 * @return boolean that indicates if there is a clash
	 */
	public static boolean ifCourseCodeClash(String courseCode) {
		/*
		* Checks against SystemBackend if the course is valid
		*/
		boolean hasClash = SystemBackend.checkCodeClash(courseCode);
		return hasClash;
	}
	/**
	 * Checks with SystemBackend class for index number vacancies
	 * @param indexReading index of course which vacancies are to be checked
	 * @return integer value of how many vacancies there are
	 */
	public static int checkVacancies(int indexReading) {
		/*
		* Checks with SystemBackend class for index number vacancies
		*/
		int vacancies = SystemBackend.getClassVacancies(indexReading);
		return vacancies;
	}
	/**
	 * Gets list of students from database in SystemBackend class, based on index number
	 * @param indexReading6 index of course to check students enrolled
	 * @return List of students by index
	 */
	public static String getStudentList(int indexReading6) {
		/*
		* Gets list of students from database in SystemBackend class, based on index number
		*/
		String string = SystemBackend.getFormattedStudentListIndex(indexReading6);
		return string;
	}
	/**
	 * Gets list of students from database in SystemBackend class, based on course
	 * @param courseNameFilter
	 * @return List of students by course name
	 */
	public static String getStudentList(String courseNameFilter) {
		/**
		* Gets list of students from database in SystemBackend class, based on course
		*/
		String string = SystemBackend.getFormattedStudentListCourse(courseNameFilter);
		return string;
	}
	
	

}

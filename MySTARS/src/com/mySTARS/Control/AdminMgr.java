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

		/**
		* @param (if (adminAccount.isAdmin())) (Checks if the user has admin rights)
		*/
		System.out.println(adminAccount.getAccountRights());
		if (adminAccount.isAdmin()) {
			/**
			* @param (StudentAccount.makeAccount()) (Loads new student data using StudentAccount class)
			* @param (SystemBackend.addStudentAccounts(account)) (Adds data into database stored in SystemBackend class)
			*/
			StudentAccount account = StudentAccount.makeAccount(login, password, email, name, gender, nationality, matricNo);
			SystemBackend.addStudentAccounts(account);
		} else {
			System.out.println("Error! You do not have admin rights to insert account!");
		}
	}

	public static int addCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName) {
		/**
		* @param (if (SystemBackend.checkCourseExist(courseCode))) (Checks if the course exists based on whether the courseCode is available in SystemBackend database)
		*/
		if (SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		/**
		* @param (Course.makeCourse()) (Loads new course data using Course class)
		* @param (SystemBackend.addCourse(newCourse)) (Adds data into database stored in SystemBackend class)
		*/
		Course newCourse = Course.makeCourse(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
		SystemBackend.addCourse(newCourse);
		return 0;
	}
	
	public static int updateCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName) {
		/**
		* @param (if (!SystemBackend.checkCourseExist(courseCode))) (Checks if the course exists based on whether the courseCode is available in SystemBackend database)
		*/
		if (!SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		return 0;
	}

	public static void enterUpdateScreen(StaffAccount staffAcc) {
		/**
		* @param Brings admin to changes menu if admin chooses to update course, option 4 of admin display screen
		*/
		UpdateCourseScreen.enterUpdateScreen(staffAcc);
	}

	public static boolean ifLoginClash(String login) {
		/**
		* @param Checks against SystemBackend if the login done by user is valid
		*/
		boolean exist = SystemBackend.checkLoginExist(login);
		return exist;
	}

	public static boolean ifCourseCodeClash(String courseCode) {
		/**
		* @param Checks against SystemBackend if the course is valid
		*/
		boolean hasClash = SystemBackend.checkCodeClash(courseCode);
		return hasClash;
	}

	public static int checkVacancies(int indexReading) {
		/**
		* @param Checks with SystemBackend class for index number vacancies
		*/
		int vacancies = SystemBackend.getClassVacancies(indexReading);
		return vacancies;
	}

	public static String getStudentList(int indexReading6) {
		/**
		* @param Gets list of students from database in SystemBackend class, based on index number
		*/
		String string = SystemBackend.getFormattedStudentListIndex(indexReading6);
		return string;
	}

	public static String getStudentList(String courseNameFilter) {
		/**
		* @param Gets list of students from database in SystemBackend class, based on course
		*/
		String string = SystemBackend.getFormattedStudentListCourse(courseNameFilter);
		return string;
	}
	
	

}

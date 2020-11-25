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

	// Adding Student Accounts should be under admin controller
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

		// Check admins rights first.
		System.out.println(adminAccount.getAccountRights());
		if (adminAccount.isAdmin()) {
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
		if (SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		Course newCourse = Course.makeCourse(courseCode, courseName, courseUnits, schoolName, new ArrayList<IndexDetail>());
		SystemBackend.addCourse(newCourse);
		return 0;
	}
	
	public static int updateCourse(
			String courseCode,
			String courseName,
			int courseUnits,
			SCHOOL schoolName) {
		if (!SystemBackend.checkCourseExist(courseCode)) {
			return -1;
		}
		return 0;
	}

	public static void enterUpdateScreen(StaffAccount staffAcc) {
		UpdateCourseScreen.enterUpdateScreen(staffAcc);
	}

	public static boolean ifLoginClash(String login) {
		boolean exist = SystemBackend.checkLoginExist(login);
		return exist;
	}

	public static boolean ifCourseCodeClash(String courseCode) {
		boolean hasClash = SystemBackend.checkCodeClash(courseCode);
		return hasClash;
	}

	public static int checkVacancies(int indexReading) {
		int vacancies = SystemBackend.getClassVacancies(indexReading);
		return vacancies;
	}

	public static String getStudentList(int indexReading6) {
		String string = SystemBackend.getFormattedStudentListIndex(indexReading6);
		return string;
	}

	public static String getStudentList(String courseNameFilter) {
		String string = SystemBackend.getFormattedStudentListCourse(courseNameFilter);
		return string;
	}
	
	

}

package com.mySTARS.Control;

import java.text.ParseException;

import com.mySTARS.Boundary.*;
import com.mySTARS.Entities.*;

public class SystemMgr {

	public static void enterAdmin(StaffAccount staffAccount) {
		/**
		* @param Allows admin to view admin display menu once he / she has logged in successfully
		*/
		AdminScreen.enterAdmin(staffAccount);
	}
	
	public static void enterUser(StudentAccount studentAccount) {
		/**
		* @param Allows student to view student display menu once he / she has logged in successfully
		*/
		UserScreen.enterStudent(studentAccount);
	}
	
	public static void editAccessPeriod(String startAccess, String endAccess) {
		/**
		* @param Allows admin to edit access period via accessing SystemBackend class
		*/
		SystemBackend.editAccessPeriod(startAccess, endAccess);
	}

	public static boolean getAccess() throws ParseException {
		/**
		* @param Ensures SystemBackend class is accessible
		*/
		return SystemBackend.isAccessible();
	}

	public static String getAccessDate() {
		/**
		* @param Gets access date for MySTARS from SystemBackend class
		*/
		return SystemBackend.getAccessDate();
	}

	public static String getGeneralCourseList() {
		/**
		* @param Gets course list from SystemBackend class
		*/
		return SystemBackend.getGeneralCourseList();
	}

}

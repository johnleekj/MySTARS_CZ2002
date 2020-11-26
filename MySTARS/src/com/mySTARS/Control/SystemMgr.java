package com.mySTARS.Control;

import java.text.ParseException;

import com.mySTARS.Boundary.*;
import com.mySTARS.Entities.*;
/**
 * manages interactions between the boundaries and the system
 */
public class SystemMgr {
	/**
	 * Allows admin to view admin display menu once he / she has logged in successfully
	 * @param staffAccount admin account required
	 */
	public static void enterAdmin(StaffAccount staffAccount) {
		AdminScreen.enterAdmin(staffAccount);
	}
	/**
	 * Allows student to view student display menu once he / she has logged in successfully
	 * @param studentAccount student account required
	 */
	public static void enterUser(StudentAccount studentAccount) {
		UserScreen.enterStudent(studentAccount);
	}
	/**
	 * admin to edit access period via accessing SystemBackend class
	 * @param startAccess start access period to allow students to enter the system
	 * @param endAccess end access period to allow students to enter the system
	 */
	public static void editAccessPeriod(String startAccess, String endAccess) {
		SystemBackend.editAccessPeriod(startAccess, endAccess);
	}
	/**
	 * SystemBackend class is accessible
	 * @return
	 * @throws ParseException
	 */
	public static boolean getAccess() throws ParseException {
		return SystemBackend.isAccessible();
	}
	/**
	 * Gets access date for MySTARS from SystemBackend class
	 * @return
	 */
	public static String getAccessDate() {
		return SystemBackend.getAccessDate();
	}
	/**
	 * Gets course list from SystemBackend class
	 * @return
	 */
	public static String getGeneralCourseList() {
		return SystemBackend.getGeneralCourseList();
	}

}

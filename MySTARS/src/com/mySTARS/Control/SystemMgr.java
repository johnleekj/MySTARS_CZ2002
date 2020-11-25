package com.mySTARS.Control;

import java.text.ParseException;

import com.mySTARS.Boundary.*;
import com.mySTARS.Entities.*;

public class SystemMgr {

	public static void enterAdmin(StaffAccount staffAccount) {
		AdminScreen.enterAdmin(staffAccount);
	}
	
	public static void enterUser(StudentAccount studentAccount) {
		UserScreen.enterStudent(studentAccount);
	}
	
	public static void editAccessPeriod(String startAccess, String endAccess) {
		SystemBackend.editAccessPeriod(startAccess, endAccess);
	}

	public static boolean getAccess() throws ParseException {
		return SystemBackend.isAccessible();
	}

	public static String getAccessDate() {
		return SystemBackend.getAccessDate();
	}

	public static String getGeneralCourseList() {
		return SystemBackend.getGeneralCourseList();
	}

}

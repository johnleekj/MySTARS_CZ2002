package com.mySTARS.Control;

import com.mySTARS.Boundary.*;
import com.mySTARS.Entities.*;

public class AccountMgr {
	
	// Account Retrieval: Check if account is valid or not in the SystemBackend
	
	// For student
	public static StudentAccount getStudentAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StudentAccount temp = SystemBackend.retrieveStudentRecord(loginID, password);
		return temp;
	}
	
	// For staff
	public static StaffAccount getStaffAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StaffAccount temp = SystemBackend.retrieveStaffRecord(loginID, password);
		return temp;
	}

}

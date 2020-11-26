package com.mySTARS.Control;

import com.mySTARS.Boundary.*;
import com.mySTARS.Entities.*;
/**
 * Manages account retrieval and backend checking.
 */
public class AccountMgr {
	
	/*
	* Account retrieval is done here, checks against SystemBackend if the account is available
	*/
	
	/**
	* @param Student account checked
	*/
	public static StudentAccount getStudentAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StudentAccount temp = SystemBackend.retrieveStudentRecord(loginID, password);
		return temp;
	}
	
	/**
	* @param Staff account checked
	*/
	public static StaffAccount getStaffAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StaffAccount temp = SystemBackend.retrieveStaffRecord(loginID, password);
		return temp;
	}

}

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
	 * obtains student account from database
	 * @param loginID login id of student
	 * @param password password of student
	 * @return returns a student account
	 */
	public static StudentAccount getStudentAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StudentAccount temp = SystemBackend.retrieveStudentRecord(loginID, password);
		return temp;
	}
	
	/**
	 * 
	 * obtains staff account from database
	 * @param loginID login id of staff
	 * @param password password of staff
	 * @return returns a staff account
	 */
	public static StaffAccount getStaffAccount(
			String loginID, // Read in UPPERCASE
			String password) {
		
		StaffAccount temp = SystemBackend.retrieveStaffRecord(loginID, password);
		return temp;
	}

}

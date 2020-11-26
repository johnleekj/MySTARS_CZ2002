package com.mySTARS.Entities;

import com.mySTARS.ENUMS.DOMAIN;

/*
 * Holds information of staff account and also staff information.
 * Inherits Account class.
 */

public class StaffAccount extends Account {
	
	// Stores Staff Information in staff account.
	private StaffInformation staffInfo; 
	
	
	/**
	 * Constructor for StaffAccount.
	 * 	
	 * @param loginID The username used to access an account that is registered under MySTARS
	 * @param hashedPassword The password that is tagged respectively under the respective account.
	 * @param email The email address that is tagged respectively under the respective account
	 * @param staffInfo contains the staffInfo object. 
	 */
	public StaffAccount(String loginID, String hashedPassword, String email, StaffInformation staffInfo) {
		super(loginID, hashedPassword, email);
		this.staffInfo = staffInfo;
		this.setAccountRights(DOMAIN.ADMIN);
	}
	
	/**
	 * Returns more details of staff account.
	 * 
	 * @return returns staff information of current staff account.
	 */
	public StaffInformation getStaffInfo() {
		return this.staffInfo;
	}
	
}
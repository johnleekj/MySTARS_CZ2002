package com.mySTARS.Entities;

import com.mySTARS.ENUMS.DOMAIN;

public class StaffAccount extends Account {
	
	private StaffInformation staffInfo; // Stores Staff Information in account
	
	public StaffAccount(String loginID, String hashedPassword, String email, StaffInformation staffInfo) {
		super(loginID, hashedPassword, email);
		this.staffInfo = staffInfo;
		this.setAccountRights(DOMAIN.ADMIN);
	}
	
	public StaffInformation getStaffInfo() {
		return this.staffInfo;
	}
	
}
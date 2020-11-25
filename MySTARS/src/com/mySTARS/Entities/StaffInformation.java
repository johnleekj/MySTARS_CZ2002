package com.mySTARS.Entities;

public class StaffInformation extends PersonInformation {

	private String staffID;

	public StaffInformation(String name, String gender, String nationality, String staffID) {
		super(name, gender, nationality);
		this.staffID = staffID;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

}
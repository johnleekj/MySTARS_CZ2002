package com.mySTARS.Entities;

/**
 * Holds information about a staff. 
 * Inherits PersonalInformation
 * 
 */
public class StaffInformation extends PersonInformation {

	private String staffID;

	/**
	 * Constructor for making a staff information.
	 *  
	 * Takes in the basic information of a staff and makes a staff.
	 * 
	 * @param name Name of staff
	 * @param gender Gender of staff 
	 * @param nationality Nationality of staff
	 * @param staffID Staff Id of staff
	 */
	public StaffInformation(String name, String gender, String nationality, String staffID) {
		super(name, gender, nationality);
		this.staffID = staffID;
	}

	/**
	 * Get the staff ID.
	 * 
	 * @return return staff ID of staff.
	 */
	public String getStaffID() {
		return staffID;
	}

	/**
	 * Change the current staffID for the current staff
	 * 
	 * @param staffID The updated staff ID
	 */
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

}
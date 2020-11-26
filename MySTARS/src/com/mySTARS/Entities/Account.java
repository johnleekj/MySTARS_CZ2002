package com.mySTARS.Entities;

import java.io.Serializable;

import com.mySTARS.ENUMS.DOMAIN;


/**
 * 
 * Account class to define as a parent class for the child classes to inherit from.
 * See: StudentAccount, StaffAcount
 */

public class Account implements Serializable  {

	
	private static final long serialVersionUID = -5867458402425868826L;
	private String loginID;
	private String password; 
	private DOMAIN accountRights = DOMAIN.USER; // User Mode by default
	private String email;

	/**
	 * Constructor for making Account. Takes in the basic details of an account and return a valid Account object
	 * 
	 * @param loginID The username used to access an account that is registered under MySTARS
	 * @param password The password that is tagged respectively under the respective account.
	 * @param email The email address that is tagged respectively under the respective account
	 */
	public Account(String loginID, String password, String email) {
		this.loginID = loginID.toUpperCase();
		this.password = password;
		this.email = email;
	}
	
	/**
	 * Formats the relevant details of the account to a custom string format:
	 * 
	 * [Format]
	 * Login ID :
	 * Rights:
	 */

	@Override
	public String toString() {
		return "Login ID: " + loginID + "\nRights: " + this.accountRights;
	}

	/**
	 * Returns account rights of current account
	 * 
	 * @return return ADMIN or USER
	 */
	public DOMAIN getAccountRights() {
		return this.accountRights;
	}
	
	/**
	 * Set accounts rights based on specified settings
	 * 
	 * @param accountRights possible DOMAIN: USER or ADMIN
	 */
	public void setAccountRights(DOMAIN accountRights) {
		this.accountRights = accountRights;
	}

	/**
	 * Retrieve login details of current account
	 * 
	 * @return Return loginID of current account
	 */
	public String getLoginID() {
		return this.loginID;
	}
	
	/**
	 * Retrieve email details of current account
	 * 
	 * @return Return email of current account.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * Set email details of current account
	 * 
	 * @param email Sets the email of the current account based on the specified email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

	/**
	 * Set account rights for current account.
	 * 
	 * @return	Return account rights based on specified DOMAIN: USER or ADMIN
	 */
	public boolean isAdmin() {
		if (this.accountRights == DOMAIN.ADMIN) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the account can be access given the login credentials.
	 * 
	 * @param loginID The username used to access an account that is registered under MySTARS
	 * @param hashedPassword The password that is tagged respectively under the respective account.
	 * @return Return a boolean that states whether the account can be accessed with the respective loginID and password credentials.
	 */
	public boolean checkLoginValid(String loginID,  String hashedPassword) {
		boolean loginMatch = loginID.equalsIgnoreCase(this.loginID);
		boolean passwordMatch = hashedPassword.equals(this.password);
		if (loginMatch && passwordMatch){
			return true; 
		}
		else {
			return false;
		}
	}
}

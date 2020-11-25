package com.mySTARS.Entities;

import java.io.Serializable;

import com.mySTARS.ENUMS.DOMAIN;

public class Account implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5867458402425868826L;
	private String loginID;
	private String password; 
	private DOMAIN accountRights = DOMAIN.USER; // User Mode by default
	private String email;

	
	public Account(String loginID, String password, String email) {
		this.loginID = loginID.toUpperCase();
		this.password = password;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Login ID: " + loginID + "\nRights: " + this.accountRights;
	}

	public DOMAIN getAccountRights() {
		return this.accountRights;
	}
	
	public void setAccountRights(DOMAIN accountRights) {
		this.accountRights = accountRights;
	}

	public String getLoginID() {
		return this.loginID;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// This is to return account rights for further processing like printing menus
	public boolean isAdmin() {
		if (this.accountRights == DOMAIN.ADMIN) {
			return true;
		} else {
			return false;
		}
	}

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

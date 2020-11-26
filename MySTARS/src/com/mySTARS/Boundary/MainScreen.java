package com.mySTARS.Boundary;

import com.mySTARS.Control.*;
import com.mySTARS.Entities.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainScreen {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/**
		* @param (FileMgr.readAll()) (SystemBackEnd to load files)
		* @param (System.out.println("[ Welcome to mySTARS! ]")) (Start of Program - What users see)
		*/
		FileMgr.readAll();
		System.out.println(	"[ Welcome to mySTARS! ]");
		
		int sel;
		boolean quit = false;
		do {
			MainScreen.printMenuOptions();
			sel = GenericBoundary.readIntInputFromUser();
			String username;
			String password;
			switch (sel) {
				case 1:
					/**
					* @param Student login
					*/
					System.out.println(	"[ Student Login ]");
					username = EncryptionMgr.readUsername();
					/**
					* @param (password = readPassword()) (reading in the password that user inputs)
					*/
					password = EncryptionMgr.readPassword();
					StudentAccount studentAccount = AccountMgr.getStudentAccount(username, password);
					if (studentAccount == null) {
						continue;
					}
					/**
					* @param (boolean canAccess = false) (If the student account does not exist, entry is refused)
					*/
					boolean canAccess = false;
					try {
						canAccess = SystemMgr.getAccess();
					} catch (ParseException e) {
						System.out.println("Parse Error! Check time format");
					}
					/**
					* @param (SystemMgr.getAccessDate()) (If the login is successful, the current time is checked against the access period that is allowed by admin)
					*/
					if (canAccess) {
						SystemMgr.enterUser(studentAccount);
					} else {
						System.out.println("Current Date and Time: " + DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss").format(LocalDateTime.now()));  
						System.out.println("Sorry you can only access the course registration system between these dates: ");
						System.out.println(SystemMgr.getAccessDate());
					}
										
					break;
				case 2:
					/**
					* @param Staff login
					*/
					System.out.println(	"[ Staff Login ]");
					/**
					* @param (password = readPassword()) (reading in the password that user inputs)
					*/
					username = EncryptionMgr.readUsername();
					password = EncryptionMgr.readPassword();
					StaffAccount staffAccount = AccountMgr.getStaffAccount(username, password);
					/**
					* @param (staffAccount == null) (If the staff account does not exist, entry is refused)
					*/
					if (staffAccount == null) {
						continue;
					}
					SystemMgr.enterAdmin(staffAccount);
					break;
				case 3:
					/**
					* @param To exit program
					*/
					System.out.println("Updating changes to databases...");
					System.out.println("Thank you for using mySTARS!");
					/**
					* @param (FileMgr.saveAll();) (Saving of file is carried out here)
					*/
					FileMgr.saveAll();
					System.out.println("Done!");
					System.out.println("Quiting mySTARS now...");
					quit = true;
					break;
				default:
					/**
					* @param Default case that is activated should the user input not be an integer type within the given cases
					*/
					System.out.println("Invalid input, try again");
				}
		} while (!quit);
		
	}
	
	public static void printMenuOptions() {
		/**
		* @param Main Menu that users see upon entering MySTARS
		*/
		System.out.println("Please make your choice:");
		System.out.println("1. Student Login");
		System.out.println("2. Staff Login");
		System.out.println("3. Quit");
	}
}

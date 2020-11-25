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
		
		// Use SystemBackEnd to load files
		FileMgr.readAll();
		// Start of Program (What users see)
		System.out.println(	"[ Welcome to mySTARS ]");
		
		int sel;
		boolean quit = false;
		do {
			MainScreen.printMenuOptions();
			sel = GenericBoundary.readIntInputFromUser();
			String username;
			String password;
			switch (sel) {
				case 1:
					System.out.println(	"[ Student Login ]");
					username = readUsername();
					password = readPassword();
					StudentAccount studentAccount = AccountMgr.getStudentAccount(username, password);
					if (studentAccount == null) {
						continue;
					}
					boolean canAccess = false;
					try {
						canAccess = SystemMgr.getAccess();
					} catch (ParseException e) {
						System.out.println("Parse Error! Check time format");
					}
					if (canAccess) {
						SystemMgr.enterUser(studentAccount);
					} else {
						System.out.println("Current Date and Time: " + DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss").format(LocalDateTime.now()));  
						System.out.println("Sorry you can only access the course registration system between these dates: ");
						System.out.println(SystemMgr.getAccessDate());
					}
										
					break;
				case 2:
					System.out.println(	"[ Staff Login ]");
					username = readUsername();
					password = readPassword();
					StaffAccount staffAccount = AccountMgr.getStaffAccount(username, password);
					if (staffAccount == null) {
						continue;
					}
					SystemMgr.enterAdmin(staffAccount);
					break;
				case 3:
					System.out.println("Updating changes to databases...");
					System.out.println("Thank you for using mySTARS!");
					// Perform saving of file here.
					FileMgr.saveAll();
					System.out.println("Done!");
					System.out.println("Quiting mySTARS now...");
					quit = true;
					break;
				default:
					System.out.println("Invalid input, try again");
				}
		} while (!quit);
		
	}
	
	public static void printMenuOptions() {
		System.out.println("Please make your choice:");
		System.out.println("1. Student Login");
		System.out.println("2. Staff Login");
		System.out.println("3. Quit");
	}
	
	
	public static String readUsername() {
	System.out.println("Enter username:");
	String username = scanner.nextLine().trim().toUpperCase();
	return username;
	}

	public static String readPassword() {
	System.out.println("Enter password:");
	String password = scanner.nextLine().trim();
	return password;
	}
	
	
}

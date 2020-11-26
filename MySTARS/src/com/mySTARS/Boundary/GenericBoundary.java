package com.mySTARS.Boundary;

import java.util.Scanner;
import com.mySTARS.ENUMS.*;

public class GenericBoundary {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static int readIntInputFromUser() {
		int sel;		
		// Check if next input is integer
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid integer choice!");
			scanner.nextLine(); // To clear input buffer.
		}
		// Read in integer into sel

		sel = scanner.nextInt();
		scanner.nextLine();
		return sel;
	}
	
	public static String readStringInputUPPER(String onScreenMessage) {
		System.out.print(onScreenMessage);
		String input = scanner.nextLine().trim().toUpperCase();
		return input;
	}
	
	public static String readStringInputCaseSensitive(String onScreenMessage) {
		System.out.print(onScreenMessage);
		String input = scanner.nextLine().trim();
		return input;
	}

	public static int readIntInputFromUser(String string) {
		System.out.println(string);
		int sel;		
		// Check if next input is integer
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid integer choice!");
			scanner.nextLine(); // To clear input buffer.
		}
		// Read in integer into sel

		sel = scanner.nextInt();
		scanner.nextLine();
		return sel;
	}
	
	public static int readPositiveIntInputFromUser(String string) {
		System.out.println(string);
		int sel;		
		// Check if next input is integer
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a valid integer choice!");
				scanner.nextLine(); // To clear input buffer.
			}
			// Read in integer into sel
	
			sel = scanner.nextInt();
			scanner.nextLine();
			if (sel <= 0) {
				System.out.println("Please enter positive integers only (at least 1).");
			}
		} while (sel <= 0);
		return sel;
	}

	public static SCHOOL readSchool() {
		
		SCHOOL querySchool = null;
		do {
			System.out.print("Please enter name of school: ");
			String school = scanner.nextLine().trim();
			
			for (SCHOOL currentEnum : SCHOOL.values()) {
				if (currentEnum.toString().equalsIgnoreCase(school)) {
					querySchool = currentEnum;
					return querySchool;
				}
			} 
			System.out.println("Invalid school. Please enter again");
		} while (querySchool == null);
		return querySchool; // Dummy return will never reach
	}
	
	public static DAY readDay() {
		int sel;
		DAY queryDay = null;
		do {
			sel = GenericBoundary.readIntInputFromUser("Please select a day: \n"
					+ "1: Monday\n"
					+ "2: Tuesday\n"
					+ "3: Wednesday\n"
					+ "4: Thursday\n"
					+ "5: Friday\n");
			String day = null;
			switch (sel) {
			case 1:
				day = "MON";
				break;
			case 2:
				day = "TUE";
				break;
			case 3:
				day = "WED";
				break;
			case 4:
				day = "THU";
				break;
			case 5:
				day = "FRI";
				break;
			default:
				System.out.println("Invalid input, please try again");
			}
			
			for (DAY currentEnum : DAY.values()) {
				if (currentEnum.toString().equalsIgnoreCase(day)) {
					queryDay = currentEnum;
					return queryDay;
				}
			}
		} while (queryDay == null);
		return queryDay; // Dummy return will never reach
	}
	
	public static WEEK readWeek() {
		WEEK queryWeek = null;
		do {
			System.out.print("Please enter week type (odd, even, both): ");
			String school = scanner.nextLine().trim();
			
			for (WEEK currentEnum : WEEK.values()) {
				if (currentEnum.toString().equalsIgnoreCase(school)) {
					queryWeek = currentEnum;
					return queryWeek;
				}
			}
		} while (queryWeek == null);
		return queryWeek; // Dummy return will never reach
	}
}

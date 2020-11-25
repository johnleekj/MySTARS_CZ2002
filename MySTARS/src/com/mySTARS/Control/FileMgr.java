package com.mySTARS.Control;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import com.mySTARS.Entities.SystemBackend;

public class FileMgr {
	
	public static void printFile(String fileName) {
		try {
			Scanner scStream = new Scanner(new File(fileName));
			String inputLine;
			System.out.println("The file contains: ");
			if (scStream.hasNext()) {
				scStream.nextLine(); // used to skip to next line if there is no input in the file
			}
			while(scStream.hasNext()) {
				inputLine = scStream.nextLine(); // to be used in the system
				System.out.println(inputLine);
			}
			scStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Error!" + e.getMessage());
			System.exit(0);
		} catch (@SuppressWarnings("hiding") IOException e) {
			System.out.println("IO Error!" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void saveAll() {
		SerializationMgr.serializeMap((HashMap) SystemBackend.StudentAccountMap, "studentData.mystars");
		SerializationMgr.serializeMap((HashMap) SystemBackend.StaffAccountMap, "staffData.mystars");
		SerializationMgr.serializeMap((HashMap) SystemBackend.CourseMap, "courseData.mystars");
	}

	public static void readAll() {
		SystemBackend.StudentAccountMap =	SerializationMgr.deserializeMap("studentData.mystars");
		SystemBackend.StaffAccountMap 	= 	SerializationMgr.deserializeMap("staffData.mystars");
		SystemBackend.CourseMap 		=	SerializationMgr.deserializeMap("courseData.mystars");
	}

		


}

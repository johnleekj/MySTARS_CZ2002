package com.mySTARS.Control;

import java.util.ArrayList;

import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.Entities.Account;
import com.mySTARS.Entities.IndexDetail;

public class CourseMgr {

	
//	public static void addCourse(Account account) {
//		Course newCourse;
//		ArrayList<IndexDetail> detailsList = new ArrayList<IndexDetail>();
//		String courseCode;
//		String courseName;
//		int courseUnits;
//		SCHOOL school;
//		ArrayList<Integer> indexList;
//		int capacity;
//		DAY day;
//		String type;
//		String group;
//		String[] startAndEndTime;
//		String location;
//		WEEK lessonWeek;
//		String remarks;
//		
//		if (account.getAccountRights() != DOMAIN.ADMIN) {
//			System.out.println("Error! You do not have permission");
//		} else {
//			courseCode = readCourseCode();
//			if (SystemMgr.CourseMap.containsKey(courseCode)) {
//				System.out.print("Error. Course already exists. Please update the course instead.");
//				return;
//			}
//			courseName = readCourseName();
//			courseUnits = readCourseUnits();
//			school = readSchool();
//			indexList = readIndexes();
//			// Initialize newCourse
//			newCourse = new Course(courseCode, courseName, courseUnits, school, indexList);
//			SystemMgr.CourseMap.put(courseCode, newCourse); // Add to courseMap
//			
//			// Initialize IndexDetail
//			for (int i=0; i<indexList.size(); i++) {
//					capacity = readCapacity(indexList.get(i));
//					int currentIndex = indexList.get(i);
//					detailsList.add(new IndexDetail(currentIndex,capacity, new ArrayList<Lesson>(), new ArrayList<String>()));
//				}	
//			
//			// Need to read in lesson for each index
//			for (int i=0; i<detailsList.size(); i++) {
//				IndexDetail currentDetail = detailsList.get(i);
//				System.out.println("Adding lessons for index: " + currentDetail.getIndex());
//				System.out.println("How many lessons to add for this index?: ");
//				while (!scanner.hasNextInt()) {
//					System.out.println("Please enter a valid integer!");
//					scanner.nextLine(); // To clear input buffer.
//				}
//				int noOfLessons = scanner.nextInt();
//				for (int j=0; j < noOfLessons; j++) {
//					day = readDay();
//					type = readType();
//					group = readGroup();
//					startAndEndTime = readStartTime();
//					location = readLocation();
//					lessonWeek = readLessonWeek();
//					remarks = readRemarks();
//					Lesson newLesson = new Lesson(day, type, group, location, lessonWeek, remarks, startAndEndTime[0], startAndEndTime[1]);
//					// Add lessons but check for conflict
//					for (Lesson lesson : currentDetail.getLessonList()) {
//						if (!lesson.hasConflicts(newLesson)) {
//							currentDetail.addLesson(newLesson);
//						} else {
//							System.out.println("Lesson has time conflict. Please check and retry!");
//							return; // Terminate addition
//						}
//					}	
//				}	
//			}	
//		}
//	}
//
//	public static void updateCourse(Account account) {
//		int sel;
//		boolean toLogout = false;
//		String courseCode;
//
//		if (account.getAccountRights() != DOMAIN.ADMIN) {
//			System.out.println("Error! You do not have permission");
//		} else {
//			courseCode = readCourseCode();
//			if (!SystemMgr.CourseMap.containsKey(courseCode)) {
//				System.out.print("Error. Course does not exist. Please create the course instead.");
//				return;
//			} else { 
//				do {
//					CourseMgr.displayChangesMenu(account.getLoginID());
//					sel = SystemMgr.readIntInputFromUser();
//					switch (sel) {
//					case 1:
//						System.out.println("Change Course Code");
//						break;
//					case 2:
//						System.out.println("Change Course School");
//						break;
//					case 3:
//						System.out.println("Change Index Number of Course");
//						break;
//					case 4:
//						System.out.println("Change Course Vacancy");
//						break;
//					case 5:
//						toLogout = true;
//						break;
//					default:
//						System.out.println("Invalid choice, try again");
//					}
//				}	while (!toLogout);
//			}
//		}
//	}
//
	

	
	
	

}

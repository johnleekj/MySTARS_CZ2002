package com.mySTARS.Control;

public class NotificationMgr {
	
	/**
	* @param Email notification that is sent to student once course has been successfully added
	*/
	public static void SuccessfulAddCourse(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Add Course";
		String body = "MySTARS has succesfully added the course index: " + index;
		
		sendEmail.sendmail(contact, subject, body);		
	}
	
	/**
	* @param Email notification that is sent to student once course has been successfully dropped
	*/
	public static void SuccesfulDropCourse(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Drop Course";
		String body = "MySTARS has succesfully dropped the course index: " + index;
		
		sendEmail.sendmail(contact, subject, body);			
	}
	
	/**
	* @param Email notification that is sent to student once index number has been successfully changed
	*/
	public static void IndexChange(String contact, int indexReadingOld, int indexReadingNew) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Change course";
		String body = "MySTARS has succesfully swapped your index from index " + indexReadingOld + "to index " + indexReadingNew;
		
		sendEmail.sendmail(contact, subject, body);			
	}

	/**
	* @param Email notification that is sent to student once course has been successfully assigned and student is removed from waitlist
	*/
	public static void GetCourseFromWaitList(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS WaitList Update";
		String body = "MySTARS has succesfully assigned you a slot for your index" + index; 
		
		sendEmail.sendmail(contact, subject, body);		
	}
	
	/**
	* @param Email notification that is sent to student once student has been successfully added to waitlist for course
	*/
	public static void AddCourseToWaitList(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS WaitList Update";
		String body = "MySTARS has currently placed you on the wait list for the index " + index; 
		sendEmail.sendmail(contact, subject, body);		
	}
}

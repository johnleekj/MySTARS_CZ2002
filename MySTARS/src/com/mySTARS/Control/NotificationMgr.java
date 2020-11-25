package com.mySTARS.Control;

public class NotificationMgr {
	
	public static void SuccessfulAddCourse(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Add Course";
		String body = "MySTARS has succesfully added the course index: " + index;
		
		sendEmail.sendmail(contact, subject, body);		
	}
	
	public static void SuccesfulDropCourse(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Drop Course";
		String body = "MySTARS has succesfully dropped the course index: " + index;
		
		sendEmail.sendmail(contact, subject, body);			
	}
	
	public static void IndexChange(String contact, int indexReadingOld, int indexReadingNew) {
		System.out.println("Sending Notification");
		String subject = "MySTARS Change course";
		String body = "MySTARS has succesfully swapped your index from index " + indexReadingOld + "to index " + indexReadingNew;
		
		sendEmail.sendmail(contact, subject, body);			
	}

	public static void GetCourseFromWaitList(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS WaitList Update";
		String body = "MySTARS has succesfully assigned you a slot for your index" + index; 
		
		sendEmail.sendmail(contact, subject, body);		
	}
	
	public static void AddCourseToWaitList(String contact, int index) {
		System.out.println("Sending Notification");
		String subject = "MySTARS WaitList Update";
		String body = "MySTARS has currently placed you on the wait list for the index " + index; 
		sendEmail.sendmail(contact, subject, body);		
	}
}

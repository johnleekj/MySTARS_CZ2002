package com.mySTARS.Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.mySTARS.Control.AdminMgr;
import com.mySTARS.Control.FileMgr;
import com.mySTARS.Control.NotificationMgr;
import com.mySTARS.Control.UserMgr;
import com.mySTARS.ENUMS.SCHOOL;
import com.mySTARS.ENUMS.WEEK;
import com.mySTARS.ENUMS.DAY;


public class SystemBackend {

	// Format : "yyyy.MM.dd G 'at' HH:mm:ss"
	private static String accessDateStart = "2020-11-01 at 00:00:00";
	private static String accessDateEnd = "2020-12-24 at 23:59:59";

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Key, Object : loginID, StudentAccount
	public static Map<String, StudentAccount> StudentAccountMap = new HashMap<>();

	// Key, Object : loginID, StaffAccount
	public static Map<String, StaffAccount> StaffAccountMap = new HashMap<>(); 

	// Key, Object : courseCode, Course
	public static Map<String, Course> CourseMap = new HashMap<>();
	

	public static void uploadStaffData() {
		//		LOGIN_ID, HASH_PASSWORD, EMAIL, STAFF_ID, NAME, GENDER, NATIONALITY
		//		BOB_ADMIN, Admin@CSC, bob@e.ntu.edu.sg, S001, BOB, M, SINGAPOREAN
		//		TOM_ADMIN, TheGreatTom, tom@e.ntu.edu.sg, S002, TOM, M, MALAYSIAN
		//		ADMIN, ADMIN, admin@e.ntu.edu.sg, ADMIN, M, SINGAPOREAM
		
		StaffInformation staff_bob = new StaffInformation("BOB", "M", "SINGAPOREAN", "S001");
		StaffAccount bob_account = new StaffAccount("BOB_ADMIN", "Admin@CSC", "bob@e.ntu.edu.sg", staff_bob);
		StaffAccountMap.put(bob_account.getLoginID(), bob_account);
		
		StaffInformation staff_tom = new StaffInformation("TOM", "M", "MALAYSIAN", "S002");
		StaffAccount tom_account = new StaffAccount("TOM_ADMIN", "TheGreatTom", "tom@e.ntu.edu.sg", staff_tom);
		StaffAccountMap.put(tom_account.getLoginID(), tom_account);
		
		StaffInformation staff_admin = new StaffInformation("admin", "M", "SINGAPOREAN", "S003");
		StaffAccount admin_account = new StaffAccount("ADMIN", "admin", "admin@e.ntu.edu.sg", staff_admin);
		StaffAccountMap.put(admin_account.getLoginID(), admin_account);
		
	}
	
	public static void uploadStudentData() {
		//		LOGIN_ID, HASH_PASSWORD, EMAIL, STAFF_ID, NAME, GENDER, NATIONALITY
		//		JORGE_NTU, apple123, JORGE01A@E.NTU.EDU.SG, U001, JORGE, M, SINGAPOREAN
		//		MAGALY_NTU, gummybear, MAGALY02B@E.NTU.EDU.SG, U002, MAGALY, F, SINGAPOREAN

		StudentInformation student_jorge = new StudentInformation("JORGE", "M", "SINGAPOREAN", "U001");
		StudentAccount jorge_account = 	new StudentAccount("JORGE_NTU", "123", "JORGE01A@e.ntu.edu.sg", student_jorge,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());

		StudentInformation student_magaly = new StudentInformation("MAGALY", "F", "SINGAPOREAN", "U002");
		StudentAccount magaly_account = new StudentAccount("MAGALY_NTU", "123", "MAGALY02B@e.ntu.edu.sg", student_magaly,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_rey = new StudentInformation("REY", "M", "MALAYSIAN", "U003");
		StudentAccount rey_account = 	new StudentAccount("REY_NTU", "123", "REY03C@e.ntu.edu.sg", student_rey,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_pennie = new StudentInformation("PENNIE", "F", "SINGAPOREAN", "U004");
		StudentAccount pennie_account = new StudentAccount("PENNIE_NTU", "123", "PENNIE04D@e.ntu.edu.sg", student_pennie,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_rubi = new StudentInformation("RUBI", "F", "AUSTRALIAN", "U005");
		StudentAccount rubi_account = new StudentAccount("RUBI_NTU", "123", "RUBI05E@e.ntu.edu.sg", student_rubi,
									  new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_lakeshia = new StudentInformation("LAKESHIA", "F", "MALAYSIAN", "U006");
		StudentAccount lakeshia_account = new StudentAccount("LAKESHIA_NTU", "123", "LAKESHIA06F@e.ntu.edu.sg", student_lakeshia,
										  new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_harland = new StudentInformation("HARLAND", "M", "SINGAPOREAN", "U007");
		StudentAccount harland_account = 	new StudentAccount("HARLAND_NTU", "123", "HARLAND07G@e.ntu.edu.sg", student_harland,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());		
		
		StudentInformation student_deane = new StudentInformation("DEANE", "F", "SINGAPOREAN", "U008");
		StudentAccount deane_account =  new StudentAccount("DEANE_NTU", "123", "DEANE08H@e.ntu.edu.sg", student_deane,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_brittaney = new StudentInformation("BRITTANEY", "F", "SINGAPOREAN", "U009");
		StudentAccount brittaney_account = new StudentAccount("BRITTANEY_NTU", "123", "BRITTANEY09I@e.ntu.edu.sg", student_brittaney,
										   new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_darryl = new StudentInformation("DARRYL", "M", "SINGAPOREAN", "U010");
		StudentAccount darryl_account = new StudentAccount("DARRYL_NTU", "123", "DARRYL10J@e.ntu.edu.sg", student_darryl,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_suzan = new StudentInformation("SUZAN", "F", "AUSTRALIAN", "U011");
		StudentAccount suzan_account = new StudentAccount("SUZAN_NTU", "123", "UZAN11K@e.ntu.edu.sg", student_suzan,
									   new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_lawrence = new StudentInformation("LAWRENCE", "M", "SINGAPOREAN", "U012");
		StudentAccount lawrence_account = 	new StudentAccount("LAWRENCE_NTU", "123", "LAWRENCE12L@e.ntu.edu.sg", student_lawrence,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_glendora = new StudentInformation("GLENDORA", "F", "SINGAPOREAN", "U013");
		StudentAccount glendora_account = 	new StudentAccount("GLENDORA_NTU", "123", "GLENDORA13M@e.ntu.edu.sg", student_glendora,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_dexter = new StudentInformation("DEXTER", "M", "MALAYSIAN", "U014");
		StudentAccount dexter_account = new StudentAccount("DEXTER_NTU", "123", "DEXTER14N@e.ntu.edu.sg", student_dexter,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_amos = new StudentInformation("AMOS", "M", "SINGAPOREAN", "U015");
		StudentAccount amos_account = 	new StudentAccount("AMOS_NTU", "123", "AMOS15O@e.ntu.edu.sg", student_amos,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_corliss = new StudentInformation("CORLISS", "F", "AUSTRALIAN", "U016");
		StudentAccount corliss_account = 	new StudentAccount("CORLISS_NTU", "123", "CORLISS16P@e.ntu.edu.sg", student_corliss,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_sharlene = new StudentInformation("SHARLENE", "F", "SINGAPOREAN", "U017");
		StudentAccount sharlene_account = 	new StudentAccount("SHARLENE_NTU", "123", "SHARLENE17Q@e.ntu.edu.sg", student_sharlene,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_madonna = new StudentInformation("MADONNA", "F", "MALAYSIAN", "U018");
		StudentAccount madonna_account = 	new StudentAccount("MADONNA_NTU", "123", "MADONNA18R@e.ntu.edu.sg", student_madonna,
											new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_ching = new StudentInformation("CHING", "F", "AUSTRALIAN", "U019");
		StudentAccount ching_account = 	new StudentAccount("CHING_NTU", "123", "CHING19S@e.ntu.edu.sg", student_ching,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());
		
		StudentInformation student_kevin = new StudentInformation("KEVIN", "M", "SINGAPOREAN", "U020");
		StudentAccount kevin_account = 	new StudentAccount("KEVIN_NTU", "123", "KEVIN20T@e.ntu.edu.sg", student_kevin,
										new ArrayList<Integer>(),new ArrayList<Integer>(),new ArrayList<Integer>());

		StudentAccountMap.put(jorge_account.getLoginID(), jorge_account);
		StudentAccountMap.put(magaly_account.getLoginID(), magaly_account);
		StudentAccountMap.put(rey_account.getLoginID(), rey_account);
		StudentAccountMap.put(pennie_account.getLoginID(), pennie_account);
		StudentAccountMap.put(rubi_account.getLoginID(), rubi_account);
		StudentAccountMap.put(lakeshia_account.getLoginID(), lakeshia_account);
		StudentAccountMap.put(harland_account.getLoginID(), harland_account);
		StudentAccountMap.put(deane_account.getLoginID(), deane_account);
		StudentAccountMap.put(brittaney_account.getLoginID(), brittaney_account);
		StudentAccountMap.put(darryl_account.getLoginID(), darryl_account);
		StudentAccountMap.put(suzan_account.getLoginID(), suzan_account);
		StudentAccountMap.put(lawrence_account.getLoginID(), lawrence_account);
		StudentAccountMap.put(glendora_account.getLoginID(), glendora_account);
		StudentAccountMap.put(dexter_account.getLoginID(), dexter_account);
		StudentAccountMap.put(amos_account.getLoginID(), amos_account);
		StudentAccountMap.put(corliss_account.getLoginID(), corliss_account);
		StudentAccountMap.put(sharlene_account.getLoginID(), sharlene_account);
		StudentAccountMap.put(madonna_account.getLoginID(), madonna_account);
		StudentAccountMap.put(ching_account.getLoginID(), ching_account);
		StudentAccountMap.put(kevin_account.getLoginID(), kevin_account);
	}
	
	public static void uploadCourseData() {
		AdminMgr.addCourse("CZ2001", "ALGORITHM", 3, SCHOOL.SCSE);
		AdminMgr.addCourse("CZ2002", "OBJECT ORIENTED DESIGN & PROGRAMMING", 3, SCHOOL.SCSE);
		AdminMgr.addCourse("CZ2003", "COMPUTER GRAPHICS & VISUALISATION", 3, SCHOOL.SCSE);
		AdminMgr.addCourse("CZ2004", "HUMAN COMPUTER INTERACTION", 3, SCHOOL.SCSE);
		AdminMgr.addCourse("CZ2005", "OPERATING SYSTEMS", 3, SCHOOL.SCSE);

		Course cz2001 = CourseMap.get("CZ2001");
		Course cz2002 = CourseMap.get("CZ2002");
		Course cz2003 = CourseMap.get("CZ2003");
		Course cz2004 = CourseMap.get("CZ2004");
		Course cz2005 = CourseMap.get("CZ2005");
		
		cz2001.addNewIndexDetail(10182, 10);
		cz2001.addNewIndexDetail(10183, 10);
		cz2001.addNewIndexDetail(10184, 10);
		
		cz2002.addNewIndexDetail(10198, 10);
		cz2002.addNewIndexDetail(10199, 10);
		cz2002.addNewIndexDetail(10200, 10);
		
		cz2003.addNewIndexDetail(10210, 10);
		cz2003.addNewIndexDetail(10211, 10);
		cz2003.addNewIndexDetail(10212, 10);
		
		cz2004.addNewIndexDetail(10217, 10);
		cz2004.addNewIndexDetail(10218, 10);
		cz2004.addNewIndexDetail(10219, 10);
		
		cz2005.addNewIndexDetail(10229, 10);
		cz2005.addNewIndexDetail(10230, 10);
		cz2005.addNewIndexDetail(10231, 10);
		
		
		Lesson a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-", "1030", "1130");
		Lesson b = new Lesson(DAY.MON, "LEC/STUDIO" , "CS2" , "ONLINE" , WEEK.BOTH , "-" , "1230", "1330");
		Lesson c = new Lesson(DAY.WED, "TUT" , "DSAI1" , "TR+37" , WEEK.BOTH , "Teaching Wk2-13" , "1130" , "1230");
		Lesson d = new Lesson(DAY.THU, "LAB", "DSAI1", "HWLAB2", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "1030", "1230");
		cz2001.addLesson(10182, a);
		cz2001.addLesson(10182, b);
		cz2001.addLesson(10182, c);
		cz2001.addLesson(10182, d);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-", "1030", "1130");
		b = new Lesson(DAY.MON, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-", "1230", "1330");
		c = new Lesson(DAY.WED, "TUT", "DSAI2", "TR+37", WEEK.BOTH, "Teaching Wk2-13", "1230", "1330");
		d = new Lesson(DAY.THU, "LAB", "DSAI2", "HWLAB2", WEEK.EVEN, "Teaching Wk2,4,6,8,10,12", "1030", "1230");
		cz2001.addLesson(10183, a);
		cz2001.addLesson(10183, b);
		cz2001.addLesson(10183, c);
		cz2001.addLesson(10183, d);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-", "1030", "1130");
		b = new Lesson(DAY.MON, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-", "1230", "1330");
		c = new Lesson(DAY.WED, "TUT", "SS1", "TR+9", WEEK.BOTH, "Teaching Wk2-13", "0930", "1030");
		d = new Lesson(DAY.THU, "LAB", "SS1", "HWLAB2", WEEK.EVEN, "Teaching Wk2,4,6,8,10,12", "1430", "1630");
		cz2001.addLesson(10184, a);
		cz2001.addLesson(10184, b);
		cz2001.addLesson(10184, c);
		cz2001.addLesson(10184, d);
		
		a = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1130", "1230");
		c = new Lesson(DAY.MON, "TUT", "DSAI1", "TR+33", WEEK.BOTH, "Teaching Wk2-13", "1130", "1230");
		d = new Lesson(DAY.MON, "LAB", "DSAI1", "SPL", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "0830", "1030");
		cz2002.addLesson(10198, a);
		cz2002.addLesson(10198, b);
		cz2002.addLesson(10198, c);
		cz2002.addLesson(10198, d);
		
		a = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1130", "1230");
		c = new Lesson(DAY.MON, "TUT", "DSAI2", "TR+9", WEEK.BOTH, "Teaching Wk2-13", "1330", "1430");
		d = new Lesson(DAY.MON, "LAB", "DSAI2", "SPL", WEEK.EVEN, "Teaching Wk2,4,6,8,10,12", "0830", "1030");
		cz2002.addLesson(10199, a);
		cz2002.addLesson(10199, b);
		cz2002.addLesson(10199, c);
		cz2002.addLesson(10199, d);
		
		a = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1130", "1230");
		c = new Lesson(DAY.MON, "TUT", "SS10", "LHN-TR+17", WEEK.BOTH, "Teaching Wk2-13", "0930", "1030");
		d = new Lesson(DAY.FRI, "LAB", "SS10", "SPL", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "1230", "1430");
		cz2002.addLesson(10200, a);
		cz2002.addLesson(10200, b);
		cz2002.addLesson(10200, c);
		cz2002.addLesson(10200, d);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1430", "1530");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		cz2003.addLesson(10210, a);
		cz2003.addLesson(10210, b);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1430", "1530");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		cz2003.addLesson(10211, a);
		cz2003.addLesson(10211, b);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1430", "1530");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		cz2003.addLesson(10212, a);
		cz2003.addLesson(10212, b);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1630", "1730");
		c = new Lesson(DAY.THU, "TUT", "DSAI1", "TR+33", WEEK.BOTH, "Teaching Wk2-13", "1630", "1730");
		d = new Lesson(DAY.TUE, "LAB", "DSAI1", "HWLAB1", WEEK.EVEN, "Teaching Wk2,4,6,8,10,12", "1430", "1630");
		cz2004.addLesson(10217, a);
		cz2004.addLesson(10217, b);
		cz2004.addLesson(10217, c);
		cz2004.addLesson(10217, d);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1630", "1730");
		c = new Lesson(DAY.THU, "TUT", "DSAI2", "TR+33", WEEK.BOTH, "Teaching Wk2-13", "1530", "1630");
		d = new Lesson(DAY.TUE, "LAB", "DSAI2", "HWLAB1", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "1430", "1630");
		cz2004.addLesson(10218, a);
		cz2004.addLesson(10218, b);
		cz2004.addLesson(10218, c);
		cz2004.addLesson(10218, d);
		
		a = new Lesson(DAY.FRI, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1530", "1630");
		b = new Lesson(DAY.TUE, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1630", "1730");
		c = new Lesson(DAY.MON, "TUT", "SS1", "TR+15", WEEK.BOTH, "Teaching Wk2-13", "1130", "1230");
		d = new Lesson(DAY.MON, "LAB", "SS1", "HWLAB1", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "0830", "1030");
		cz2004.addLesson(10219, a);
		cz2004.addLesson(10219, b);
		cz2004.addLesson(10219, c);
		cz2004.addLesson(10219, d);
		
		a = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1030", "1130");
		c = new Lesson(DAY.TUE, "TUT", "SS1", "TR+15", WEEK.BOTH, "Teaching Wk2-13", "0830", "0930");
		d = new Lesson(DAY.MON, "LAB", "SS1", "SWLAB1", WEEK.EVEN, "Teaching Wk2,4,6,8,10,12", "1030", "1230");
		cz2005.addLesson(10229, a);
		cz2005.addLesson(10229, b);
		cz2005.addLesson(10229, c);
		cz2005.addLesson(10229, d);
		
		a = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1030", "1130");
		c = new Lesson(DAY.MON, "TUT", "SS2", "TR+17", WEEK.BOTH, "Teaching Wk2-13", "1030", "1130");
		d = new Lesson(DAY.MON, "LAB", "SS2", "SWLAB1", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "0830", "1030");
		cz2005.addLesson(10230, a);
		cz2005.addLesson(10230, b);
		cz2005.addLesson(10230, c);
		cz2005.addLesson(10230, d);
		
		a = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1030", "1130");
		c = new Lesson(DAY.TUE, "TUT", "SS3", "TR+19", WEEK.BOTH, "Teaching Wk2-13", "1330", "1430");
		d = new Lesson(DAY.THU, "LAB", "SS3", "SWLAB3", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "1430", "1630");
		cz2005.addLesson(10231, a);
		cz2005.addLesson(10231, b);
		cz2005.addLesson(10231, c);
		cz2005.addLesson(10231, d);
		
		// Load Course into students 
		a = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "0930", "1030");
		b = new Lesson(DAY.THU, "LEC/STUDIO", "CS2", "ONLINE", WEEK.BOTH, "-" , "1030", "1130");
		c = new Lesson(DAY.TUE, "TUT", "SS3", "TR+19", WEEK.BOTH, "Teaching Wk2-13", "1330", "1430");
		d = new Lesson(DAY.THU, "LAB", "SS3", "SWLAB3", WEEK.ODD, "Teaching Wk1,3,5,7,9,11,13", "1430", "1630");
		cz2005.addLesson(10231, a);
		cz2005.addLesson(10231, b);
		cz2005.addLesson(10231, c);
		cz2005.addLesson(10231, d);

		// MADONNA
		StudentAccount madonna = StudentAccountMap.get("MADONNA_NTU");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10185);
		temp.add(10231);
		temp.add(10229); // CZ2005
		temp.add(10218); // CZ2004
		madonna.setCourseHistory(temp);
		
		// CHING
		StudentAccount ching = StudentAccountMap.get("CHING_NTU");
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(10482);
		temp2.add(10199); // CZ2002
		temp2.add(10217); // CZ2004
		temp2.add(10244);
		ching.setCourseHistory(temp2);
		
		// KEVIN
		StudentAccount kevin = StudentAccountMap.get("KEVIN_NTU");
		ArrayList<Integer> temp3 = new ArrayList<Integer>();
		temp3.add(10184); // CZ2001
		temp3.add(10242);
		temp3.add(10218); // CZ2004
		temp3.add(10490);
		kevin.setCourseHistory(temp3);
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// General
	public static StudentAccount retrieveStudentRecord(String loginID, String password) {
	
		StudentAccount temp = StudentAccountMap.get(loginID);
		
		if (temp != null) {
			if (temp.checkLoginValid(loginID, password)) {
				System.out.println("Login successful.");
				return temp;
			} else {
				System.out.println("Login failed");
				return null; // Cannot login so no account is returned.
			}
		} else {
			System.out.println("No account found."); 
			return null; 
		}
	}
	
	public static StaffAccount retrieveStaffRecord(String loginID, String password) {
		
		StaffAccount temp =  StaffAccountMap.get(loginID);
		
		if (temp != null) {
			if (temp.checkLoginValid(loginID, password)) {
				System.out.println("Login successful.");
				return temp;
			} else {
				System.out.println("Login failed");
				return null; // Cannot login so no account is returned.
			}
		} else {
			System.out.println("No account found."); 
			return null; 
		}
	}

	
	
	// Admin Case 1:
	
	public static boolean isAccessible() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
		Calendar currentCal = GregorianCalendar.getInstance();
		Calendar accessStart = GregorianCalendar.getInstance();
		Calendar accessEnd = GregorianCalendar.getInstance();
		String dateTimenow = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss").format(LocalDateTime.now());
		currentCal.setTime(sdf.parse(dateTimenow));
		accessStart.setTime(sdf.parse(accessDateStart));
		accessEnd.setTime(sdf.parse(accessDateEnd));

		// Checking time
		if ((currentCal.compareTo(accessStart) >= 0) && (currentCal.compareTo(accessEnd) <= 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void editAccessPeriod(String startAccess, String endAccess) {
		accessDateStart = startAccess;
		accessDateEnd = endAccess;
	}

	public static String getAccessDate() {
		return accessDateStart + " to " + accessDateEnd;
	}
	
	// Admin case 1 (add course)
	
	public static boolean checkMatchingCourseCode(ArrayList<Course> courseList, Course queryCourse) {
		for (Course course : courseList) {
			if (course.getCourseCode().equalsIgnoreCase(queryCourse.getCourseCode())) {
				return true;
			}
		}
		return false;
	}
	
	// Admin Case 2 (Made by StudentAccount)
	
	public static boolean checkCodeClash(String courseCode) {
		if (CourseMap.containsKey(courseCode)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkCourseExist(String courseCode) {
		for (Course course : CourseMap.values()) {
			if (course.getCourseCode() == courseCode) {
				return true;
			}
		}
		return false;
	}

	public static void addCourse(Course newCourse) {
		CourseMap.put(newCourse.getCourseCode().toUpperCase(), newCourse);
	}


	
	// Admin Case 4: Update Course
	
	public static String updateCourseCode(String oldCourseCode, String updatedCourseCode) {
		// check if name already exists
		for (Course course: CourseMap.values()) {
			if (course.getCourseCode().equals(updatedCourseCode)) {
				System.out.println("New course code name already exists, course code not changed.");
				return oldCourseCode;
			}
		}
		
		
		// change name
		Course oldCourse = null;
		Course updatedCourse = null;
		for (Course course : CourseMap.values()) {
			if (course.getCourseCode().equals(oldCourseCode)) {
				oldCourse = course;
//				course.setCourseName(updatedCourseCode);
				updatedCourse = course;
				System.out.println("Course code name succesfully changed");	
			}
		}
		
		// Update Course Map
		CourseMap.remove(oldCourse.getCourseCode(), oldCourse);
		CourseMap.put(updatedCourse.getCourseCode(), updatedCourse);
		
		return updatedCourseCode;
	}
	
	
	public static void updateCourseSchool(String currentCourseCode, SCHOOL updatedCourseSchool) {
		for (Course course : CourseMap.values()) {
			if (course.getCourseCode().equals(currentCourseCode)) {
				course.setSchoolName(updatedCourseSchool);
			}
		}
	}
	
	public static void updateIndexCapacity(String currentCourseCode, int index, int updateValue) {
		for (IndexDetail details : getCourse(currentCourseCode).getIndexDetail()) {
			if (details.getIndex() == index) {
				details.setCapacity(updateValue);
			}
		}
	}
	
	public static void addLessonToExistingIndex(String currentCourseCode, int index,
			DAY day, String type, String group, String location, WEEK lessonWeeks, String remarks, String startTime, String endTime) {
		
		Lesson toAdd = new Lesson(day, type, group, location, lessonWeeks, remarks , startTime, endTime);
		getCourse(currentCourseCode).addLesson(index, toAdd);
		System.out.println(getCourse(currentCourseCode));
	}
	
	
	//////////////
	
	// [ADMIN]
	public static boolean checkLoginExist(String login) {
		if (StudentAccountMap.containsKey(login)) {
			return true;
		} else {
			return false;
		}
	}

	
	// [ADMIN AND USER]
	public static int getClassVacancies(int indexReading) {
		int vacancies = -1;
		for (Course course : CourseMap.values()) {
			for (IndexDetail details : course.getIndexDetail()) {
				if (details.getIndex() == indexReading) {
					vacancies = details.getVacancy();
					return vacancies;
				}
			}
		}
		return vacancies;
	}
	
	// [ADMIN]
	public static String getFormattedStudentListIndex(int indexReading6) {
		ArrayList<StudentAccount> collated = new ArrayList<StudentAccount>();
		for (StudentAccount student : StudentAccountMap.values()) {
			ArrayList<Integer> studentRegCourses = student.getListCoursesRegistered();
			if (studentRegCourses.contains(indexReading6)) {
				collated.add(student);
			}
		}
		String customString = customStringFormat1(collated);
		return customString;
	}
	
	// [ADMIN]
	public static String getFormattedStudentListCourse(String courseNameFilter) {
		ArrayList<Integer> collatedIndexes = new ArrayList<Integer>();	
		for (Course course : CourseMap.values()) {
			if (course.getCourseCode().equalsIgnoreCase(courseNameFilter)) {
				for (IndexDetail detail : course.getIndexDetail()) {
					collatedIndexes.add(detail.getIndex());
				}
			}
		}
		
		ArrayList<StudentAccount> collatedStudents = new ArrayList<StudentAccount>();
		for (int index : collatedIndexes) {
			for (StudentAccount student : StudentAccountMap.values()) {
				ArrayList<Integer> studentRegCourses = student.getListCoursesRegistered();
				if (studentRegCourses.contains(index)) {
					collatedStudents.add(student);
				}
			}
		}
		
		String customString = customStringFormat1(collatedStudents);
		return customString;
	}

	// [ADMIN]
	private static String customStringFormat1(ArrayList<StudentAccount> collated) {
		StringBuilder sb = new StringBuilder();
		int listCount = 1; // Increment by 1.
		for (StudentAccount student : collated) {
			StudentInformation info = student.getStudentInfo();
			sb.append(	listCount + ") Name: " + info.getName() + " | Gender: " + info.getGender() +
				 " | Matriculation No: " + info.getMatricNo() + "\n");
			listCount++;
		}
		String formatted = sb.toString();
		return formatted;
	}
	
	// [USER]
	public static void addCourseForStudent(int index, StudentAccount account) {
		
		// Confirm addition of courses
		for (Course course : CourseMap.values()) {
			for (IndexDetail detail : course.getIndexDetail()) {
				if (detail.getIndex() == index) {
					// Add index to inside StudentAccount
					account.addToRegisteredCourse(detail.getIndex());
					// Update IndexDetail class at the same time
					detail.addCurrentEnrolled();
				}
			}
		}
	}
	
	public static void addCourseWaitListForStudent(int index, StudentAccount account) {
		
		// Confirm addition of courses
		for (Course course : CourseMap.values()) {
			for (IndexDetail detail : course.getIndexDetail()) {
				if (detail.getIndex() == index) {
					// Add index to inside StudentAccount WaitList
					account.addToWaitList(detail.getIndex());
					// Update IndexDetail class at the same time - adding to waitlist
					detail.addIdToWaitList(account.getLoginID());
					NotificationMgr.AddCourseToWaitList(account.getEmail(), index);
				}
			}
		}
	}
	
	public static void handlingPopOfWaitList(int index) {
		// Get IndexDetail
		IndexDetail detail = SystemBackend.getIndexDetails(index);
		String loginID = null;
		
		// Check vacancy
		if ((detail.getVacancy() > 0) && (detail.getWaitList().size() > 0)) {
			loginID = detail.popIdOffWaitList();
			detail.addCurrentEnrolled(); // For the pop student to be account on the system
			
			// Get respective account.
			StudentAccount account = SystemBackend.StudentAccountMap.get(loginID);
			account.moveWaitListToRegistered(index);
			
			// Perform notifications 
			NotificationMgr.GetCourseFromWaitList(account.getEmail(), index);
		}
		
		
	}
	
	// [USER]
	public static boolean checkTimingClashes(ArrayList<IndexDetail> currentIndexDetail, IndexDetail newIndexDetail) {
		
		// Check timing clashes 
		for (IndexDetail detail : currentIndexDetail) {
			for ( Lesson lessonA : detail.getLessonList()) {
				for (Lesson lessonB : newIndexDetail.getLessonList()) {
					if (lessonA.hasConflicts(lessonB)) {
					System.out.println("Timing Clash");
					return true;
					}
				}
			}
		}
		return false;
	}
	
	public static ArrayList<Course> retrieveCourseListByIndexList(ArrayList<Integer> indexList){
		ArrayList<Course> listOfCoursesTaken = new ArrayList<Course>();
		for (Integer i : indexList) {
			Course retrievedCourse = SystemBackend.getCourse(i);
			listOfCoursesTaken.add(retrievedCourse);
		}
		return listOfCoursesTaken;
	}
	
	public static boolean indexExistInCourse(Course course, int index) {
		for (IndexDetail details : course.getIndexDetail()) {
			if (details.getIndex() == index) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkTimingClashes(ArrayList<Integer> indexList, int index) {
		// Check timing clashes 
		IndexDetail incomingIndexDetail = null; 
				
		// Get indexDetail list based on index list
		ArrayList<IndexDetail> indexDetailList = new ArrayList<IndexDetail>();
		
		for (Course course : CourseMap.values()) {
			for (IndexDetail detail : course.getIndexDetail()) {
				for (Integer indexInList : indexList ) {
					if (detail.getIndex() == indexInList) {
						indexDetailList.add(detail);
					}
					if (detail.getIndex() == index) {
						incomingIndexDetail = detail;
					}
				}
			}
		}
		
		boolean clash =  checkTimingClashes(indexDetailList, incomingIndexDetail);
		return clash;
	}

		// [USER]
	public static void dropCourse(int index, StudentAccount account) {
		// get course code from index number
		int capacity;
		for (Course course : CourseMap.values()) {
			for (IndexDetail details : course.getIndexDetail()) {
				
				if (details.getIndex() == index) {
					// Remove index from inside StudentAccount
					account.dropFromCoursesRegistered(details.getIndex());
					// Update index details for vacancy
					details.subCurrentEnrolled();
					NotificationMgr.SuccesfulDropCourse(account.getEmail(), index);
				}
			}
		}
	}
	
	
	// [USER]
	private static String generateCourseRegisteredString(ArrayList<IndexDetail> courseList) {
		StringBuilder sb = new StringBuilder();
		int listCount = 1; // Increment by 1.
		for (IndexDetail detail : courseList) {
			sb.append(	listCount + ")" + detail.toString() + "\n");			
			listCount++;
		}
		String formatted = sb.toString();
		return formatted;
	}
	
	// [USER]
	private static ArrayList<IndexDetail> getStudentIndexList(StudentAccount account) {
		// Get the corresponding (currently registered) index details for comparison
		ArrayList<Integer> currentIndexes= account.getListCoursesRegistered();
		ArrayList<IndexDetail> currentIndexDetail = new ArrayList<IndexDetail>();

		for (Integer i : currentIndexes) {
			for (Course course : CourseMap.values()) {
				for (IndexDetail detail : course.getIndexDetail()) {
					if (detail.getIndex() == i) {
						currentIndexDetail.add(detail);
					}
				}
			}
		}
		return currentIndexDetail;
	}
		// [USER]
		private static ArrayList<IndexDetail> getStudentCourseList(StudentAccount account) {
			// Get the corresponding (currently registered) index details for comparison
			ArrayList<Integer> currentIndexes= account.getListCoursesRegistered();
			ArrayList<IndexDetail> currentCourseDetails = new ArrayList<IndexDetail>();
			
			for (Integer i : currentIndexes) {
				for (Course course : CourseMap.values()) {
					for (IndexDetail detail : course.getIndexDetail()) {
						if (detail.getIndex() == i) {
							currentCourseDetails.add(detail);
//							currentCourseDetails.add(course);
						}
					}
				}
			}
			return currentCourseDetails;

	}
		
		// [USER]
	public static String getCoursesRegisteredString(StudentAccount account) {
		ArrayList<IndexDetail> currentCourseDetails = getStudentCourseList(account);
		String output = generateCourseRegisteredString(currentCourseDetails);		
		return output;
	}
	
	// [USER]
	public static IndexDetail getIndexDetails(int yourIndex) {
		IndexDetail temp = null;
		for (Course course: CourseMap.values()) {
			for (IndexDetail detail : course.getIndexDetail()) {
				if (detail.getIndex() == yourIndex) {
					temp = detail;
				}
			}
		}
		return temp;
	}
	
	// [ADMIN]
	public static void addStudentAccounts(StudentAccount account) {
		StudentAccountMap.put(account.getLoginID().toUpperCase(), account);
		
	}

	// [FROM BOUNDARY]
	public static void addNewCourseIndex(String currentCourseCode, int newCourseIndex, int capacity) {
		Course retreivedCourse = getCourse(currentCourseCode);
		retreivedCourse.addNewIndexDetail(newCourseIndex, capacity);
		System.out.println("Index number has been successfully added.");
	}
	
	// [[FROM BOUNDARY]
	public static void removeCurrentCourseIndex(String currentCourseCode, int currentCourseIndex) {
		getCourse(currentCourseCode).dropIndex(currentCourseIndex);	
	}
	
	// [Intermediate] 	// [[FROM BOUNDARY]
	public static Course getCourse(String courseCode) {
		Course temp = null;
		Collection<Course> courseList = CourseMap.values();
		for (Course course : courseList) {
			if (course.getCourseCode().equals(courseCode)) {
				temp = course;
			}
		}
		return temp;
	}

	// [Intermediate] 	// [[FROM BOUNDARY]
	public static Course getCourse(int index) {
		Course temp = null;
		Collection<Course> courseList = CourseMap.values();
		for (Course course : courseList) {
			for (IndexDetail detail : course.getIndexDetail()) {
				if (detail.getIndex() == index) {
					temp = course;
				}
			}
		}
		return temp;
	}
	
	// [Checks] 	// [[FROM BOUNDARY]
	public static boolean ifIndexClash(String currentCourseCode, int newCourseIndex) {
		Collection<Course> courseList = CourseMap.values();
		for (Course course : courseList) {
			for (IndexDetail detail : course.getIndexDetail()) {
				if (detail.getIndex() == newCourseIndex) {
					return true;
				}
			}
		}
		return false;
	}

	public static String getGeneralCourseList() {
		StringBuilder sb = new StringBuilder();
		for  (Course course : CourseMap.values()) {
			sb.append(course.getCourseCode() + " | " +
					  course.getCourseName() + " | " +
					  course.getCourseUnits()+ " AU | " +
					  course.getSchoolName() + " |\n" +
				      course.getIndexDetail().toString()
									 + "\n");
		}
		return sb.toString();
	}

	public static boolean changeIndex(int indexReadingOld, int indexReadingNew, StudentAccount account) {
		SystemBackend.dropCourse(indexReadingOld, account);
		SystemBackend.addCourseForStudent(indexReadingNew, account);
		NotificationMgr.IndexChange(account.getEmail(), indexReadingOld, indexReadingNew);
		return false;
	}

	


}
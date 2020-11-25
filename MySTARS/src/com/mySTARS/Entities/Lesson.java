package com.mySTARS.Entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mySTARS.ENUMS.DAY;
import com.mySTARS.ENUMS.WEEK;

public class Lesson implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6513187787186719042L;
	private static final String TIME_FORMAT = "HHmm";
	private DAY day; // Refer to enum
	private String type;
	private String group;
	private String location;
	private WEEK lessonWeeks;
	private String remarks;
	private double duration;
	private String startTime;
	private String endTime;

	public Lesson(DAY day, String type, String group, String location, WEEK lessonWeeks, String remarks,
			String startTime, String endTime) {
		
		this.setDay(day);
		this.setType(type);
		this.setGroup(group);
		this.setLocation(location);
		this.setLessonWeeks(lessonWeeks);
		this.setRemarks(remarks);
		this.startTime = startTime; // Assume file input is correct already before calling constructor
		this.endTime = endTime; // Assume file input is correct already before calling constructor
		this.setDuration(startTime, endTime);
	}
	
	@Override
	public String toString() {
		String sep = " | ";
//		return day + " " + this.getStartTime() + "-" + this.getEndTime();
		return 	"Type: " + this.type + sep +
				"Group: " + this.group + sep +
				"Day: " + this.day.toString() + sep +
				"Start-End: " + this.startTime + "-" + this.endTime + sep +
				"Duration: " + this.duration + sep +
				"Lesson Week: " + this.lessonWeeks + sep +
				"Remarks: " + this.remarks;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type.toUpperCase();
	}

	public String getGroup(String group) {
		return this.group.toUpperCase();
	}

	public void setGroup(String group) {
		this.group = group.toUpperCase();
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location.toUpperCase();
	}

	public WEEK getLessonWeeks() {
		return this.lessonWeeks;
	}

	public void setLessonWeeks(WEEK lessonWeeks) {
		this.lessonWeeks = lessonWeeks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks.toUpperCase();
	}	
	
	public DAY getDay() {
		return this.day;
	}

	public void setDay(DAY day) {
		this.day = day;
	}
	
	public double getDuration() {
		return this.duration;
	}

	public void setDuration(String startTime, String endTime) {

		if (checkStartEndValid(startTime, endTime)) {
			try {

				SimpleDateFormat sdf = new SimpleDateFormat("HHmm"); 			
				Calendar start_cal = GregorianCalendar.getInstance();
				start_cal.setTime(sdf.parse(startTime));
				Calendar end_cal = GregorianCalendar.getInstance();
				end_cal.setTime(sdf.parse(endTime));

				long difference = end_cal.getTimeInMillis() - start_cal.getTimeInMillis();
				long diffSeconds = difference / 1000 % 60;  
				long diffMinutes = difference / (60 * 1000) % 60; 
				long diffHours = difference / (60 * 60 * 1000);
				double diffMinutesInHours = (double) diffMinutes / 60;
				double duration = diffHours + diffMinutesInHours;
				this.duration = duration;	
			}
			catch (ParseException e) {
				System.out.println("Timing is in the wrong format");
			}
		} else {
			System.out.println("Start Timing cannot be after End Timing");
		}

	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT); 
		Calendar new_cal = GregorianCalendar.getInstance();
		Calendar current_cal = GregorianCalendar.getInstance();
		try {
			new_cal.setTime(sdf.parse(startTime));
			current_cal.setTime(sdf.parse(this.endTime));
			if (new_cal.compareTo(current_cal) <= 0) { // Means new timing is within end time of current
				this.startTime = startTime;
			}
		} catch (ParseException e) {
			System.out.println("Invalid format given");
		}
	}
	
	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT); 
		Calendar new_cal = GregorianCalendar.getInstance();
		Calendar current_cal = GregorianCalendar.getInstance();
		try {
			new_cal.setTime(sdf.parse(startTime));
			current_cal.setTime(sdf.parse(this.startTime));
			if (new_cal.compareTo(current_cal) >= 0) { // Means new timing is within end time of current
				this.endTime = endTime;
			}
		} catch (ParseException e) {
			System.out.println("Invalid format given");
		}	
	}
	
	
	private boolean checkStartEndValid (String startTime, String endTime) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HHmm"); 			
			Calendar start_cal = GregorianCalendar.getInstance();
			start_cal.setTime(sdf.parse(startTime));
			Calendar end_cal = GregorianCalendar.getInstance();
			end_cal.setTime(sdf.parse(endTime));

			if (start_cal.compareTo(end_cal) <= 0) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			System.out.println("Timing is in the wrong format");
			return false; // Reject by default
		}
	}
	
	
	public boolean hasConflicts(Lesson other) {
		
		try {
			String existingStart = this.startTime;
			String existingEnd = this.endTime;
			String incomingStart = other.getStartTime();
			String incomingEnd = other.getEndTime();
			
			if (checkStartEndValid(existingStart, existingEnd) && checkStartEndValid(incomingStart, incomingEnd)) {
				SimpleDateFormat sdf = new SimpleDateFormat("HHmm"); 			
				Calendar existingStartCal = GregorianCalendar.getInstance();
				Calendar existingEndCal = GregorianCalendar.getInstance();
				Calendar incomingStartCal = GregorianCalendar.getInstance();
				Calendar incomingEndCal = GregorianCalendar.getInstance();
				existingStartCal.setTime(sdf.parse(existingStart));
				existingEndCal.setTime(sdf.parse(existingEnd));
				incomingStartCal.setTime(sdf.parse(incomingStart));
				incomingEndCal.setTime(sdf.parse(incomingEnd));
				
				////// Checking of conflict
				// Check if week clashes -> If got at least 1 lesson timing that is on both even and odd, then need to check for clashes
				if ((this.lessonWeeks != WEEK.BOTH) && ((other.getLessonWeeks() != WEEK.BOTH)) && (this.lessonWeeks!= other.getLessonWeeks())) {
					return false; 
				} else {
					// Cases: (Conflict detected)
					// 1: New lesson start and end within existing
					// 2. New lesson start and end after existing
					// 1-2 => New lesson starts in between start and end time of existing, doesnt matter when it end there is conflict in end
					// 3. New lesson start before but end during
					// 3 => New lesson ends in between start and end time of existingdoesnt matter when it end there is conflict in start
					
					// Edge cases: ( No conflict)
					// 1: New lesson start when currentLesson end 
					// 2: New lesson end as current Lesson start 
					
					// Do edge cases first.
					
					// By this stage we know: 
					// Start < End is valid for both using: checkStartEndValid(existingStart, existingEnd) && checkStartEndValid(incomingStart, incomingEnd)
					
					// If the new lesson end on the dot when the new one starts then it is valid. (Or new start on the end of the old)
					if ((incomingEndCal.compareTo(existingStartCal) == 0) || (existingEndCal.compareTo(incomingStartCal) == 0)) { 
						return false; // No conflict (Edge Cases 1-2)
					} 
					else if ((existingStartCal.compareTo(incomingStartCal) <= 0) && (existingEndCal.compareTo(incomingStartCal) >= 0)) {
						return true; // Conflict exists (Conflict Cases 1-2)
					}
					else if ((existingStartCal.compareTo(incomingEndCal) <= 0) && (existingEndCal.compareTo(incomingEndCal) >= 0)) {
						return true; // Conflict exists (Conflict Cases 3)
					} else {
						return false; // No more conflict
					}
				}
			} else {
				return true; // Return conflict and reject insertion due to time error.
			}
		} catch (ParseException e) {
			System.out.println("Invalid format given");
			return true; // Return conflict and reject due to wrong time format
		}
	}
}
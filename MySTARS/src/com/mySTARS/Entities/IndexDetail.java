package com.mySTARS.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class IndexDetail implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8196269420309238140L;
	private int index;
	private int capacity;
	private int currentEnrolled;
	private ArrayList<Lesson> lessonList;
	private ArrayList<String> waitList;
	
	public IndexDetail(int index, int capacity, ArrayList<Lesson> lessonList, ArrayList<String> waitList) {
		this.index = index;
		this.capacity = capacity;
		this.currentEnrolled = 0;
		this.lessonList = lessonList;
		this.waitList = waitList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		return 	"\nCourse Index: " + this.index + "\n" + 
				"Capacity: " + this.capacity + "\n" +
				"Enrolled Currently: " + this.currentEnrolled + "\n" +
				"Vacancy: " + this.getVacancy() + "\n" + 
				"Lessons: \n" + this.getLessonString() + "\n";
	}
	
	private String getLessonString() {
		String combined = "";
		for (Lesson lesson : this.lessonList) {
			combined += "\t" + lesson.toString() + "\n";
		}
		return combined;
	}

	public int getVacancy() {
		return this.capacity - this.currentEnrolled;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if (capacity < 0) {
			this.capacity = 0;
		} else {
			this.capacity = capacity;
		}
	}

	public int getCurrentEnrolled() {
		return currentEnrolled;
	}

	public void addCurrentEnrolled() {
		this.currentEnrolled++;
	}
	
	public void subCurrentEnrolled() {
		this.currentEnrolled--;
	}

	public ArrayList<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(ArrayList<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	public ArrayList<String> getWaitList() {
		return waitList;
	}

	public String popIdOffWaitList() {
		return this.waitList.remove(0);
	}
	
	public void addIdToWaitList(String loginID) {
		this.waitList.add(loginID);
	}
	
	public void addLesson(Lesson lesson) {
		lessonList.add(lesson);
	}
	
}

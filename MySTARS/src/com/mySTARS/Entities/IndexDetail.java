package com.mySTARS.Entities;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * index detail object containing the details of individual indexes of courses.
 * @author user
 *
 */
public class IndexDetail implements Serializable   {
	
	private static final long serialVersionUID = -8196269420309238140L;
	private int index;
	private int capacity;
	private int currentEnrolled;
	private ArrayList<Lesson> lessonList;
	private ArrayList<String> waitList;
	/**
	 * index detail constructor 
	 * @param index
	 * @param capacity
	 * @param lessonList
	 * @param waitList
	 */
	public IndexDetail(int index, int capacity, ArrayList<Lesson> lessonList, ArrayList<String> waitList) {
		this.index = index;
		this.capacity = capacity;
		this.currentEnrolled = 0;
		this.lessonList = lessonList;
		this.waitList = waitList;
	}
	/**
	 * gives a string of the index details
	 */
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
	/**
	 * get the lessons in index details
	 * @return
	 */
	private String getLessonString() {
		String combined = "";
		for (Lesson lesson : this.lessonList) {
			combined += "\t" + lesson.toString() + "\n";
		}
		return combined;
	}
	/**
	 * get the vacancies in index detail
	 * @return
	 */
	public int getVacancy() {
		return this.capacity - this.currentEnrolled;
	}
	/**
	 * get the index in index detail
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * set the index in index detail
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * get the capacity in index detail
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * set the capacity in index detail
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		if (capacity < 0) {
			this.capacity = 0;
		} else {
			this.capacity = capacity;
		}
	}
	/**
	 * get the currently enrolled in index detail
	 * @return
	 */
	public int getCurrentEnrolled() {
		return currentEnrolled;
	}
	/**
	 * add to the currently enrolled in index detail
	 */
	public void addCurrentEnrolled() {
		this.currentEnrolled++;
	}
	/**
	 * subtract from the currently enrolled in index detail
	 */
	public void subCurrentEnrolled() {
		this.currentEnrolled--;
	}
	/**
	 * get lesson list from index detail
	 * @return
	 */
	public ArrayList<Lesson> getLessonList() {
		return lessonList;
	}
	/**
	 * set lesson list from index detail
	 * @param lessonList
	 */
	public void setLessonList(ArrayList<Lesson> lessonList) {
		this.lessonList = lessonList;
	}
	/**
	 * get wait list from index detail
	 * @return
	 */
	public ArrayList<String> getWaitList() {
		return waitList;
	}
	/**
	 * remove the first person in waitlist in index detail
	 * @return
	 */
	public String popIdOffWaitList() {
		return this.waitList.remove(0);
	}
	/**
	 * add a user into waitlist in index detail
	 * @param loginID
	 */
	public void addIdToWaitList(String loginID) {
		this.waitList.add(loginID);
	}
	/**
	 * Add a lesson into 
	 * @param lesson
	 */
	public void addLesson(Lesson lesson) {
		lessonList.add(lesson);
	}
	
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Day extends Observable {
	 
	/**
	 * the start of the agenda in min, counted from midnight
	 */
	int start;
	int day;
	int month;
	int year;
	
	List<EventActivity> activities = new ArrayList<EventActivity>();
	
	public Day(int hour, int min,int day,int month,int year) {
		start = hour*60 + min;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * get day
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * set day
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
		setChanged();
		notifyObservers("DayChanged");
	}

	/**
	 * get month
	 * @return
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * set Month of a day
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
		setChanged();
		notifyObservers("MonthChanged");
	}

	/**
	 * get the year of the day
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * set the year of the day
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
		setChanged();
		notifyObservers("YearChanged");
	}


	/**
	 * Get Start time of day
	 * @return
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Set Start time on a day
	 * @param start
	 */
	public void setStart(int start) {
		this.start = start;
		setChanged();
		notifyObservers("StartChanged");
	}
	
	/**
	 * get date in a string
	 * @return
	 */
	public String getDateString(){
	
		return  year + "-" + month + "-" + day;
	}

	/**
	 * returns the total length of the acitivities in a day in minutes
	 */
	public int getTotalLength() {
		int result = 0;
		for(EventActivity act:activities) {
			result += act.getLength();
		}
		return result;
	}
	
	public int getEnd() {
		return getStart() + getTotalLength();
	}
	
	
	/**
	 * returns the length (in minutes) of activities of certain type
	 */
	public int getLengthByType(int type) {
		int result = 0;
		for(EventActivity act:activities) {
			if(act.getType() == type) {
				result += act.getLength();
			}
		}
		return result;
	}
	
	/**
	 * adds an activity to specific position
	 * this method will be called when needed from the model
	 * don't call it directly
	 */
	int addActivity(EventActivity act,int position){
		if(position > activities.size()) {
			position = activities.size();
		}
		activities.add(position, act);
		setChanged();
		notifyObservers("ActivityAdded");
		return position;
	}
	/**
	 * check if the time is free for booking 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean checkIfTimeIsEmpty(int startTime,int endTime){
		
		for(EventActivity act: activities){
			if(startTime>act.getStartTime() && startTime<act.getEndTime())
				return false;
			else if(endTime>act.getStartTime() && endTime<act.getEndTime())
				return false;
			else if(startTime<act.getStartTime() && endTime>act.getEndTime())
				return false;
		}
		return true;
	}
	
	/**
	 * removes an activity from specific position
	 * this method will be called when needed from the model
	 * don't call it directly
	 */
	EventActivity removeActivity(int position) {
		EventActivity act = activities.remove(position);
		setChanged();
		notifyObservers("ActivityRemoved");
		return act;
	}
	
	/**
	 * moves activity inside one day
	 * this method will be called when needed from the model
	 * don't call it directly
	 */
	void moveActivity(int oldPosition, int newPosition) {
		if(newPosition>oldPosition){
			newPosition--;
		}
		EventActivity act = activities.remove(oldPosition);
		activities.add(newPosition,act);
		setChanged();
		notifyObservers("ActivityMoved");
	}
	

}

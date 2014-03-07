package model;

import java.util.Observable;

public class Activity extends Observable {

	// The possible types of the activity
	public static final int WORKOUT = 1;
	public static final int MEETING = 2;
	public static final int MEAL = 3;
	public static final int PARTY = 4;
	public static final int STUDIES = 5;
	public static final int WORK = 6;
	public static final int PLEASURE = 7;
	public static final int OTHER = 8;

	String name;
	String description;

	int length; // in minutes
	int type;

	int start;
	int end;

	/**
	 * Creates an Activity
	 * 
	 * @param name
	 * @param description
	 * @param length
	 * @param type
	 */
	public Activity(String name, String description, int length, int type) {
		this.name = name;
		this.description = description;
		this.length = length;
		this.type = type;
		start = -1;
		end = -1;
	}

	/**
	 * set Start Time of an activity
	 * 
	 * @param start
	 */
	public void setStartTime(int start) {
		this.start = start;
	}

	/**
	 * get start Time of an activity
	 * 
	 * @return
	 */
	public int getStartTime() {
		return start;
	}

	/**
	 * set end time of an activity
	 * 
	 * @param end
	 */
	public void setEndTime(int end) {
		this.end = end;
	}

	/**
	 * get end time of an activity
	 * 
	 * @return
	 */
	public int getEndTime() {
		return end;
	}

	/**
	 * get Name of an activity
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name of an activity
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers("NameChanged");
	}

	/**
	 * Get description of an activity
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set decription of an activity
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
		setChanged();
		notifyObservers("DescriptionChanged");
	}

	/**
	 * Get length of an activity
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
		setChanged();
		notifyObservers("LengthChanged");
	}

	/**
	 * Get type of an activity
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * Set an type of an activity
	 * 
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
		setChanged();
		notifyObservers("TypeChanged");
	}

}

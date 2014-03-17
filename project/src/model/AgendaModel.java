package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


public class AgendaModel extends Observable {

	List<Day> days = new ArrayList<Day>();
	List<EventActivity> parkedActivites = new ArrayList<EventActivity>();
	
	public AgendaModel(){
		
		addExampleData();
	}

	/**
	 * adds create and add a new day to model with starting time (hours and
	 * minutes)
	 */
	public Day addDay(int day, int month, int year) {
		Day d = new Day(day, month, year);
		days.add(d);
		return d;
	}
	/**
	 * return the list of all days
	 * @return
	 */
	public List<Day> getDays(){
		
		return days;
	}
	
	public List<String> getNameOfDays(){
		List<String> array = new LinkedList<String>();
		
		for(int i = 0; i < days.size(); i++){
			array.add(days.get(i).getDateString());
		}
		
		return array;
		
	}

	/**
	 * add an activity to model
	 */
	public void addActivity(EventActivity act, Day day, int position) {
		day.addActivity(act, position);
		setChanged();
		notifyObservers("ActivityAddedToDay");
	}

	/**
	 * add an activity to parked activities
	 */
	public void addParkedActivity(EventActivity act) {
		parkedActivites.add(act);
		setChanged();
		notifyObservers("ActivityParked");
	}
	
	/**
	 * return the list of parked activities
	 * @return
	 */
	public List<EventActivity> getParkedActivities(){
		return parkedActivites;
	}
	
	public List<String> getNameOfParkedActivities(){
		List<String> array = new LinkedList<String>();
		
		for(int i = 0; i < parkedActivites.size(); i++){
			array.add(parkedActivites.get(i).getName());
		}
		
		return array;
	}
	
	public EventActivity[] getParkedActivitiesArray(){
		EventActivity[] pa = new EventActivity[parkedActivites.size()];
		
		for(int i = 0; i < parkedActivites.size(); i++){
			pa[i] = parkedActivites.get(i);
		}
		
		return pa;
	}

	/**
	 * remove an activity on provided position from parked activites
	 */
	public EventActivity removeParkedActivity(int position) {
		EventActivity act = parkedActivites.remove(position);
		setChanged();
		notifyObservers();
		return act;
	}

	/**
	 * moves activity between the days, or day and parked activities. to park
	 * activity you need to set the newday to null to move a parked activity to
	 * let's say first day you set oldday to null and newday to first day
	 * instance
	 */
	public void moveActivity(Day oldday, int oldposition, Day newday,
			int newposition) {
		if (oldday != null && oldday == newday) {
			oldday.moveActivity(oldposition, newposition);
		} else if (oldday == null && newday != null) {
			EventActivity act = removeParkedActivity(oldposition);
			newday.addActivity(act, newposition);
		} else if (oldday != null && newday == null) {
			EventActivity act = oldday.removeActivity(oldposition);
			addParkedActivity(act);
		} else if (oldday != null && newday != null) {
			EventActivity activity = oldday.removeActivity(oldposition);
			newday.addActivity(activity, newposition);
		}
		setChanged();
		notifyObservers();
	};
	
	public void addExampleData(){
		String[] titles = {"Workout", "Meeting", "Meal", "Party", "Studies", "Work", "Pleasure", "Other"};
		String[] descriptions = {"Workout", "Meeting", "Meal", "Party", "Studies", "Work", "Pleasure", "Other"};
		Integer[] durations = {1, 2, 3, 4, 5, 6, 7, 8};
		Integer[] categories = {1, 2, 3, 4, 5, 6, 7, 8};
		
		for(int i = 0; i < 8; i++){
			EventActivity ea = new EventActivity(titles[i], descriptions[i], durations[i], categories[i]);
			addParkedActivity(ea);
		}
		
		days.add(new Day(5, 6, 2014));
		days.add(new Day(1, 7, 2015));
		days.add(new Day(22, 12, 2014));
		
	}


}

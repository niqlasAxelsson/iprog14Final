package model;

import java.util.LinkedList;


import android.app.Application;

public class AgendaApplication extends Application {

	private AgendaModel model = new AgendaModel();
	private LinkedList<EventActivity> freeActivites = new LinkedList<EventActivity>();

	public AgendaModel getModel() {

		return model;
	}
	
	/**
	 * 
	 * @param m
	 */
	public void setModel(AgendaModel model) {

		this.model = model;
	}
	
	
	/**
	 *set the activity List
	 * @param list
	 */
	public void setActivity(LinkedList<EventActivity> list){
		freeActivites = list;
	}
	
	
	/**
	 * 
	 * @return the activity list
	 */
	public LinkedList<EventActivity> getActivities(){
		return freeActivites;
				
	}
	
	/**
	 * add activity to the list of free activities
	 * @param activiy
	 */
	public void addAtivityToList(EventActivity activiy){
		freeActivites.add(activiy);
	}
	
	
	/**
	 * 
	 * @param activity to remove from list of free activities
	 */
	public void removeActivityFromList(EventActivity activity){
		freeActivites.remove(activity);
	}
	
	
	
}

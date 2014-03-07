package com.group14.pl4nn3r3000;

import java.util.LinkedList;

import model.Activity;
import model.AgendaModel;

import android.app.Application;

public class AgendaApplication extends Application {

	private AgendaModel model = new AgendaModel();
	private LinkedList<Activity> freeActivites = new LinkedList<Activity>();

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
	public void setActivity(LinkedList<Activity> list){
		freeActivites = list;
	}
	
	
	/**
	 * 
	 * @return the activity list
	 */
	public LinkedList<Activity> getActivities(){
		return freeActivites;
				
	}
	
	/**
	 * add activity to the list of free activities
	 * @param activiy
	 */
	public void addAtivityToList(Activity activiy){
		freeActivites.add(activiy);
	}
	
	
	/**
	 * 
	 * @param activity to remove from list of free activities
	 */
	public void removeActivityFromList(Activity activity){
		freeActivites.remove(activity);
	}
	
	
	
}

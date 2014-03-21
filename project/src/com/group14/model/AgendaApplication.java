package com.group14.model;

import android.app.Application;

public class AgendaApplication extends Application {

	private AgendaModel model = new AgendaModel();

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
	
}

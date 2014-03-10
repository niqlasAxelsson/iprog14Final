package view;

import java.util.Observable;
import java.util.Observer;

import model.AgendaModel;
import android.app.Activity;
import android.view.View;

public class CreateEventView implements Observer {
	
	View view;
	AgendaModel model;
	Activity activity;
	
	public CreateEventView(View view,AgendaModel model, Activity activity){
		
		this.view = view;
		this.model = model;
		this.activity=activity;
		
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}

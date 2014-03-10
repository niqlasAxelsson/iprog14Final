package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;
import model.EventActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class CreateEventActivity extends Activity {

	TextView activityField;
	TextView descriptionField;
	Button doneButton;
	
	int duration;
	String activityName;
	String descriptionText;
	int activityType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_event);
		setComponents();
		
		doneButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				AgendaModel model = ((AgendaApplication) getApplication()).getModel();
				getFields();
				EventActivity newEventActivity = new EventActivity(activityName,descriptionText,duration,activityType);
				model.addParkedActivity(newEventActivity);
				Intent i = new Intent(getBaseContext(),MainActivity.class);
				startActivity(i);
			}
			
		});
		
		
	}
	
	private void setComponents(){
		
		activityField = (TextView) findViewById(R.id.acitivty_name_id);
		descriptionField = (TextView) findViewById(R.id.description_text_id);
		doneButton = (Button)findViewById(R.id.done_button_id);
		
	}
	
	private void getFields(){
		
		activityName = activityField.getText().toString();
		descriptionText = descriptionField.getText().toString();
		//TODO
		activityType = 1; /// change this
		duration = 1; // change this
	}



}

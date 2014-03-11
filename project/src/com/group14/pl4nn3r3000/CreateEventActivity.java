package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;
import model.EventActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class CreateEventActivity extends Activity {

	TextView activityField;
	TextView descriptionField;
	Button doneButton;
	NumberPicker durationPicker;
	RadioButton rbWorkout, rbMeal, rbMeeting, rbParty, rbStudies, rbWork, rbPleasure, rbOther;
	
	int duration;
	String activityName;
	String descriptionText;
	int activityType = 8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_event);
		setComponents();
		setRbClickListeners();
		
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
	
	

	/**
	 * sets the compontents in the activity
	 */
	private void setComponents(){
		
		activityField = (TextView) findViewById(R.id.acitivty_name_id);
		descriptionField = (TextView) findViewById(R.id.description_text_id);
		doneButton = (Button)findViewById(R.id.done_button_id);
		durationPicker = (NumberPicker) findViewById(R.id.durationPicker_id);
		
		durationPicker.setMaxValue(24);
		durationPicker.setMinValue(1);
		durationPicker.setWrapSelectorWheel(false); 
		
		//radiobuttons
		rbWorkout = (RadioButton) findViewById(R.id.workout_rb);
		rbMeal = (RadioButton) findViewById(R.id.meal_rb);
		rbMeeting = (RadioButton) findViewById(R.id.meeting_rb);
		rbParty = (RadioButton) findViewById(R.id.party_rb);
		rbStudies = (RadioButton) findViewById(R.id.studies_rb);
		rbWork = (RadioButton) findViewById(R.id.work_rb);
		rbPleasure = (RadioButton) findViewById(R.id.pleasure_rb);
		rbOther = (RadioButton) findViewById(R.id.other_rb);
		
	}
	
	/**
	 * get all the fields from the eventeacitivty fields
	 */
	private void getFields(){
		
		activityName = activityField.getText().toString();
		descriptionText = descriptionField.getText().toString();
		//TODO
	 /// change this
		duration = durationPicker.getValue();
		
	}


	
	private void setRbClickListeners() {
		
		rbWorkout.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(true);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 1;
	        }
	    });
		rbMeal.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(true);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 2;
	        }
	    });
		rbMeeting.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(true);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 3;
	        }
	    });
		rbParty.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(true);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 4;
	        }
	    });
		rbStudies.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(true);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 5;
	        }
	    });
		rbWork.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(true);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(false);
	           activityType = 6;
	        }
	    });
		rbPleasure.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(true);
	           rbOther.setChecked(false);
	           activityType = 7;
	        }
	    });
		rbOther.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	           rbWorkout.setChecked(false);
	           rbMeal.setChecked(false);
	           rbMeeting.setChecked(false);
	           rbParty.setChecked(false);
	           rbStudies.setChecked(false);
	           rbWork.setChecked(false);
	           rbPleasure.setChecked(false);
	           rbOther.setChecked(true);
	           activityType = 8;
	        }
	    });
	}

}

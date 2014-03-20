package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;
import model.EventActivity;
import view.ActionBarView;
import view.CreateEventView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class CreateEventActivity extends Activity {

	TextView activityField;
	TextView descriptionField;
	Button doneButton;
	NumberPicker durationPicker;
	RadioButton rbWorkout, rbMeal, rbMeeting, rbParty, rbStudies, rbWork,
			rbPleasure, rbOther;

	int duration;
	String activityName;
	String descriptionText;
	int activityType = 8;
	Intent oldActivityIntent;
	Activity oldActivity;

	AgendaModel model;
	CreateEventView View;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_event);
		model = ((AgendaApplication) getApplication()).getModel();
		View = new CreateEventView(this.findViewById(android.R.id.content),
				model, this);

		// oldActivity = model.mainActivity;
		// oldActivityIntent = oldActivity.getIntent();

		setClickOnDoneButton();
		setRbClickListeners();

	}

	private void setClickOnDoneButton() {

		View.getDoneButton().setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// AgendaModel model = ((AgendaApplication)
				// getApplication()).getModel();
				View.getFields();
				EventActivity newEventActivity = new EventActivity(View
						.getActivityName(), View.getDescriptionText(), View
						.getDuration(), View.getActivityType());
				model.addParkedActivity(newEventActivity);
				// Intent i = new Intent(getBaseContext(),MainActivity.class);
				// startActivity();
				finish();
			}

		});
	}

	private void setRbClickListeners() {

		View.getAllRadioButtons()[0].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(true);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(1);
			}
		});

		View.getAllRadioButtons()[1].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(true);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(3);

			}
		});
		View.getAllRadioButtons()[2].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(true);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(2);
			}
		});
		View.getAllRadioButtons()[3].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(true);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(4);

			}
		});
		View.getAllRadioButtons()[4].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(true);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(5);
			}
		});
		View.getAllRadioButtons()[5].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(true);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(6);
			}
		});
		View.getAllRadioButtons()[6].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(true);
				View.getAllRadioButtons()[7].setChecked(false);
				View.setActivityType(7);
			}
		});
		View.getAllRadioButtons()[7].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View.getAllRadioButtons()[0].setChecked(false);
				View.getAllRadioButtons()[1].setChecked(false);
				View.getAllRadioButtons()[2].setChecked(false);
				View.getAllRadioButtons()[3].setChecked(false);
				View.getAllRadioButtons()[4].setChecked(false);
				View.getAllRadioButtons()[5].setChecked(false);
				View.getAllRadioButtons()[6].setChecked(false);
				View.getAllRadioButtons()[7].setChecked(true);
				View.setActivityType(8);
			}
		});

	}

}

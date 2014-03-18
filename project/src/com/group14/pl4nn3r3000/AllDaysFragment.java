package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;
import model.Day;
import view.AllDaysFragmentView;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * fragment for every day that is created.
 * 
 * 
 * 
 */
public class AllDaysFragment extends Fragment {

	SelectedDayFragment frag;
	AllDaysFragmentView view;
	Activity activity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		this.activity = this.getActivity();
		// get the model
		AgendaModel model = ((AgendaApplication) this.getActivity()
				.getApplication()).getModel();
		// the view of the all days fragment
		view = new AllDaysFragmentView(this.getActivity(), inflater.inflate(
				R.layout.all_days_fragment_layout, container, false));

		setClickListenerOnNewDayButton();
		setOnItemClickListeners();

		return view.getView();
	}

	private void setOnItemClickListeners() {

		OnItemClickListener listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View v,
					int position, long arg3) {
				AgendaModel model = ((AgendaApplication) activity
						.getApplication()).getModel();
				Day day = model.getDayFromPos(position);
				model.setSelectedDay(day);
				frag = new SelectedDayFragment();

				final FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.fragment_holder, frag, "test");
				ft.addToBackStack(null);
				ft.commit();

			}

		};

		view.getListView().setOnItemClickListener(listener);

	}

	private void setClickListenerOnNewDayButton() {

		view.getNewDayButton().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				View alertView = View.inflate(activity,
						R.layout.new_day_alert_layout, null);
				AlertDialog.Builder alert = new AlertDialog.Builder(activity);

				// we didn't want to make a new view class just for 2 lines of
				// code, sue us
				alert.setTitle("New day");
				alert.setView(alertView);

				final DatePicker datePicker;
				datePicker = (DatePicker) alertView
						.findViewById(R.id.datePicker);

				alert.setPositiveButton("Done",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								AgendaModel model = ((AgendaApplication) activity
										.getApplication()).getModel();
								model.addDay(datePicker.getDayOfMonth(),
										datePicker.getMonth() + 1,
										datePicker.getYear());
								view.getDayTitles()
										.add(model
												.getDays()
												.get(model.getDays().size() - 1)
												.getDateString());
								view.getAdapter().notifyDataSetChanged();

							}

						});

				alert.show();
			}
		});
	}

}

// private void setClickListenerOnNewDayButton() {
//
// view.getNewDayButton().setOnClickListener(new OnClickListener() {
// @Override
// public void onClick(View v) {
// frag = new SelectedDayFragment();
//
// final FragmentTransaction ft = getFragmentManager()
// .beginTransaction();
// ft.replace(R.id.fragment_holder, frag, "test");
// ft.addToBackStack(null);
// ft.commit();
// }
// });
// }
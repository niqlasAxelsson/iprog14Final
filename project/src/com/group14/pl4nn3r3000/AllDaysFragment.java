package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;
import view.AllDaysFragmentView;

import com.example.pl4nn3r3000.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * fragment for every day that is created.
 * 
 * 
 * 
 */
public class AllDaysFragment extends Fragment {

	SelectedDayFragment frag;
	AllDaysFragmentView view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// get the model
		AgendaModel model = ((AgendaApplication) this.getActivity()
				.getApplication()).getModel();
		// the view of the all days fragment
		view = new AllDaysFragmentView(this.getActivity(), inflater.inflate(
				R.layout.all_days_fragment_layout, container, false), model);

		setClickListenerOnNewDayButton();

		return view.getView();
	}

	private void setClickListenerOnNewDayButton() {

		view.getNewDayButton().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("hej");
				frag = new SelectedDayFragment();

				final FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.fragment_holder, frag, "test");
				ft.addToBackStack(null);
				ft.commit();
			}
		});
	}

}
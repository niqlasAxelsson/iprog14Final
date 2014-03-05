package com.example.pl4nn3r3000;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectedDayFragment extends Fragment {

	AllDaysFragment frag;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.selected_day_fragment_layout,
				container, false);
		final Button button = (Button) view.findViewById(R.id.button_test2);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				frag = new AllDaysFragment();

				final FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.fragment_holder, frag, "test 2");
				ft.addToBackStack(null);
				ft.commit();
			}
		});

		return view;
	}

}

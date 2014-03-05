package com.example.pl4nn3r3000;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AllDaysFragment extends Fragment{
	
	SelectedDayFragment frag;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Button testButton = (Button) getView().findViewById(R.id.button_test);
		ButtonAction buttonAction = new ButtonAction();
		System.out.println(buttonAction== null);
		testButton.setOnClickListener(buttonAction);
		
		frag = new SelectedDayFragment();
		
		return inflater.inflate(R.layout.all_days_fragment_layout, container, false);
	}

	private class ButtonAction implements OnClickListener{

		@Override
		public void onClick(View v) {
			final FragmentTransaction ft = getFragmentManager().beginTransaction(); 
			ft.replace(R.id.all_days_layout, frag, "test");
			ft.commit(); 
		}
		
		
	}
}



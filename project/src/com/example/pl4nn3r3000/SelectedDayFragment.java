package com.example.pl4nn3r3000;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectedDayFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//Button testButton = (Button) container.findViewById(R.id.button_test);
		//ButtonAction buttonAction = new ButtonAction();
		//testButton.setOnClickListener(buttonAction);
		
		return inflater.inflate(R.layout.selected_day_fragment_layout, container, false);
	}

	private class ButtonAction implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			
		}
		
		
	}
}



package com.group14.pl4nn3r3000;

import com.example.pl4nn3r3000.R;

import model.AgendaApplication;
import model.AgendaModel;
import view.SelectedDayFragmentView;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * fragment for a day. 
 * 
 * @author julle
 *
 */
public class SelectedDayFragment extends Fragment {

	AllDaysFragment frag;
	SelectedDayFragmentView view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		AgendaModel model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		//View view = inflater.inflate(R.layout.selected_day_fragment_layout,
			//	container, false);
		
		view = new SelectedDayFragmentView(this.getActivity(),inflater.inflate(R.layout.selected_day_fragment_layout,container, false));
		initTextView();
		
		
		return view.getView();
	}
	
	
	private void initTextView(){
		
		AgendaModel model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		view.getDayTitleTextView().setText(model.getSelectedDay().getDateString());
		
	}

}

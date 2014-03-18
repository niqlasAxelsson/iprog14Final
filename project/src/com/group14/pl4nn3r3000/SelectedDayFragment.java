package com.group14.pl4nn3r3000;

import java.util.List;

import com.example.pl4nn3r3000.R;

import model.AgendaApplication;
import model.AgendaModel;
import model.ScheduleList;
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

	private AllDaysFragment frag;
	private SelectedDayFragmentView view;
	private List<String> scheduleTimes;
	private ScheduleList adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		view = new SelectedDayFragmentView(this.getActivity(),inflater.inflate(R.layout.selected_day_fragment_layout,container, false));
		initTextView();
		initScheduleTimes();
		setAdapterForList();
		
		
		return view.getView();
	}
	
	
	private void setAdapterForList() {
		adapter = new ScheduleList(this.getActivity(), scheduleTimes);
		view.getListView().setAdapter(adapter);
		
	}


	/**
	 * creates the list of strings for the arrayadapter
	 */
	private void initScheduleTimes() {
		for(int i = 6; i<= 24; i++){
			String s = "";
			if(i < 10){
				s = "0" + i + ":00";
			}else{
				s = i + ":00";
			}
			System.out.println(s);
			scheduleTimes.add(s);
		}	
		System.out.println(scheduleTimes);
	}

	/**
	 * init the dayTitle text.
	 */
	private void initTextView(){
		
		AgendaModel model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		view.getDayTitleTextView().setText(model.getSelectedDay().getDateString());
		
	}
	
	private void initSelectedDayList(){
		
		
		
	}

}

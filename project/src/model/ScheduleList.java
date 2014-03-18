package model;

import java.util.List;

import view.AllDaysListView;
import view.ScheduleListView;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ScheduleList extends ArrayAdapter<String>{
	
	private Activity context;
	private List<String> scheduleTimes;
	private int position;
	private View scheduleList;
	private ScheduleListView scheduleListView;

	public ScheduleList(Activity context, List<String> scheduleTimes) {
		super(context, R.layout.hour_list_item, scheduleTimes);
		
		System.out.println("listan skapas");
		
		this.context = context;
		this.scheduleTimes = scheduleTimes;
		
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		this.position = position;
		this.scheduleListView = new ScheduleListView(context,view,position);
		
		System.out.println("i getview i listan");
		
		setResourcesForComponents();
		checkIfActivityOnThisTime();
		
		
		return scheduleListView.getListItemView();
	}

	private void checkIfActivityOnThisTime() {
		AgendaModel model = ((AgendaApplication) context.getApplication()).getModel();
		System.out.println("modellen h�mtad");
		EventActivity thisActivity = model.getSelectedDay().activities.get(position);
		
		System.out.println("kollar om det finns n�t p� denna tiden");
		
		if(thisActivity != null){
			scheduleListView.getTimeTextView().setTextColor(Color.WHITE);
			scheduleListView.getListItemHolder().setBackgroundColor(thisActivity.getColor());
			scheduleListView.getHourImageView().setImageResource(thisActivity.getImage());
			scheduleListView.getDescrTextView().setText(thisActivity.getDescription());
		}
		
	}

	private void setResourcesForComponents() {
		scheduleListView.getTimeTextView().setText(scheduleTimes.get(position));
		
		System.out.println("setResrouces har gjorts");
	}
	
	
	

}

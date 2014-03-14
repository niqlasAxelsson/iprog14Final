package view;

import java.util.List;

import com.example.pl4nn3r3000.R;
import com.group14.pl4nn3r3000.AllDaysFragment;
import com.group14.pl4nn3r3000.HorizontalListView;

import model.AgendaModel;
import model.EventActivity;
import model.EventActivityList;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.ViewGroup;

public class MainActivityView {

	Activity activity;
	AgendaModel model;
	ActionBarView actionBar;
	
	private EventActivityList adapter;
	private EventActivity[] parkedEvents;
	private int position;
	private HorizontalListView listview;
	List<String> activityNames;
	
	
	
	public MainActivityView(Activity activity, AgendaModel model){
		
		this.activity = activity;
		this.model=model;
		buildActionBar();
		buildComponents();
		buildFragment();
	}
	
	
	/**
	 * creates the actionbar
	 */
	private void buildActionBar(){
		
		ActionBarView actionBar = new ActionBarView(activity, ViewGroup.VISIBLE);
	}
	
	public ActionBarView getActionBar(){
		
		return actionBar;
		
	}
	
	/**
	 * builds the components in the MainActivity
	 */
	private void buildComponents(){
		
		activityNames = model.getNameOfParkedActivities();
		parkedEvents = model.getParkedActivitiesArray();		
		listview = (HorizontalListView) activity.findViewById(R.id.listview);
		adapter = new EventActivityList(activity, model, activityNames);
		listview.setAdapter(adapter);
		//listview.setOnItemLongClickListener(listener);
	}
	
	public HorizontalListView getListView(){
		
		return listview;
	}
	
	public EventActivityList getAdapter(){
		
		return adapter;
	}
	
	/**
	 * builds the fragment
	 */
	private void buildFragment() {
		AllDaysFragment frag = new AllDaysFragment();
		FragmentManager manager = activity.getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_holder, frag, "alldaysfragment");
		transaction.commit();
	}


}

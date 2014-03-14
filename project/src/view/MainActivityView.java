package view;

import java.util.List;

import model.AgendaModel;
import model.EventActivity;
import model.EventActivityList;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pl4nn3r3000.R;
import com.group14.pl4nn3r3000.AllDaysFragment;
import com.group14.pl4nn3r3000.HorizontalListView;

/**
 * Our MainActivityView.
 * @author julle
 *
 */
public class MainActivityView {

	Activity activity;
	AgendaModel model;
	ActionBarView actionBarView;
	
	private EventActivityList adapter;
	private EventActivity[] parkedEvents;
	private int position;
	private HorizontalListView listview;
	List<String> activityNames;
	
	private Button newActivityButton;
	
	
	
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
		
		 actionBarView = new ActionBarView(activity, ViewGroup.VISIBLE);
	}
	
	/**
	 * returns the actionBar
	 * @return
	 */
	public ActionBarView getActionBar(){
		
		return actionBarView;
		
	}
	
	/**
	 * get the acitivtyNames list.
	 * Using it to update the list 
	 * @return
	 */
	public List<String> getActivityNamesList(){
		
		return activityNames;
	}
	
	
	/**
	 * builds the components in.
	 * For example, creates the adapter, our horizontallist
	 */
	private void buildComponents(){
		
		activityNames = model.getNameOfParkedActivities();
		parkedEvents = model.getParkedActivitiesArray();		
		listview = (HorizontalListView) activity.findViewById(R.id.listview);
		adapter = new EventActivityList(activity, model, activityNames);
		listview.setAdapter(adapter);
		
		newActivityButton = (Button) activity.findViewById(R.id.newActivityButton);
	
	}
	
	
	
	/**
	 * return our horizontalListView
	 * @return
	 */
	public HorizontalListView getListView(){
		
		return listview;
	}
	
	public EventActivityList getAdapter(){
		
		return adapter;
	}
	
	/**
	 * return the new activity button
	 * @return
	 */
	public Button getNewActivityButton(){
		
		return newActivityButton;
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

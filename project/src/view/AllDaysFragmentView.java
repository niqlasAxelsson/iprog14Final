package view;

import java.util.Observable;
import java.util.Observer;

import model.AgendaApplication;
import model.AgendaModel;
import model.AllDaysList;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pl4nn3r3000.R;
/**
 * the VIEW of alldaysfragment
 * Show every day that is created.
 */

public class AllDaysFragmentView implements Observer {
	
	private AgendaModel model;
	private View view;
	private ListView listView;
	private AllDaysList adapter;
	private Activity activity;
	
	private Button newDayButton;
	
	public AllDaysFragmentView(Activity activity, View view, AgendaModel model){
		this.activity = activity;
		this.model = model;
		this.view = view;
		buildComponents();
	}
	
	
	/**
	 * returns the view
	 * @return
	 */
	public View getView(){
		return view;
	}
	
	/**
	 * builds the components in the view
	 */
	private void buildComponents(){
		AgendaModel model = ((AgendaApplication) activity.getApplication()).getModel();
		
		
		newDayButton = (Button) view.findViewById(R.id.newDayButton);
		listView = (ListView) view.findViewById(R.id.allDaysListView);
		adapter = new AllDaysList(activity, model.getNameOfDays());
		listView.setAdapter(adapter);
				
	}
	
	/**
	 * return the new day button 
	 * @return
	 */
	public Button getNewDayButton(){
		
		return newDayButton;
	}
	
	/**
	 * returns the adapter for the listView
	 * @return
	 */
	public AllDaysList getAdapter(){
		return adapter;
	}
	
	@Override
	public void update(Observable observable, Object data) {
		
		
		
		
	}

}

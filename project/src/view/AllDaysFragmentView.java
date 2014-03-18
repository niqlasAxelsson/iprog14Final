package view;

import java.util.List;
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
	
	private View view;
	private ListView listView;
	private AllDaysList adapter;
	private Activity activity;
	private List<String> dayTitles;
	
	private Button newDayButton;
	
	public AllDaysFragmentView(Activity activity, View view){
		this.activity = activity;
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
		
		dayTitles = model.getNameOfDays();
		newDayButton = (Button) view.findViewById(R.id.newDayButton);
		listView = (ListView) view.findViewById(R.id.allDaysListView);
		adapter = new AllDaysList(activity, dayTitles);
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
	
	public List<String> getDayTitles(){
		return dayTitles;
	}

	public ListView getListView(){
		return listView;
	}
}

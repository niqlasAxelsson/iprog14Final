package view;

import java.util.Observable;
import java.util.Observer;

import model.AgendaApplication;
import model.AgendaModel;
import model.AllDaysList;
import model.EventActivityList;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.example.pl4nn3r3000.R;
import com.group14.pl4nn3r3000.HorizontalListView;
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
	
	public AllDaysFragmentView(Activity activity, View view, AgendaModel model){
		this.activity = activity;
		this.model = model;
		this.view = view;
		buildComponent();
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
	private void buildComponent(){
		AgendaModel model = ((AgendaApplication) activity.getApplication()).getModel();

		listView = (ListView) view.findViewById(R.id.allDaysListView);
		adapter = new AllDaysList(activity, model.getNameOfDays());
		listView.setAdapter(adapter);
				
	}
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}

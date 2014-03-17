package view;

import java.util.Observable;
import java.util.Observer;

import model.AgendaApplication;
import model.AgendaModel;
import model.Day;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class AllDayListView implements Observer {

	private Activity activity;
	private View view;
	
	private View listItemView;
	private TextView dayTitle;
	private TextView dayDescription;
	private ImageView dayDelete;
	
	
	public AllDayListView(Activity activity,View view,int position){
		
		this.view = view;
		this.activity = activity;
		
		buildComponents();
		setResourcesForComponents(position);
		
	}
	
	
	private void buildComponents(){
		
		LayoutInflater inflater = activity.getLayoutInflater();
		listItemView = inflater.inflate(R.layout.all_days_list_item, null, true);
		
		dayTitle = (TextView) listItemView.findViewById(R.id.day_date);
		dayDescription = (TextView) listItemView.findViewById(R.id.day_description);
		dayDelete  =  (ImageView) listItemView.findViewById(R.id.day_delete);

	}
	
	public View getListItemView(){
		return listItemView;
	}
	
	private void setResourcesForComponents(int position) {	
		AgendaModel model = ((AgendaApplication) activity.getApplication()).getModel();
		Day selectedDay = model.getDays().get(position);
		
		dayTitle.setText(selectedDay.getDateString());
		//dayDescription here		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}

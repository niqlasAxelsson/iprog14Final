package model;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class AllDaysList extends ArrayAdapter<String> {

	Activity context;
	int position;
	private View listItemView;
	TextView dayTitle;
	TextView dayDescription;
	ImageView dayDelete;
	

	public AllDaysList(Activity context, List<String> dayTitles) {
		super(context, R.layout.all_days_list_item, dayTitles);
		this.context = context;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		this.position = position;
		LayoutInflater inflater = context.getLayoutInflater();
		listItemView = inflater.inflate(R.layout.all_days_list_item, null, true);
		
		buildComponents();
		setResourcesForComponents();
		
		return super.getView(position, view, parent);
	}

	private void buildComponents() {
		
		dayTitle = (TextView) listItemView.findViewById(R.id.day_date);
		dayDescription = (TextView) listItemView.findViewById(R.id.day_description);
		dayDelete  =  (ImageView) listItemView.findViewById(R.id.day_delete);
		
		
	}

	private void setResourcesForComponents() {	
		AgendaModel model = ((AgendaApplication) context.getApplication()).getModel();
		Day selectedDay = model.getDays().get(position);
		
		dayTitle.setText(selectedDay.getDateString());
		//dayDescription here		
	}
}

package model;

import java.util.List;

import view.AllDaysListView;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;
import com.group14.pl4nn3r3000.CreateEventActivity;

public class AllDaysList extends ArrayAdapter<String> {

	Activity context;
	
	private View listItemView;
	TextView dayTitle;
	TextView dayDescription;
	ImageView dayDelete;
	AllDaysListView alldaysList;
	
	int position;
	

	public AllDaysList(Activity context, List<String> dayTitles) {
		super(context, R.layout.all_days_list_item, dayTitles);
		this.context = context;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		this.position = position;
		alldaysList = new AllDaysListView(context,view,position);
		setClickListenerOnDeleteImage(position);
		return alldaysList.getListItemView();
	
	}
	
	
	/**
	 * ClickListener on the "Delete X" in the lsitView
	 */
	private void setClickListenerOnDeleteImage(int position){
		final int f = position;
		alldaysList.getDayDelete().setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				AgendaModel model = ((AgendaApplication) context.getApplication()).getModel();
				//model.removeDay(f);
				System.out.println("heeeeeej");
	
			}
			
			
		});
		
		
	}
	

}

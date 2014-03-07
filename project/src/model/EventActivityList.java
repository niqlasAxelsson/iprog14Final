package model;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivityList extends ArrayAdapter<String>{
	
	private Activity context;
	private AgendaModel model;
	private int position;
	private TextView eventTitle;
	private TextView eventDuration;
	private ImageView eventImage;
	private View listItemView;
	private EventActivity[] parkedEvents;
	

	public EventActivityList(Activity context, AgendaModel model, String[] activityNames) {
		super(context, R.layout.list_item, activityNames);
		this.context = context;
		this.model = model;
		this.parkedEvents = model.getParkedActivitiesArray();
		
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		this.position = position;
		LayoutInflater inflater = context.getLayoutInflater();
		listItemView = inflater.inflate(R.layout.list_item, null, true);
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		eventTitle = (TextView) listItemView.findViewById(R.id.list_item_title);
		eventDuration = (TextView) listItemView.findViewById(R.id.list_item_duration);
		eventImage = (ImageView) listItemView.findViewById(R.id.list_item_image);
		
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		
		EventActivity selectedEvent = parkedEvents[position];
		eventTitle.setText(selectedEvent.getName());
		eventDuration.setText(selectedEvent.getLength());
		eventImage.setImageResource(selectedEvent.getImage());	
		
		System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccccc");
		
		return listItemView;
	}

	/**
	 * Build the three components for the list items
	 */
	private void buildComponents() {
		
	}
	
	/**
	 * Sets the resources for all of the components created in the list item
	 */
	private void setResourcesForComponents() {
		
	}
	

}

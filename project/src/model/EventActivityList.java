package model;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pl4nn3r3000.R;

public class EventActivityList extends ArrayAdapter<String> implements Observer {

	private Activity context;
	private AgendaModel model;
	private int position;
	private TextView eventTitle;
	private TextView eventDuration;
	private ImageView eventImage;
	private View listItemView;
	private EventActivity[] parkedEvents;

	public EventActivityList(Activity context, AgendaModel model,
			String[] activityNames) {
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

		buildComponents();
		setResourcesForComponents();
		
		//eventImage.setOnLongClickListener(longListen);

		return listItemView;
	}

	/**
	 * Build the three components for the list items
	 */
	private void buildComponents() {
		eventTitle = (TextView) listItemView.findViewById(R.id.list_item_title);
		eventDuration = (TextView) listItemView
				.findViewById(R.id.list_item_duration);
		eventImage = (ImageView) listItemView
				.findViewById(R.id.list_item_image);
	}

	/**
	 * Sets the resources for all of the components created in the list item
	 */
	private void setResourcesForComponents() {
		EventActivity selectedEvent = parkedEvents[position];
		eventTitle.setText("" + selectedEvent.getName());
		eventDuration.setText("" + selectedEvent.getLength() + "h");
		eventImage.setImageResource(selectedEvent.getImage());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		parkedEvents = model.getParkedActivitiesArray();
		setResourcesForComponents();
		
	}


}

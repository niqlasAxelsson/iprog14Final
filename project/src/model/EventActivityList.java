package model;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivityList extends ArrayAdapter<String> {

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
		
		eventImage.setOnLongClickListener(longListen);

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
		eventDuration.setText("" + selectedEvent.getLength());
		eventImage.setImageResource(selectedEvent.getImage());
	}

	OnLongClickListener longListen = new OnLongClickListener() {

		@Override
		public boolean onLongClick(View v) {

			DragShadow dragShadow = new DragShadow(v);

			ClipData data = ClipData.newPlainText("", "");

			v.startDrag(data, dragShadow, v, 0);

			return false;
		}
	};

	private class DragShadow extends View.DragShadowBuilder {

		Drawable dragImage;

		public DragShadow(View view) {
			super(view);

			dragImage = eventImage.getDrawable();
		}

		@Override
		public void onDrawShadow(Canvas canvas) {

			dragImage.draw(canvas);
		}

		@Override
		public void onProvideShadowMetrics(Point shadowSize,
				Point shadowTouchPoint) {

			Rect rect = dragImage.getBounds();

			shadowSize.set(rect.height(), rect.width());

			shadowTouchPoint.set(rect.height() / 2, rect.width() / 2);

		}

	}

}

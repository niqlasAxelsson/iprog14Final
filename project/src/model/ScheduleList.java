package model;

import java.util.List;

import view.AllDaysListView;
import view.ScheduleListView;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnDragListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class ScheduleList extends ArrayAdapter<String> {

	public Activity context;
	private List<String> scheduleTimes;
	private int position;
	private ScheduleListView scheduleListView;

	public ScheduleList(Activity context, List<String> scheduleTimes) {
		super(context, R.layout.hour_list_item, scheduleTimes);

		this.context = context;
		this.scheduleTimes = scheduleTimes;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		int tempPosition = position;
		this.position = position;
		this.scheduleListView = new ScheduleListView(context, view, position);

		setResourcesForComponents();
		checkIfActivityOnThisTime();
		setOnDragListenerForLayout(tempPosition, this);

		return scheduleListView.getListItemView();
	}

	private void setOnDragListenerForLayout(int pos, ScheduleList list) {

		scheduleListView.getListItemHolder().setOnDragListener(
				new CustomDragListener(pos, list));
	}

	/**
	 * private class for a custom ondraglistener
	 * 
	 * @author julle
	 * 
	 */
	private class CustomDragListener implements OnDragListener {

		private int position;
		private ScheduleList list;
		
		AgendaModel model = ((AgendaApplication) context.getApplication())
				.getModel();

		public CustomDragListener(int pos, ScheduleList list) {
			position = pos;
			this.list = list;
		}

		@Override
		public boolean onDrag(View v, DragEvent event) {

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				// nothing
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				System.out.println("Entered: " + position);

				if (model.getSelectedDay().getPositionBoolean()[position] == false) {
					v.setBackgroundColor(Color.parseColor("#dbdbdb"));
				}

				break;
			case DragEvent.ACTION_DRAG_EXITED:
				System.out.println("Exited: " + position);

				if (model.getSelectedDay().getPositionBoolean()[position] == false) {
					v.setBackgroundColor(Color.parseColor("#ececec"));
				}

				break;
			case DragEvent.ACTION_DROP:
				ClipData.Item item = event.getClipData().getItemAt(0);
				String dragData = "" + item.getText();
				int positionFromParkedEvents = Integer.parseInt(dragData);
				
				boolean wasAdded = model.getSelectedDay().addActivity(model.getParkedActivities().get(positionFromParkedEvents), getPos());
				
				System.out.println("activity added klart");
				
				if(wasAdded){
					System.out.println("removing");
					model.removeParkedActivity(positionFromParkedEvents);
					
					list.notifyDataSetChanged();
					
					
				}
						
						
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				// nothing
			default:
				break;
			}

			return true;
		}

		public int getPos() {
			return position;
		}
	}

	/**
	 * checks if there is any activities on this time and loads them if there is
	 * any
	 */
	private void checkIfActivityOnThisTime() {
		AgendaModel model = ((AgendaApplication) context.getApplication())
				.getModel();
		EventActivity thisActivity = model.getSelectedDay().getActivities()
				.get(position);

		if (thisActivity != null) {
			scheduleListView.getTimeTextView().setTextColor(Color.WHITE);
			scheduleListView.getListItemHolder().setBackgroundColor(
					thisActivity.getColor());
			scheduleListView.getHourImageView().setImageResource(
					thisActivity.getImage());
			scheduleListView.getDescrTextView().setText(thisActivity.getName());

		} else if (thisActivity == null
				&& model.getSelectedDay().getPositionBoolean()[position] == true) {
			for (int i = position; i >= 0; i--) {
				if (model.getSelectedDay().getActivities().get(i) != null) {
					scheduleListView.getListItemHolder().setBackgroundColor(
							model.getSelectedDay().getActivities().get(i)
									.getColor());
					scheduleListView.getTimeTextView()
							.setTextColor(Color.WHITE);
					break;
				}

			}
		}

	}

	private void setResourcesForComponents() {
		scheduleListView.getTimeTextView().setText(scheduleTimes.get(position));
	}

}

package model;

import java.util.List;

import view.AllDaysListView;
import view.ScheduleListView;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Color;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ScheduleList extends ArrayAdapter<String> {

	private Activity context;
	private List<String> scheduleTimes;
	private int position;
	private View scheduleList;
	private ScheduleListView scheduleListView;
	private View view;

	public ScheduleList(Activity context, List<String> scheduleTimes) {
		super(context, R.layout.hour_list_item, scheduleTimes);

		this.context = context;
		this.scheduleTimes = scheduleTimes;

	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		this.position = position;
		this.view = view;
		this.scheduleListView = new ScheduleListView(context, view, position);

		setResourcesForComponents();
		checkIfActivityOnThisTime();
		setOnDragListenerForLayout();

		scheduleListView.getListItemHolder().setBackgroundColor(Color.parseColor("#FF8A00"));
		return scheduleListView.getListItemView();
	}

	private void setOnDragListenerForLayout() {
		
		
		scheduleListView.getListItemHolder().setOnDragListener(
				new View.OnDragListener() {

					@Override
					public boolean onDrag(View v, DragEvent event) {
						int action = event.getAction();
						switch (event.getAction()) {
						case DragEvent.ACTION_DRAG_STARTED:
							// nothing
							break;
						case DragEvent.ACTION_DRAG_ENTERED:
							scheduleListView.getListItemHolder().setBackgroundColor(Color.parseColor("#FF8A00"));
							break;
						case DragEvent.ACTION_DRAG_EXITED:
							scheduleListView.getListItemHolder().setBackgroundColor(Color.parseColor("#ececec"));
							break;
						case DragEvent.ACTION_DROP:
							//nothing
							break;
						case DragEvent.ACTION_DRAG_ENDED:
							// nothing
						default:
							break;
						}

						return false;
					}
				});

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

package com.group14.pl4nn3r3000;

import java.util.List;

import model.AgendaApplication;
import model.AgendaModel;
import model.EventActivity;
import model.EventActivityList;
import view.ActionBarView;
import view.MainActivityView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pl4nn3r3000.R;

/**
 * MainActivity, our starting activity, with all the fragments, the
 * scrollhorizontal list.
 */
public class MainActivity extends Activity {

	private AgendaModel model;
	MainActivityView mainActivityView;

	private Vibrator vibe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get the application model
		model = ((AgendaApplication) this.getApplication()).getModel();

		model.mainActivity = this;

		mainActivityView = new MainActivityView(this, model,
				model.getNameOfParkedActivities());
		vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		setClickListenerOnListView();
		setDragListenerOnListView();
		setClickListenerOnButton();
		setOnDragOnTrashCan();

	}

	private void setDragListenerOnListView() {
		mainActivityView.getListView().setOnDragListener(new OnDragListener() {

			@Override
			public boolean onDrag(View v, DragEvent event) {

				switch (event.getAction()) {
				case DragEvent.ACTION_DRAG_STARTED:
					// nothing
					break;
				case DragEvent.ACTION_DRAG_ENTERED:
					// nothing
					break;
				case DragEvent.ACTION_DRAG_EXITED:
					// nothing
					break;
				case DragEvent.ACTION_DROP:
					// TODO
					ClipData.Item item = event.getClipData().getItemAt(0);
					String dragData = "" + item.getText();

					String[] strings = dragData.split(" ");
					
					// if the clipdata ends with a . that means it comes from
					// the vertical listview i.e proceed with drop
					if (dragData.endsWith(".")) {
						int positionsFromWithinList = Integer.parseInt(strings[0]);
						
						model.addParkedActivity(model.getSelectedDay().getActivities().get(positionsFromWithinList));

						System.out.println("removing from within list");
						
						model.getSelectedDay().removeActivity(positionsFromWithinList);
							
					}

					break;
				case DragEvent.ACTION_DRAG_ENDED:
					// nothing
				default:
					break;
				}
				return true;
			}
		});

	}

	public MainActivityView getMainActivityView() {
		return mainActivityView;
	}

	/**
	 * sets DragListener on the Horizonztal Scroll list
	 */
	private void setClickListenerOnListView() {
		mainActivityView.getListView().setOnItemLongClickListener(listener);
	}

	/**
	 * sets ClickListener on the "New Activity" button
	 */
	private void setClickListenerOnButton() {

		mainActivityView.getNewActivityButton().setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						Intent i = new Intent(getBaseContext(),
								CreateEventActivity.class);
						startActivity(i);

					}

				});
	}

	/**
	 * sets OnDrag on the trashcan
	 */
	private void setOnDragOnTrashCan() {

		mainActivityView.getActionBar().getTrashImageView()
				.setOnDragListener(new OnDragListener() {

					@Override
					public boolean onDrag(View v, DragEvent event) {

						int action = event.getAction();
						switch (event.getAction()) {
						case DragEvent.ACTION_DRAG_STARTED:
							// nothing
							break;
						case DragEvent.ACTION_DRAG_ENTERED:
							// nothing
							break;
						case DragEvent.ACTION_DRAG_EXITED:
							// nothing
							break;
						case DragEvent.ACTION_DROP:
							// TODO
							ClipData.Item item = event.getClipData().getItemAt(
									0);
							String dragData = "" + item.getText();
							int position = Integer.parseInt(dragData);

							model.removeParkedActivity(position);

							break;
						case DragEvent.ACTION_DRAG_ENDED:
							// nothing
						default:
							break;
						}
						return true;
					}

				});
	}

	// the code inside this maybe should be removed to a view class:)?
	/**
	 * Our class for listening when starting draging. What shall happen when we
	 * drag?
	 * 
	 */
	OnItemLongClickListener listener = new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View v,
				int position, long arg3) {

			ImageView image = (ImageView) v.findViewById(R.id.list_item_image);
			vibe.vibrate(250);
			DragShadow dragShadow = new DragShadow(v, image);

			ClipData data = ClipData.newPlainText("position", "" + position);
			System.out.println("POSITION : " + position);
			v.startDrag(data, dragShadow, v, 0);
			return false;
		}

	};

	private class DragShadow extends View.DragShadowBuilder {

		Drawable dragImage;

		public DragShadow(View view, ImageView image) {
			super(view);

			dragImage = image.getDrawable();

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

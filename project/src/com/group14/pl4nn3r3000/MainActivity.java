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
 * MainActivity, 
 * our starting activity, with all the fragments, the scrollhorizontal list.
 */
public class MainActivity extends Activity {

	private AgendaModel model;
	private MainActivityView mainActivityView;
	private EventActivityList adapter;
	private EventActivity[] parkedEvents;
	private int position;
	private HorizontalListView listview;
	List<String> activityNames;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		// builds the actionbar
		//buildActionBar();
		
		

		// get the application model
		model = ((AgendaApplication) this.getApplication()).getModel();
		//model.addExampleData();
		mainActivityView = new MainActivityView(this,model);
		setDragListenerOnListView();
		
		//buildComponents();

		// starts fragment
		//buildFragment();
	}
	
	
	
	private void setDragListenerOnListView(){
		mainActivityView.getListView().setOnItemLongClickListener(listener);
	}
	
	/**
	 * builds the components
	 * gets the parkedactivities, creates the the horizontallist
	 */
	
	private void buildComponents() {
		activityNames = model.getNameOfParkedActivities();
		parkedEvents = model.getParkedActivitiesArray();		
		listview = (HorizontalListView) findViewById(R.id.listview);
		adapter = new EventActivityList(this, model, activityNames);
		listview.setAdapter(adapter);
		listview.setOnItemLongClickListener(listener);
		
		
		
		Button newActivityButton = (Button) findViewById(R.id.newActivityButton);
		newActivityButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(),
						CreateEventActivity.class);
				startActivity(i);

			}
		});
		
	}
	
	/**
	 * creates the actionbar and sets draglistner on the trashcan
	 */
	private void buildActionBar() {
		ActionBarView view = new ActionBarView(this, ViewGroup.VISIBLE);
		
		//setup the trashcan
		view.getTrashImageView().setOnDragListener(new OnDragListener() {
			
			@Override
			public boolean onDrag(View v, DragEvent event) {
				
				 int action = event.getAction();
				    switch (event.getAction()) {
				    case DragEvent.ACTION_DRAG_STARTED:
				    	//nothing
				      break;
				    case DragEvent.ACTION_DRAG_ENTERED:
				    	//nothing
				      break;
				    case DragEvent.ACTION_DRAG_EXITED:
				    	//nothing				      
				      break;
				    case DragEvent.ACTION_DROP:
				      //TODO
				      ClipData.Item item = event.getClipData().getItemAt(0);
				      String dragData = "" + item.getText();
				      int position = Integer.parseInt(dragData);
				  
				      EventActivity removedActivity = model.getParkedActivitiesArray()[position];
				      System.out.println(position);
				      model.removeParkedActivity(position);
				      
				      activityNames.remove(position);
				      System.out.println(activityNames.toString());
				      				      
				      adapter.notifyDataSetChanged();
				      
				      break;
				    case DragEvent.ACTION_DRAG_ENDED:
				      //nothing
				      default:
				      break;
				    }
				    return true;
			}
		});
	}

	/**
	 * builds our fragment
	 */
	public void buildFragment() {
		AllDaysFragment frag = new AllDaysFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_holder, frag, "alldaysfragment");
		transaction.commit();
	}

	OnItemLongClickListener listener = new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View v,
				int position, long arg3) {

			ImageView image = (ImageView) v.findViewById(R.id.list_item_image);

			DragShadow dragShadow = new DragShadow(v, image);

			ClipData data = ClipData.newPlainText("position", "" + position);

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

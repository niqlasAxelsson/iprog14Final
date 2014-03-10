package com.group14.pl4nn3r3000;

import java.util.List;

import model.AgendaApplication;
import model.AgendaModel;
import model.EventActivity;
import model.EventActivityList;

import com.example.pl4nn3r3000.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends Activity {
	
	private AgendaModel model;
	private EventActivityList adapter;
	private EventActivity[] parkedEvents;
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		//get the application model
		model = ((AgendaApplication) this.getApplication()).getModel();
		model.addExampleData();
		String[] activityNames = model.getNameOfParkedActivities();
		parkedEvents = model.getParkedActivitiesArray();
		
		// create the horizontal listview
		HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
		adapter = new EventActivityList(this, model, activityNames);
		listview.setAdapter(adapter);
		listview.setOnItemLongClickListener(listener);

		// starts fragment
		AllDaysFragment frag = new AllDaysFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_holder, frag, "alldaysfragment");
		transaction.commit();
	}

	
	
	OnItemLongClickListener listener = new OnItemLongClickListener() {


		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View v, int position, long arg3) {
			
			ImageView image = (ImageView) v.findViewById(R.id.list_item_image);
			
			DragShadow dragShadow = new DragShadow(v, image);
			

			ClipData data = ClipData.newPlainText("", "");

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

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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private AgendaModel model;
	private EventActivityList adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get the application model
		model = ((AgendaApplication) this.getApplication()).getModel();
		model.addExampleData();
		EventActivity[] parkedActivities= model.getParkedActivitiesArray();
		
		// create the horizontal listview
		HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
		adapter = new EventActivityList(this, model, parkedActivities);
		listview.setAdapter(adapter);

		// starts fragment
		AllDaysFragment frag = new AllDaysFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_holder, frag, "alldaysfragment");
		transaction.commit();
	}

	
	
	//allt h�r under ska tas bort n�r EventActivityList �r klar
	
	private static String[] dataObjects = new String[] { "Text #1", "Text #2",
			"Text #3", "fnhiosw,", "fdsfvs", "few", "vfdsv", "Maddafukka",
			"qwerty" };

	private BaseAdapter mAdapter = new BaseAdapter() {

		@Override
		public int getCount() {
			return dataObjects.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View retval = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.list_item, null);
			TextView title = (TextView) retval
					.findViewById(R.id.list_item_title);
			title.setText(dataObjects[position]);

			return retval;
		}

	};

}

package com.example.pl4nn3r3000;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create the horizontal listview
		HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
        listview.setAdapter(mAdapter);
		
		//starts fragment
		AllDaysFragment frag = new AllDaysFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fragment_holder, frag, "alldaysfragment");
		transaction.commit();
	}

	
	 private static String[] dataObjects = new String[]{ "Text #1",
	        "Text #2",
	        "Text #3", 
	        "fnhiosw,","fdsfvs" , "few", "vfdsv","Maddafukka", "qwerty"};
	    
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
	            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
	            TextView title = (TextView) retval.findViewById(R.id.list_item_title);
	            title.setText(dataObjects[position]);
	            
	            return retval;
	        }


	        
	    };
	

}

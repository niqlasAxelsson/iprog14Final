package com.group14.pl4nn3r3000;

import java.util.LinkedList;
import java.util.List;

import com.example.pl4nn3r3000.R;

import model.AgendaApplication;
import model.AgendaModel;
import model.ScheduleList;
import view.SelectedDayFragmentView;
import android.app.Fragment;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemLongClickListener;


/**
 * fragment for a day. 
 * 
 * @author julle
 *
 */
public class SelectedDayFragment extends Fragment {

	private AllDaysFragment frag;
	private SelectedDayFragmentView view;
	private LinkedList<String> scheduleTimes = new LinkedList<String>();
	private ScheduleList adapter;
	AgendaModel model;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		view = new SelectedDayFragmentView(this.getActivity(),inflater.inflate(R.layout.selected_day_fragment_layout,container, false));
		initTextView();
		initScheduleTimes();
		setAdapterForList();
		
		return view.getView();
	}
	
	
	OnItemLongClickListener listener = new OnItemLongClickListener() {


		
		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View v,
				int position, long arg3) {

			if(model.getSelectedDay().getPositionBoolean()[position] == true){
				ImageView image = (ImageView) v.findViewById(R.id.hour_image);
				DragShadow dragShadow = new DragShadow(v, image);

				ClipData data = ClipData.newPlainText("position", "" + position);
				v.startDrag(data, dragShadow, v, 0);
			}
			
			return false;
		}

	};

	
	private void setAdapterForList() {
		adapter = new ScheduleList(this.getActivity(), scheduleTimes);
		System.out.println("innan listan får adapter");
		view.getListView().setAdapter(adapter);
		
	}


	/**
	 * creates the list of strings for the arrayadapter
	 */
	private void initScheduleTimes() {
		for(int i = 6; i <= 24; i++){
			String s = "";
			if(i < 10){
				s = "0" + i + ":00";
			}else{
				s = i + ":00";
			}
			scheduleTimes.add(s);
		}	
		
	}

	/**
	 * init the dayTitle text.
	 */
	private void initTextView(){
		
		AgendaModel model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		view.getDayTitleTextView().setText(model.getSelectedDay().getDateString());
		
	}
	
	
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
	
	private class DragShadow2 extends View.DragShadowBuilder {

		Drawable dragImage;

		public DragShadow2(View view, ImageView image) {
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

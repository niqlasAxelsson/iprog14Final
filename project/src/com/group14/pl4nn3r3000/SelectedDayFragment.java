package com.group14.pl4nn3r3000;

import model.AgendaApplication;
import model.AgendaModel;

import com.example.pl4nn3r3000.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * fragment for a day. 
 * 
 * @author julle
 *
 */
public class SelectedDayFragment extends Fragment {

	AllDaysFragment frag;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		AgendaModel model = ((AgendaApplication) this.getActivity().getApplication()).getModel();
		View view = inflater.inflate(R.layout.selected_day_fragment_layout,
				container, false);

		return view;
	}

}

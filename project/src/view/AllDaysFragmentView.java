package view;

import java.util.Observable;
import java.util.Observer;


/**
 * the VIEW of alldaysfragment
 * Show every day that is created.
 */
import com.example.pl4nn3r3000.R;


import model.AgendaModel;
import android.view.View;
import android.widget.Button;

public class AllDaysFragmentView implements Observer {
	
	AgendaModel model;
	View view;
	
	public AllDaysFragmentView(View view, AgendaModel model){
		this.model = model;
		this.view = view;
		buildComponent();
	}
	
	
	/**
	 * returns the view
	 * @return
	 */
	public View getView(){
		return view;
	}
	
	/**
	 * builds the components in the view
	 */
	private void buildComponent(){
//		Button b = (Button) view.findViewById(R.id.button_test);
//		b.setText("Challa");
	}
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}

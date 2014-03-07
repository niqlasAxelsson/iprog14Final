package view;

import java.util.Observable;
import java.util.Observer;
import com.group14.pl4nn3r3000.R;
import model.AgendaModel;
import model.EventActivity;

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
	
	
	public View getView(){
		return view;
	}
	
	private void buildComponent(){
		Button b = (Button) view.findViewById(R.id.button_test);
		b.setText("Challa");
	}
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}

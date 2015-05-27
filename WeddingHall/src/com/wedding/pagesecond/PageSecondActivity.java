package com.wedding.pagesecond;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;


public class PageSecondActivity extends Activity implements OnClickListener {
	
	private ImageButton ib;
	private Calendar cal;
	private int day;
	private int month;
	private int year;
	private EditText et;
	
	Button save;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_second);
        
        save = (Button) findViewById(R.id.faci);
     // mDateButton = (Button) findViewById(R.id.date_button);
     		ib = (ImageButton) findViewById(R.id.imageButton1);
     		cal = Calendar.getInstance();
     		day = cal.get(Calendar.DAY_OF_MONTH);
     		month = cal.get(Calendar.MONTH);
     		year = cal.get(Calendar.YEAR);
     		et = (EditText) findViewById(R.id.editText2);
     		ib.setOnClickListener(this);
     	    save.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.page_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
		
		case R.id.imageButton1:
		         showDialog(0);
		         break;
		         
		case R.id.faci:
			Intent i1 = new Intent(PageSecondActivity.this,Tab2Activity.class);
			startActivity(i1);
			break; 
		}
	}
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		return new DatePickerDialog(this, datePickerListener, year, month, day);
	}
	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			et.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
					+ selectedYear);
		}
	};
}

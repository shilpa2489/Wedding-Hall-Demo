package com.wedding.pagesecond;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.wedding.pagesecond.Pluse7demoActivity;
import com.wedding.pagesecond.R;

public class Pluse7demoActivity extends Activity implements OnClickListener  {
	
	// Widgets - GUI
		Spinner spCountries;
		Spinner spBusinessType;
	    Spinner spinner1;
	  //  Spinner spinner2;
		// Data Source
		String DecoratorType[] = { "Flower [Rs:5000]",  "Stage [Rs:10000]", "Hall [Rs:10000]",
				  "lighting [Rs:7000]" };
		
		String PhotographyType[] = { "Photography [Rs:15000]", "Videography [Rs:10000]", "Both [Rs:20000]" };
	    
	// Adapter
		ArrayAdapter<String> adapterBusinessType;
		ArrayAdapter<String> adapterPhotographyType;
		ArrayAdapter<String> adapterOtherType;

		private ActionBar actionBar;
		
		Button btnbook;

		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.pluse7demo);
			getActionBar().setDisplayHomeAsUpEnabled(true);

			btnbook=(Button) findViewById(R.id.booking);
			btnbook.setOnClickListener(this);
			
			// Initialize Spinners

			spCountries = (Spinner) findViewById(R.id.spCountries);
			spBusinessType = (Spinner) findViewById(R.id.spBussinessType);
	        spinner1=(Spinner) findViewById(R.id.spinner11);
	        
			// Initialize and set Adapter
			adapterBusinessType = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, DecoratorType);
			spBusinessType.setAdapter(adapterBusinessType);
			
			adapterPhotographyType = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, PhotographyType);
			spinner1.setAdapter(adapterPhotographyType);
			
		
		
			// Country Item Selected Listener
			spCountries.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> adapter, View v,
						int position, long id) {
					// On selecting a spinner item
					String item = adapter.getItemAtPosition(position).toString();

					// Showing selected spinner item
					Toast.makeText(getApplicationContext(),
							"Selected Catering : " + item, Toast.LENGTH_LONG).show();
				}
			
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}
			});
			// Business Type Item Selected Listener
			spBusinessType.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> adapter, View v,
						int position, long id) {
					// On selecting a spinner item
					String item = adapter.getItemAtPosition(position).toString();

					// Showing selected spinner item
					Toast.makeText(getApplicationContext(),
							"Decorator Type : " + item, Toast.LENGTH_LONG).show();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}
			});
			
			// Photography Type Item Selected Listener
			spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?>adapter, View v,
						int position, long id) {
					// on selecting spinner item
					
					String item = adapter.getItemAtPosition(position).toString();
					
					//showing selected spinner item
					Toast.makeText(getApplicationContext(),
							"Photography Type : " + item, Toast.LENGTH_LONG).show();
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			
		
				
		});
			
			
				
		}
		
		
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			switch (item.getItemId()) {
			case R.id.action_search:
				// search action
				return true;
			case R.id.action_location_found:
				// location found
				Intent i = new Intent(Pluse7demoActivity.this, LocationFound.class);
				startActivity(i);
				return true;
			case R.id.action_refresh:
				// refresh
				return true;
			case R.id.action_help:
				// help action
				return true;
			case R.id.action_check_updates:
				// check for updates action
				return true;
			case android.R.id.home:;
				NavUtils.navigateUpTo(this, new Intent(this,FetchDatesActivity.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}



		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch(v.getId()) {
			
			case R.id.booking:
				Intent i3 = new Intent(Pluse7demoActivity.this,PayActivity.class);
				startActivity(i3);
				break;
			
		}



		}

			
		}	
	
	
	
	
	


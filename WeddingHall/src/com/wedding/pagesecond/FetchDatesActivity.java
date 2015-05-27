package com.wedding.pagesecond;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class FetchDatesActivity extends Activity implements OnClickListener {
	
	JSONObject jsonobject;
	JSONArray jsonarray;
	ProgressDialog mProgressDialog;
	ArrayList<String> worldlist;
	ArrayList<WorldPopulation> world;
	
	private ActionBar actionBar;

	Button btnfaci;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fetch_dates);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Button btnfaci = (Button) findViewById(R.id.faci);
		
		btnfaci.setOnClickListener(this);
		// Download JSON file AsyncTask
				new DownloadJSON().execute();
	}
	
	// Download JSON file AsyncTask
		private class DownloadJSON extends AsyncTask<Void, Void, Void> {

			@Override
			protected Void doInBackground(Void... params) {
				// Locate the WorldPopulation Class	
				world = new ArrayList<WorldPopulation>();
				// Create an array to populate the spinner 
				worldlist = new ArrayList<String>();
				// JSON file URL address
				jsonobject = JSONfunctions
						.getJSONfromURL("http://167.114.36.184:80/jsonparsetutorial.txt");

				try {
					// Locate the NodeList name
					jsonarray = jsonobject.getJSONArray("worldpopulation");
					for (int i = 0; i < jsonarray.length(); i++) {
						jsonobject = jsonarray.getJSONObject(i);
						
						WorldPopulation worldpop = new WorldPopulation();

						worldpop.setRank(jsonobject.optString("hall_name"));
						worldpop.setCountry(jsonobject.optString("month"));
						worldpop.setPopulation(jsonobject.optString("Available_dates"));
						worldpop.setFlag(jsonobject.optString("flag"));
						world.add(worldpop);
						
						// Populate spinner with country names
						worldlist.add(jsonobject.optString("month"));

					}
				} catch (Exception e) {
					Log.e("Error", e.getMessage());
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void args) {
				// Locate the spinner in activity_main.xml
				Spinner mySpinner = (Spinner) findViewById(R.id.my_spinner);
				
				// Spinner adapter
				mySpinner
						.setAdapter(new ArrayAdapter<String>(FetchDatesActivity.this,
								android.R.layout.simple_spinner_dropdown_item,
								worldlist));

				// Spinner on item click listener
				mySpinner
						.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

							@Override
							public void onItemSelected(AdapterView<?> arg0,
									View arg1, int position, long arg3) {
								// TODO Auto-generated method stub
								// Locate the textviews in activity_main.xml
								TextView txtrank = (TextView) findViewById(R.id.rank);
								TextView txtcountry = (TextView) findViewById(R.id.country);
								TextView txtpopulation = (TextView) findViewById(R.id.population);
								
								// Set the text followed by the position 
								txtrank.setText("hall_name : "
										+ world.get(position).getRank());
								txtcountry.setText("month : "
										+ world.get(position).getCountry());
								txtpopulation.setText("Available_dates : "
										+ world.get(position).getPopulation());
							}

							@Override
							public void onNothingSelected(AdapterView<?> arg0) {
								// TODO Auto-generated method stub
							}
						});
			}
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fetch_dates, menu);
		return true;
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
			Intent i = new Intent(FetchDatesActivity.this, LocationFound.class);
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
			NavUtils.navigateUpTo(this, new Intent(this,Tab2Activity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
      switch(v.getId()) {
		
		case R.id.faci:
			Intent i2 = new Intent(FetchDatesActivity.this,Pluse7demoActivity.class);
			startActivity(i2);
			break;
		
	}
	}
}

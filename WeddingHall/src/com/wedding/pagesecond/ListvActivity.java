package com.wedding.pagesecond;



import com.wedding.pagesecond.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListvActivity extends Activity {
	
	// Declare Variables
		ListView list;
		ListViewAdapter adapter;
		String[] rank;
		String[] hall;
		String[] place;
		int[] flag;
		private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listv);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// Generate sample data into string arrays
				rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

				hall = new String[] { "Mahant Bhavan",
			            "Mahavir Bhavan",
			            "Dharmanath Bhavan",
			            "Mali Bhavan",
			            "PAI Resorts",
			            "KPTCL Bhavan",
			            "Maratha Bhavan",
			            "Gandhi Bhavan",
			            "KSRTC Hall",
			            "Garden Hall" };

				place = new String[] { "Mahantesh Nagar",
				    	"Goaves road",
				    	"Near ramdev",
				    	"Shivbasav nagar",
				    	"Opp. to lake",
				    	"KEB road",
				    	"Fish market",
				    	"College road",
				    	"RTO circle",
				    	"Nehru nagar" };

				flag = new int[] { R.drawable.mahavir,
			    		R.drawable.mahant,
			    		R.drawable.dharma,
			    		R.drawable.pai,
			    		R.drawable.mali,
			    		R.drawable.kptcl,
			    		R.drawable.gandhi,
			    		R.drawable.maratha,
			    		R.drawable.garden,
			    		R.drawable.ksrtc };

				// Locate the ListView in listview_main.xml
				list = (ListView) findViewById(R.id.listview);

				// Pass results to ListViewAdapter Class
				adapter = new ListViewAdapter(this, rank, hall, place, flag);
				// Binds the Adapter to the ListView
				list.setAdapter(adapter);
				// Capture ListView item click
				list.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Intent i = new Intent(ListvActivity.this, FetchDatesActivity.class);
						startActivity(i);
					/*	// Pass all data rank
						i.putExtra("rank", rank);
						// Pass all data country
						i.putExtra("country", hall);
						// Pass all data population
						i.putExtra("population", place);
						// Pass all data flag
						i.putExtra("flag", flag);
						// Pass a single position
						i.putExtra("position", position);
						// Open SingleItemView.java Activity
						startActivity(i);
					}
					*/
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
			Intent i = new Intent(ListvActivity.this, LocationFound.class);
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

	
	
				
				}

	


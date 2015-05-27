package com.wedding.pagesecond;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

public class Tab2Activity extends Activity implements TabListener,OnNavigationListener, OnClickListener {
	
List<Fragment> fragList = new ArrayList<Fragment>();
	
	private ActionBar actionBar;
	
	Button wed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		
		wed = (Button) findViewById(R.id.btnred);
	    wed.setOnClickListener(this);
		
        actionBar = getActionBar();
        
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for (int i=1; i <= 3; i++) {
			Tab tab = bar.newTab();
			tab.setText("Mantapa" + i);
			tab.setTabListener(this);
			bar.addTab(tab);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab2, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
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
			Intent i = new Intent(Tab2Activity.this, LocationFound.class);
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
			NavUtils.navigateUpTo(this, new Intent(this,PageSecondActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		Fragment fragment = new MyFragment();
		Bundle args = new Bundle();
		args.putInt(MyFragment.ARG_SECTION_NUMBER, itemPosition);
		fragment.setArguments(args);
		getFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return false;
	}
	public static class MyFragment extends Fragment {

		public static final String ARG_SECTION_NUMBER = "placeholder_text";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(getResources().getStringArray(R.array.dropdown)[getArguments().getInt(
					ARG_SECTION_NUMBER)]);
			textView.setTextColor(Color.BLACK);
			return textView;
		}
	}
	

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Fragment f = null;
		TabFragment tf = null;
		
		if (fragList.size() > tab.getPosition())
				fragList.get(tab.getPosition());
		
		if (f == null) {
			tf = new TabFragment();
			Bundle data = new Bundle();
			data.putInt("idx",  tab.getPosition());
			tf.setArguments(data);
			fragList.add(tf);
		}
		else
			tf = (TabFragment) f;
		
		ft.replace(android.R.id.content, tf);
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		
		case R.id.btnred:
			Intent i2 = new Intent(Tab2Activity.this,ListvActivity.class);
			startActivity(i2);
			break;
		}
		
	}

	
}

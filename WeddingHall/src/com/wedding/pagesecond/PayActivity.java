package com.wedding.pagesecond;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class PayActivity extends Activity implements OnClickListener {
	
	CheckBox credit,office,banking;
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		credit=(CheckBox) findViewById(R.id.checkBox1);
		office=(CheckBox) findViewById(R.id.checkBox2);
		banking=(CheckBox) findViewById(R.id.checkBox3);
		
		credit.setOnClickListener(this);
		banking.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pay, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case android.R.id.home:;
			NavUtils.navigateUpTo(this, new Intent(this,Pluse7demoActivity.class));
				return true;
		default:
			return super.onOptionsItemSelected(item);
}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch(v.getId()) {
		
		case R.id.checkBox1:
			Intent check = new Intent(PayActivity.this,PaybyCredit.class);
			startActivity(check);
			break;
			
		case R.id.checkBox3:
			Intent check2 = new Intent(PayActivity.this,OnlinePay.class);
			startActivity(check2);
			break;
		
	}
}
}
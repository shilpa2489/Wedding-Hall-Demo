package com.wedding.pagesecond;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class OnlinePay extends Activity {
	
	private WebView mWebView;
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_online_pay);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		 mWebView =(WebView)findViewById(R.id.activity_main_webview);
	        WebSettings webSettings=mWebView.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        mWebView.loadUrl("http://www.onlinesbi.com");
	    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.online_pay, menu);
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
}
package com.wedding.pagesecond;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
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
import android.widget.Button;
import android.widget.EditText;

public class PaybyCredit extends Activity {
	
	private ProgressDialog pDialog;

	private ActionBar actionBar;
	 
	// Create the object of JsonParser class

	    JSONParser jParser = new JSONParser();


	    EditText inputTomato;
	    EditText inputOnion;
	   


	    // url to create send data. This contains the ip address of my machine on which the local server is running. You will write the IP address of your machine

	      private static String url = "http://167.114.36.184:80/weddinghall/payy.php";

	    // JSON Node names

	    private static final String TAG_SUCCESS = "success";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payby_credit);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// Hide the action bar title
		//	actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
	        
	        inputTomato = (EditText) findViewById(R.id.editText1);
	        
	        inputOnion = (EditText) findViewById(R.id.editText2);
	        
	       
	        
	       
	        // Create button

	        Button btnCreateProduct = (Button) findViewById(R.id.buttonl);

	        // button click event

	        btnCreateProduct.setOnClickListener(new View.OnClickListener() {

	 
	            @Override

	            public void onClick(View view) {

	                // creating new product in background thread

	                new CreateNewId().execute();

	            }

	        });
	}

	
	class CreateNewId extends AsyncTask<String, String, String> {

   	 

        @SuppressWarnings("unused")

              @Override

        protected void onPreExecute() {

            super.onPreExecute();

            pDialog = new ProgressDialog(PaybyCredit.this);

            pDialog.setMessage("Creating Data..");

            pDialog.setIndeterminate(false);

            pDialog.setCancelable(true);

            pDialog.show();

        }

 

        protected String doInBackground(String... args) {

        	String account = inputTomato.getText().toString();
        	
            String amount = inputOnion.getText().toString();
            
         

          

            // Building Parameters

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("account", account));

            params.add(new BasicNameValuePair("amount", amount));
            
           

 
            JSONObject json = jParser.makeHttpRequest(url,

                    "POST", params);

          

            Log.d("Create Response", json.toString());

 
            try {

                int success = json.getInt(TAG_SUCCESS);

 

                if (success == 1) {

         
                      finish();

                  
                } else {       

                }

            } catch (JSONException e) {

                e.printStackTrace();

            }

            return null;

        }


        protected void onPostExecute(String file_url) {

            // dismiss the dialog once done

            pDialog.dismiss();

        }

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payby_credit, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
			case android.R.id.home:;
				NavUtils.navigateUpTo(this, new Intent(this,PayActivity.class));
					return true;
			default:
				return super.onOptionsItemSelected(item);
}
	}
}

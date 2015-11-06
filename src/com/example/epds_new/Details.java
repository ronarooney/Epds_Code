package com.example.epds_new;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class Details extends ActionBarActivity {
	EditText et1,et2,et3;
    Button b1;
    TextView tv;
    public String aa_ID;
    public String id;

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
	getActionBar().setHomeButtonEnabled(true);
	getActionBar().setDisplayHomeAsUpEnabled(true);
	 b1=(Button)findViewById(R.id.getRes);
	 et1 = (EditText)findViewById(R.id.et1);
     et2 = (EditText)findViewById(R.id.et2);
     et3 = (EditText)findViewById(R.id.et3);

	    	 id = getIntent().getExtras().getString("type");
	
	 b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
        	 String a, b, c;
             a = et1.getText().toString().trim();
             b = et2.getText().toString().trim();
             c = et3.getText().toString().trim();

             aa_ID = a + "-"+b+"-" + c; 
             Intent i = new Intent(Details.this,Ration_Details.class);
             i.putExtra("type", id);
             i.putExtra("adhar", aa_ID);
             startActivity(i);
           

            
         }
     });
 }
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_settings:
			
			break;

		default:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}

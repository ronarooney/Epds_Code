package com.example.epds_new;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class AdharSearch extends ActionBarActivity {
	EditText et1,et2,et3;
    Button b1;
    TextView tv;
    public String aa_ID;
    public String id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adhar_search);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		 et1 = (EditText)findViewById(R.id.ett1);
	     et2 = (EditText)findViewById(R.id.ett2);
	     et3 = (EditText)findViewById(R.id.ett3);

	}
public void adharSearch(View v)
{
	 String a, b, c;
     a = et1.getText().toString().trim();
     b = et2.getText().toString().trim();
     c = et3.getText().toString().trim();

     aa_ID = a + b+ c; 
     String id = "1";
     Intent i = new Intent(AdharSearch.this,AdharDetails.class);
     i.putExtra("adhar_id", id);
     i.putExtra("adhar", aa_ID);
     startActivity(i);
     
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adhar_search, menu);
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

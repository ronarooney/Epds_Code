package com.example.epds_new;

import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class Inspect extends ActionBarActivity {
	
public TextView mobile,office,number,inspector,block,address;
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inspect);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		mobile=(TextView)findViewById(R.id.mobile);
		office=(TextView)findViewById(R.id.office);
		number=(TextView)findViewById(R.id.number);
		inspector=(TextView)findViewById(R.id.inspector);
		block=(TextView)findViewById(R.id.block);
		address=(TextView)findViewById(R.id.address);
		
		mobile.setText(getIntent().getExtras().getString("mobile"));
		office.setText(getIntent().getExtras().getString("office"));
		number.setText(getIntent().getExtras().getString("number"));
		inspector.setText(getIntent().getExtras().getString("inspector"));
		block.setText(getIntent().getExtras().getString("title"));
		address.setText(getIntent().getExtras().getString("address"));
		number.setText(getIntent().getExtras().getString("number"));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inspect, menu);
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

package com.example.epds_new;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class DfscData extends Activity {
	TextView serial, title, mobile, fax, landline, address, email;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
getActionBar().setHomeButtonEnabled(true);
getActionBar().setDisplayHomeAsUpEnabled(true);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dfsc_data);

		serial = (TextView) findViewById(R.id.district_number);
		title = (TextView) findViewById(R.id.district_name);
		mobile = (TextView) findViewById(R.id.district_mobile);
		fax = (TextView) findViewById(R.id.district_fax);
		email = (TextView) findViewById(R.id.district_email);
		address = (TextView) findViewById(R.id.district_address);

		serial.setText(getIntent().getExtras().getString("serial"));
		title.setText(getIntent().getExtras().getString("title"));
		mobile.setText(getIntent().getExtras().getString("mobile"));
		fax.setText(getIntent().getExtras().getString("fax"));
		email.setText(getIntent().getExtras().getString("email"));
		address.setText(getIntent().getExtras().getString("address"));

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dfsc_data, menu);
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

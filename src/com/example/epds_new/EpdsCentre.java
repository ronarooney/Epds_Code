package com.example.epds_new;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class EpdsCentre extends ActionBarActivity {
GoogleMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_epds_centre);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		try{map=((MapFragment)getFragmentManager().findFragmentById(R.id.shimlaMap)).getMap();
		map.addMarker(new MarkerOptions().position(new LatLng(31.07733,77.181821))
				.title("Shimla Office")
				.snippet("FCS & CA ,Aapurti Bhavan,Block No. 42, SDA Complex,Kusumpti,Shimla 171009 (Himachal Pradesh,India)"));
		LatLng shimla= new LatLng(31.07733,77.181821);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(shimla, 5));
			
		}catch(NullPointerException e)
		{
			
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.epds_centre, menu);
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
		return false;
	}}

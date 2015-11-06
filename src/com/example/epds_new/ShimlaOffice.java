package com.example.epds_new;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class ShimlaOffice extends ActionBarActivity implements
		OnMapReadyCallback {
	public GoogleMap googleMap;
	public String url,district,nameofPerson,nameofOffice,address;
	public Float Lat,Long;
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shimla_office);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		try {
			if (googleMap == null) {
				googleMap = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
						}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
makeJsonRequest();
	}
public void makeJsonRequest()
{
	url="http://49.50.72.188/epdswebsite/webservice.asmx/GetMapDetail?OfficeType=DFSC%20Office";
	RequestQueue request = Volley.newRequestQueue(ShimlaOffice.this);
	JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Listener<JSONObject>() {

		@Override
		public void onResponse(JSONObject response) {
			// TODO Auto-generated method stub
			try {
				JSONArray ar = response.getJSONArray("MapList");
				for(int i=0;i<ar.length();i++)
				{
					JSONObject data = ar.getJSONObject(i);
					Lat=Float.parseFloat(data.getString("Lat"));
					Long=Float.parseFloat(data.getString("Long"));
					address=data.getString("Address");
					String delimiter="<br/>";
					String add[]=address.split(delimiter);
					nameofOffice=add[2];
					nameofPerson=add[3];
					googleMap.addMarker(new MarkerOptions().position(new LatLng(Lat, Long))
							.title(nameofOffice)
							.snippet(nameofPerson));
					LatLng dfsc = new LatLng(Lat, Long);
					googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dfsc, 5));
					
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}, new Response.ErrorListener() {

		@Override
		public void onErrorResponse(VolleyError error) {
			// TODO Auto-generated method stub
			error.printStackTrace();
		}
	});
	request.add(jsonRequest);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shimla_office, menu);
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

	@Override
	public void onMapReady(GoogleMap arg0) {
		// TODO Auto-generated method stub

	}
}

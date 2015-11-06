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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class DmOffice extends ActionBarActivity {
	public GoogleMap map;
	public String url, district, nameOfPerson, NameOfBlock, officeType,
			address, officeName;
	public Float lat, loong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dm_office);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		try {
			if (map == null) {
				map = ((MapFragment) getFragmentManager().findFragmentById(
						R.id.dmOfficeMap)).getMap();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		makeJsonrequest();
	}

	public void makeJsonrequest() {
		url = "http://49.50.72.188/epdswebsite/webservice.asmx/GetMapDetail?OfficeType=dm%20,office";
		RequestQueue request = Volley.newRequestQueue(DmOffice.this);
		JsonObjectRequest jsonRequest = new JsonObjectRequest(
				Request.Method.GET, url, null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						try {
							JSONArray ar = response.getJSONArray("MapList");
							for (int i = 0; i < ar.length(); i++) {
								JSONObject data = ar.getJSONObject(i);
								lat = Float.parseFloat(data.getString("Lat"));
								loong = Float.parseFloat(data.getString("Long"));
								address = data.getString("Address");
								String delimiter = "<br/>";
								String Str[] = address.split(delimiter);
								district = Str[0];
								NameOfBlock = Str[1];
								officeName = Str[2];
								nameOfPerson = Str[3];
								officeType = Str[4];
								map.addMarker(new MarkerOptions()
										.position(new LatLng(lat, loong))
										.title(nameOfPerson)
										.snippet(
												district + NameOfBlock
														+ officeName
														+ officeType));
								LatLng dm= new LatLng(lat, loong);
								map.moveCamera(CameraUpdateFactory.newLatLngZoom(dm, 5));
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (NullPointerException e) {
							// TODO: handle exception
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
		getMenuInflater().inflate(R.menu.dm_office, menu);
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

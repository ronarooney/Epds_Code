package com.example.epds_new;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class AmOffice extends ActionBarActivity {
public GoogleMap map;
public String url,distric,block,person,officeNa,officety;
public Float Lat,Long;
public TextView district,nameOfBlock,personName,officeName,officeType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_am_office);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		makeJsonRequest();
		try{
		if(map==null)
		{
		map = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.amOfficeMap)).getMap();
		}
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
	}
	public void makeJsonRequest()
	{
		url="http://49.50.72.188/epdswebsite/webservice.asmx/GetMapDetail?OfficeType=am,office";
		RequestQueue req = Volley.newRequestQueue(AmOffice.this);
		JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
				try {
					JSONArray ar = response.getJSONArray("MapList");
					Log.d("We are here", response.toString());
					for(int i=0;i<ar.length();i++)
					{
						JSONObject data=ar.getJSONObject(i);
						 Lat = Float.parseFloat(data.getString("Lat"));
						 Long=Float.parseFloat(data.getString("Long"));
						 String add =data.getString("Address");
						 String delimiter="<br/>";
						 String Str[]=add.split(delimiter);
						  distric=Str[0];
						  block=Str[1];
						  officeNa=Str[2];
						  person=Str[3];
						  officety =data.getString("OfficeType");
						
						
						
							map.addMarker(new MarkerOptions().position(new LatLng(Lat, Long)
							)
							.title(person)
							.snippet(distric+block+officeNa+officety)
							);
							
					LatLng am=new LatLng(Lat, Long);
					map.moveCamera(CameraUpdateFactory.newLatLngZoom(am, 5));
					
					
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
		req.add(request);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.am_office, menu);
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

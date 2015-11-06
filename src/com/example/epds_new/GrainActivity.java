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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class GrainActivity extends ActionBarActivity {
	public TextView atta, sugar, wheat, attaWholeMeal, attaChaaki, ricePermal;
	public String url;

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grain);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		atta = (TextView) findViewById(R.id.atta);
		sugar = (TextView) findViewById(R.id.sugar);
		wheat = (TextView) findViewById(R.id.wheat);
		attaWholeMeal = (TextView) findViewById(R.id.attaWholeMeal);
		attaChaaki = (TextView) findViewById(R.id.attaChakki);
		ricePermal = (TextView) findViewById(R.id.ricePermal);
makeJsonRequest();
	}

	public void makeJsonRequest() {
		url = "http://49.50.72.188/epdswebsite/webservice.asmx/GetPriceListDetail";
		RequestQueue req = Volley.newRequestQueue(GrainActivity.this);
		JsonObjectRequest rq = new JsonObjectRequest(Request.Method.POST, url,
				null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						try {
							JSONArray ar = response.getJSONArray("PriceList");
							JSONObject rice = ar.getJSONObject(0);
							String ricePrice = rice.getString("Price");
							ricePermal.setText(ricePrice);
							JSONObject att = ar.getJSONObject(2);
							String at = att.getString("Price");
							atta.setText(at);
							JSONObject sug = ar.getJSONObject(3);
							String suga = sug.getString("Price");
							sugar.setText(suga);
							JSONObject wh = ar.getJSONObject(14);
							String whe = wh.getString("Price");
							wheat.setText(whe);
							JSONObject attaC =ar.getJSONObject(21);
							String attaCh =attaC.getString("Price");
							attaChaaki.setText(attaCh);
							JSONObject	attaW = ar.getJSONObject(22);
							String attaWh=attaW.getString("Price");
							attaWholeMeal.setText(attaWh);
							
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError e) {
						// TODO Auto-generated method stub
						e.printStackTrace();
					}
				});
		req.add(rq);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grain, menu);
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

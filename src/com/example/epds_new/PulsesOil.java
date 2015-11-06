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

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class PulsesOil extends ActionBarActivity {
public TextView daalMalka,daalChana,gramDal,ArharDal,uradDal,moongDal;
public String url;
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pulses_oil);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		daalMalka=(TextView)findViewById(R.id.dalMalka);
		daalChana=(TextView)findViewById(R.id.dalChana);
		gramDal=(TextView)findViewById(R.id.gramDal);
		ArharDal=(TextView)findViewById(R.id.arharDal);
		uradDal=(TextView)findViewById(R.id.uradDal);
		moongDal=(TextView)findViewById(R.id.moongDal);
		makeJsonRequest();
	}
	public void makeJsonRequest()
	{
		url = "http://49.50.72.188/epdswebsite/webservice.asmx/GetPriceListDetail";
		RequestQueue request = Volley.newRequestQueue(PulsesOil.this);
		JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url,null,new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
			try {
				JSONArray ar = response.getJSONArray("PriceList");
				JSONObject Malka =ar.getJSONObject(9);
				String dalMal=Malka.getString("Price");
				daalMalka.setText(dalMal);
				JSONObject chana= ar.getJSONObject(10);
				String dalCha = chana.getString("Price");
				daalChana.setText(dalCha);
				JSONObject gram = ar.getJSONObject(13);
				String gramDa= gram.getString("Price");
				gramDal.setText(gramDa);
				JSONObject arhar= ar.getJSONObject(15);
				String arharDa= arhar.getString("Price");
				ArharDal.setText(arharDa);
				JSONObject urad=ar.getJSONObject(24);
				String ura = urad.getString("Price");
				uradDal.setText(ura);
				JSONObject moong = ar.getJSONObject(25);
				String moongDa = moong.getString("Price");
				moongDal.setText(moongDa);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		},new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				error.printStackTrace();
			}
		});
		request.add(req);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pulses_oil, menu);
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

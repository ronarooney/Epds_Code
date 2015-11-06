package com.example.epds_new;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
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

@SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.HONEYCOMB) public class Vegetable extends ActionBarActivity {
public TextView cabbage,onion,tomato,potoato,capscicum,spinach,cauliflower,raddish,brijal,frenchBeans,pea,ladyfinger;
public String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_vegetable);
		cabbage=(TextView)findViewById(R.id.cabbage);
		onion=(TextView)findViewById(R.id.onion);
		tomato=(TextView)findViewById(R.id.tomato);
		potoato=(TextView)findViewById(R.id.potato);
		capscicum=(TextView)findViewById(R.id.capscicum);
		spinach=(TextView)findViewById(R.id.spinach);
		cauliflower=(TextView)findViewById(R.id.cauliFlower);
		raddish=(TextView)findViewById(R.id.radish);
		brijal=(TextView)findViewById(R.id.brinjal);
		frenchBeans=(TextView)findViewById(R.id.frechBeans);
		pea=(TextView)findViewById(R.id.pea);
		ladyfinger=(TextView)findViewById(R.id.ladyFinger);
		makeJsonRequest();
		
	}
public void makeJsonRequest()
{
	url="http://49.50.72.188/epdswebsite/webservice.asmx/GetPriceListDetail";
	RequestQueue req = Volley.newRequestQueue(Vegetable.this);
	JsonObjectRequest	rq = new JsonObjectRequest(Request.Method.POST,url,null,new Listener<JSONObject>() {

		@Override
		public void onResponse(JSONObject response) {
			// TODO Auto-generated method stub
			try {
				JSONArray ar = response.getJSONArray("PriceList");
				JSONObject cab = ar.getJSONObject(27);
				String cabb= cab.getString("Price");
				cabbage.setText(cabb);
				JSONObject caul=ar.getJSONObject(28);
				String caulli= caul.getString("Price");
				cauliflower.setText(caulli);
				JSONObject rad= ar.getJSONObject(30);
				String radd=rad.getString("Price");
				raddish.setText(radd);
				JSONObject	brin = ar.getJSONObject(31);
				String brinj=brin.getString("Price");
				brijal.setText(brinj);
				JSONObject spin =ar.getJSONObject(32);
				String spina = spin.getString("Price");
				spinach.setText(spina);
				JSONObject french=ar.getJSONObject(33);
				String frenchb = french.getString("Price");
				frenchBeans.setText(frenchb);
				JSONObject p = ar.getJSONObject(34);
				String pe= p.getString("Price");
				pea.setText(pe);
				JSONObject lady = ar.getJSONObject(35);
				String ladyf = lady.getString("Price");
				ladyfinger.setText(ladyf);
				JSONObject cap=ar.getJSONObject(37);
				String caps=cap.getString("Price");
				capscicum.setText(caps);
				JSONObject on = ar.getJSONObject(4);
				String oni = on.getString("Price");
				onion.setText(oni);
				JSONObject pot = ar.getJSONObject(5);
				String pota=pot.getString("Price");
				potoato.setText(pota);
				JSONObject tom = ar.getJSONObject(6);
				String toma = tom.getString("Price");
				tomato.setText(toma);
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
	req.add(rq);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vegetable, menu);
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

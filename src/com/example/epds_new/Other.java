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
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class Other extends ActionBarActivity {
public TextView milk,egg,nutoil,vanaspati,teaLeaf,saltPacked,gurTikki,cementAcc,kerosene,bottleGourd,roundGourd,bitterGourd;
public String url;
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		milk=(TextView)findViewById(R.id.milk);
		egg=(TextView)findViewById(R.id.egg);
		nutoil=(TextView)findViewById(R.id.nutOil);
		vanaspati=(TextView)findViewById(R.id.vanspatiGhee);
		teaLeaf=(TextView)findViewById(R.id.teaLeafOpen);
		saltPacked=(TextView)findViewById(R.id.saltPacked);
		gurTikki=(TextView)findViewById(R.id.gurTikki);
		cementAcc=(TextView)findViewById(R.id.cementAcc);
		kerosene=(TextView)findViewById(R.id.keroseneOil);
		roundGourd=(TextView)findViewById(R.id.roundGourd);
		bitterGourd=(TextView)findViewById(R.id.bitterGourd);
		bottleGourd=(TextView)findViewById(R.id.bottleGourd);
		makeJsonRequest();
	}
public void makeJsonRequest()
{
	url="http://49.50.72.188/epdswebsite/webservice.asmx/GetPriceListDetail";
	RequestQueue req = Volley.newRequestQueue(Other.this);
	 JsonObjectRequest rq = new JsonObjectRequest(Request.Method.POST,url,null,new Listener<JSONObject>() {

		@Override
		public void onResponse(JSONObject response) {
			// TODO Auto-generated method stub
			try {
				JSONArray ar = response.getJSONArray("PriceList");
				JSONObject mi = ar.getJSONObject(1);
				String mil= mi.getString("Price");
				milk.setText(mil);
				JSONObject e =ar.getJSONObject(12);
				String eg =e.getString("Price");
				egg.setText(eg);
				JSONObject nut = ar.getJSONObject(16);
				String nuto=nut.getString("Price");
				nutoil.setText(nuto);
				JSONObject van=ar.getJSONObject(17);
				String vanas=van.getString("Price");
				vanaspati.setText(vanas);
				JSONObject tea=ar.getJSONObject(18);
				String teaLea=tea.getString("Price");
				teaLeaf.setText(teaLea);
				JSONObject salt=ar.getJSONObject(19);
				String saltp=salt.getString("Price");
				saltPacked.setText(saltp);
				JSONObject gur = ar.getJSONObject(20);
				String gurt= gur.getString("Price");
				gurTikki.setText(gurt);
				JSONObject acc=ar.getJSONObject(23);
				String accc=acc.getString("Price");
				cementAcc.setText(accc);
				JSONObject ker= ar.getJSONObject(26);
				String kero= ker.getString("Price");
				kerosene.setText(kero);
				JSONObject round = ar.getJSONObject(38);
				String roundg=round.getString("Price");
				roundGourd.setText(roundg);
				JSONObject bitter = ar.getJSONObject(39);
				String bitterg=bitter.getString("Price");
				bitterGourd.setText(bitterg);
				JSONObject bottle =ar.getJSONObject(29);
				String bottleg = bottle.getString("Price");
				bottleGourd.setText(bottleg);
						
				
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
		getMenuInflater().inflate(R.menu.other, menu);
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

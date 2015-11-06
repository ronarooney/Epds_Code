package com.example.epds_new;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class Ration_Details extends ActionBarActivity {
	public int num;
	public TextView name,address,fps,block,village,district,panchayat,card;
	public String ur;
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ration__details);
	name=(TextView)findViewById(R.id.nameAdhar);
	address=(TextView)findViewById(R.id.adressName);
	fps=(TextView)findViewById(R.id.fps);
	block=(TextView)findViewById(R.id.blockName);
	village=(TextView)findViewById(R.id.villageName);
	district=(TextView)findViewById(R.id.districtName);
	panchayat=(TextView)findViewById(R.id.panchayatName);
	card=(TextView)findViewById(R.id.cardName);
	getActionBar().setHomeButtonEnabled(true);
	getActionBar().setDisplayHomeAsUpEnabled(true);
		makeJsonRequest();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ration__details, menu);
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
	public void makeJsonRequest()
	{
		String id=getIntent().getExtras().getString("type");
		String adhar=getIntent().getExtras().getString("adhar");
		String url="http://49.50.72.188/epdswebsite/webservice.asmx/Fetch_RCDataJson?TypeId="+id+"&FieldText="+adhar;
	ur=url;
		RequestQueue req= Volley.newRequestQueue(Ration_Details.this);
	
		
		JsonObjectRequest rq= new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
			try {
				JSONObject RationCardDetail=response.getJSONObject("RationCardDetail");
				String n=RationCardDetail.getString("HOF_Name");
				String a=RationCardDetail.getString("Address");
				String v=RationCardDetail.getString("Village_Name");
				String d=RationCardDetail.getString("District_Name");
				String p = RationCardDetail.getString("Panchayat_Name");
				String f=RationCardDetail.getString("FPS_Id");
				String c=RationCardDetail.getString("Card_Type");
				String b = RationCardDetail.getString("Block_Name");	
				name.setText(n);
				address.setText(a);
				village.setText(v);
				district.setText(d);
				panchayat.setText(p);
				fps.setText(f);
				card.setText(c);
				block.setText(b);
				JSONArray ar= response.getJSONArray("MemberDetail");
				num=ar.length();
				System.out.println(num);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			
			}
		},new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		req.add(rq);
		
	}
	public void member(View v)
	{
		Intent i = new Intent(Ration_Details.this,Member_Details.class);
		i.putExtra("url", ur);
		System.out.println(ur);
		i.putExtra("int", num);
		startActivity(i);
		
	}
}

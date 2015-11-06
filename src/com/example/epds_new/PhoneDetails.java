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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class PhoneDetails extends ActionBarActivity {
public String type_id,phone,url;
public TextView src,name,village,district,block,panchayat,card,fps,address;
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_details);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		src=(TextView)findViewById(R.id.src_number);
		name=(TextView)findViewById(R.id.namePhone);
		village=(TextView)findViewById(R.id.villagePhone);
		district=(TextView)findViewById(R.id.districtPhone);
		block=(TextView)findViewById(R.id.blockPhone);
		panchayat=(TextView)findViewById(R.id.panchayatPhone);
		card=(TextView)findViewById(R.id.cardPhone);
		fps=(TextView)findViewById(R.id.fpsPhone);
		address=(TextView)findViewById(R.id.addressPhone);
		type_id=getIntent().getExtras().getString("type_id");
		phone=getIntent().getExtras().getString("phone");
		makeJsonRequest();
	}
public void makeJsonRequest()
{
	url="http://49.50.72.188/epdswebsite/webservice.asmx/Fetch_RCDataJson?TypeId="+type_id+"&FieldText="+phone;
	RequestQueue request = Volley.newRequestQueue(PhoneDetails.this);
	JsonObjectRequest jsonrequest = new JsonObjectRequest(Request.Method.GET, url, null, new Listener<JSONObject>() {

		@Override
		public void onResponse(JSONObject response) {
			// TODO Auto-generated method stub
			try {
				
				JSONObject data = response.getJSONObject("RationCardDetail");
				String source=data.getString("SRC_Number");
				String nam=data.getString("HOF_Name");
				String dis=data.getString("District_Name");
				String blo=data.getString("Block_Name");
				String pan=data.getString("Panchayat_Name");
				String vil = data.getString("Village_Name");
				String fp = data.getString("FPS_Id");
				String cardType=data.getString("Card_Type");
				String add=data.getString("Address");
				src.setText(source);
				name.setText(nam);
				village.setText(vil);
				district.setText(dis);
				block.setText(blo);
				panchayat.setText(pan);
				fps.setText(fp);
				address.setText(add);
				card.setText(cardType);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}, new Response.ErrorListener() {

		@Override
		public void onErrorResponse(VolleyError error) {
			// TODO Auto-generated method stub
			
		}
	});
	request.add(jsonrequest);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_details, menu);
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

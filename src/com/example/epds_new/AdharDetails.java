package com.example.epds_new;

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

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class AdharDetails extends ActionBarActivity {
public String url,id,adhar;
public TextView source,fps,village,block,panchayat,district,address,rcid,card,name;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adhar_details);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		name=(TextView)findViewById(R.id.adharName);
		district=(TextView)findViewById(R.id.districtAdhar);
		card=(TextView)findViewById(R.id.cardAdhar);
		address=(TextView)findViewById(R.id.addressAdhar);
		village=(TextView)findViewById(R.id.villageAdhar);
		block=(TextView)findViewById(R.id.blockAdhar);
		panchayat=(TextView)findViewById(R.id.panchayatAdhar);
		fps=(TextView)findViewById(R.id.fpsAdhar);
		rcid=(TextView)findViewById(R.id.rcId);
		source=(TextView)findViewById(R.id.srcAdhar);
		id=getIntent().getExtras().getString("adhar_id");
		adhar=getIntent().getExtras().getString("adhar");
		makeJsonRequest();
	}
public void makeJsonRequest()
{
 url="http://49.50.72.188/epdswebsite/webservice.asmx/Fetch_RCDataJson?TypeId="+id+"&FieldText="+adhar;
 RequestQueue req = Volley.newRequestQueue(AdharDetails.this);
 JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Listener<JSONObject>() {

	@Override
	public void onResponse(JSONObject response) {
		// TODO Auto-generated method stub
		try {
			JSONObject data=response.getJSONObject("RationCardDetail");
			String nam=data.getString("HOF_Name"); 
			String dis=data.getString("District_Name");
			String blo=data.getString("Block_Name");
			String vil=data.getString("Village_Name");
			String car=data.getString("Card_Type");
			String add=data.getString("Address");
			String pan = data.getString("Panchayat_Name");
			String fp=data.getString("FPS_Id");
			String rc=data.getString("RCID");
			String so =data.getString("SRC_Number");
			name.setText(nam);
			district.setText(dis);
			card.setText(car);
			block.setText(blo);
			village.setText(vil);
			address.setText(add);
			panchayat.setText(pan);
			fps.setText(fp);
			rcid.setText(rc);
			source.setText(so);
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
 req.add(jsonRequest);
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adhar_details, menu);
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

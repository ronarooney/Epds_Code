package com.example.epds_new;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class DfscFragment extends Fragment {
	public String url;
	private List<Models> movieList = new ArrayList<Models>();
	private ListView listView;
	private CustomListAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View rootView = inflater.inflate(R.layout.dfsc, container, false);
		listView = (ListView) rootView.findViewById(R.id.list);
		adapter = new CustomListAdapter(getActivity(), movieList);
		listView.setAdapter(adapter);
		makeJsonRequest();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				String n = movieList.get(position).getNumber().toString();
				String e = movieList.get(position).getEmail().toString();
				String t = movieList.get(position).getTitle().toString();
				String f = movieList.get(position).getFax().toString();
				String m = movieList.get(position).getMobile().toString();
				String a = movieList.get(position).getAddress().toString();
				Intent i = new Intent(getActivity(), DfscData.class);
				i.putExtra("serial", n);
				i.putExtra("email", e);
				i.putExtra("title", t);
				i.putExtra("mobile", m);
				i.putExtra("address", a);
				i.putExtra("fax", f);
				startActivity(i);
			}
		});
		return rootView;
	}

	public void makeJsonRequest() {
		url = "http://49.50.72.188/epdswebsite/webservice.asmx/GetDFSCDetails";
		RequestQueue req = Volley.newRequestQueue(getActivity());
		JsonObjectRequest rq = new JsonObjectRequest(Request.Method.GET, url,
				null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						// TODO Auto-generated method stub
						JSONArray ar;
						try {
							ar = response.getJSONArray("DFSCDetails");
							for (int i = 0; i < ar.length(); i++) {
								JSONObject district = ar.getJSONObject(i);
								String number = district
										.getString("District_Number");
								String landline = district
										.getString("LandLine");
								String fax = district.getString("Fax");
								String mobile = district.getString("Mobile");
								String email = district.getString("Email");
								String address = district.getString("Address");
								Models model = new Models();
								model.setTitle(district
										.getString("District_Name"));
								model.setNumber(number);
								model.setEmail(email);
								model.setFax(fax);
								model.setLandline(landline);
								model.setMobile(mobile);
								model.setAddress(address);
								movieList.add(model);
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub

					}
				});
		req.add(rq);
	}

	/*
	 * @Override public void onResume() { // TODO Auto-generated method stub
	 * super.onResume(); movieList.clear(); makeJsonRequest(); }
	 */

}

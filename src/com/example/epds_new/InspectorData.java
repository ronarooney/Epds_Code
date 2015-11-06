package com.example.epds_new;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
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

public class InspectorData extends Fragment {
	public String url;
	private List<InspectorModels> inspectorList = new ArrayList<InspectorModels>();
	private ListView listView;
	private InspectorCustomAdapter adapter;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.inspectdata, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
		adapter = new InspectorCustomAdapter(getActivity(), inspectorList);
		listView.setAdapter(adapter);
		makeJsonrequest();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String t=inspectorList.get(position).getTitle().toString();
				String n =inspectorList.get(position).getNumber().toString();
				String a=inspectorList.get(position).getAddress().toString();
				String o=inspectorList.get(position).getOffice().toString();
				String m =inspectorList.get(position).getMobile().toString();
				String i = inspectorList.get(position).getInspector().toString();
				Intent i1 = new Intent(getActivity(),Inspect.class);
				i1.putExtra("mobile",m );
				i1.putExtra("office", o);
				i1.putExtra("address", a);
				i1.putExtra("inspector", i);
				i1.putExtra("title", t);
				i1.putExtra("number", n);
				startActivity(i1);
			}
		});
		
        return rootView;
    }
	public void makeJsonrequest()
	{
		url = "http://49.50.72.188/epdswebsite/webservice.asmx/GetFoodInspectorDetails";
		RequestQueue req1 = Volley.newRequestQueue(getActivity());
		JsonObjectRequest rq1 = new JsonObjectRequest(Request.Method.GET, url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
				try {
					JSONArray inspector= response.getJSONArray("FoodinspectorDetails");
					for (int i = 0; i < inspector.length(); i++) {
						JSONObject inspectorData = (JSONObject) inspector.get(i);
						String number=inspectorData.getString("Block_Name");
						String inspector_name=inspectorData.getString("Inspector_Name");
						String address=inspectorData.getString("Office_Address");
						String office=inspectorData.getString("Office_Mobile");
						String mobile=inspectorData.getString("Personal_Mobile");
						InspectorModels model = new InspectorModels();
						model.setTitle(inspectorData.getString("District_Name"));
						model.setAddress(address);
						model.setNumber(number);
						model.setOffice(office);
						model.setInspector(inspector_name);
						model.setMobile(mobile);
						inspectorList.add(model);
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				adapter.notifyDataSetChanged();
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				error.printStackTrace();
			}
		});
		req1.add(rq1);
		
	}
}

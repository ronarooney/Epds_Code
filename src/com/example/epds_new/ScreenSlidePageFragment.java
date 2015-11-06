package com.example.epds_new;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment {
	TextView name,mother,father,uid,relation,age,gender;
public String url;
public int pos;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		 View rootView = inflater.inflate(R.layout.activity_memdetail, container, false);
		 name=(TextView)rootView.findViewById(R.id.member_name);
		 mother=(TextView)rootView.findViewById(R.id.mother_name);
		 father=(TextView)rootView.findViewById(R.id.father_name);
		 uid=(TextView)rootView.findViewById(R.id.u_id);
		 relation=(TextView)rootView.findViewById(R.id.relation);
		 age=(TextView)rootView.findViewById(R.id.age);
		 gender=(TextView)rootView.findViewById(R.id.gender);
		
		url= ((Member_Details)getActivity()).getUrl();
		System.out.println(url+""+"We are here");
		
	
	System.out.println(pos+""+"We are pos");
	makeJsonRequest();
		return rootView;

	}
	
	




	public void makeJsonRequest()
	{
		pos=getActivity().getIntent().getExtras().getInt("pos");
	
		RequestQueue req= Volley.newRequestQueue(getActivity());
	
		
		JsonObjectRequest rq= new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
			try {
			
			
				
				JSONArray ar= response.getJSONArray("MemberDetail");
				for(int i=0;i<ar.length();i++)
				{
					JSONObject data= ar.getJSONObject(pos);
					String n = data.getString("Member_Name");
					String m = data.getString("Mother_Name");
					String f = data.getString("Father_Name");
					String u = data.getString("UID");
					String r = data.getString("Relation");
					String a = data.getString("Age");
					String g = data.getString("Gender");
					name.setText(n);
					mother.setText(m);
					father.setText(f);
					uid.setText(u);
					relation.setText(r);
					age.setText(a);
					gender.setText(g);
					
					
					
				}
				
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
	public static Fragment newInstance() {
		// TODO Auto-generated method stub
		return new ScreenSlidePageFragment();
	}
}

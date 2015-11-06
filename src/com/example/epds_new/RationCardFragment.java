package com.example.epds_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RationCardFragment extends Fragment {
	public EditText t;

	public Spinner search;
	public Button a,p,r ;
	public int idr;
	public Intent i;

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.ration, container, false);
          
        	a=(Button)rootView.findViewById(R.id.adhar_search);
        	p=(Button)rootView.findViewById(R.id.phone_search);
        	r=(Button)rootView.findViewById(R.id.ration_search);
        	r.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String TypeId="2";
					Intent i= new Intent(getActivity(),Details.class);
					i.putExtra("type", TypeId);
					startActivity(i); 
					System.out.println(TypeId);
				}
			});
        	p.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String TypeId="1";
					Intent i= new Intent(getActivity(),PhoneSearch.class);
					i.putExtra("type", TypeId);
					startActivity(i);
				}
			});
        	a.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String TypeId="3";
					Intent i= new Intent(getActivity(),AdharSearch.class);
					i.putExtra("type", TypeId);
					startActivity(i);
				}
			});
        	
        return rootView;
    }

}

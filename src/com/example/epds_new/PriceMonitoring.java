package com.example.epds_new;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PriceMonitoring extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.activity_price_monitoring, container, false);
        Button grain = (Button)rootView.findViewById(R.id.button1);
        Button pulses = (Button)rootView.findViewById(R.id.button2);
        Button vegetable=(Button)rootView.findViewById(R.id.button3);
        Button other =(Button)rootView.findViewById(R.id.button4);
        vegetable.setOnClickListener(new OnClickListener() {
		
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(),Vegetable.class);
				startActivity(i);
			}
		});
        pulses.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),PulsesOil.class);
			startActivity(i);
			}
		});
        grain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(),GrainActivity.class);
				startActivity(i);
				
			}
		});
        other.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getActivity(),Other.class);
			startActivity(i);
			}
		});
		return rootView;
	}
	
	
}

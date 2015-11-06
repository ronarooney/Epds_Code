package com.example.epds_new;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Map extends Fragment {
	public GoogleMap googleMap;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) throws NullPointerException,
			InflateException {

		View rootView = inflater.inflate(R.layout.activity_map, container,
				false);
		Button shimla = (Button) rootView.findViewById(R.id.dfscShimla);
		shimla.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), ShimlaOffice.class);
				startActivity(i);
			}
		});
		Button am = (Button) rootView.findViewById(R.id.amOff);
		am.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), AmOffice.class);
				startActivity(i);
			}
		});
		Button dm = (Button) rootView.findViewById(R.id.dmOff);
		dm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), DmOffice.class);
				startActivity(i);
			}
		});
		Button inspector = (Button) rootView.findViewById(R.id.inspectorOffice);
		inspector.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), InspectorOffice.class);
				startActivity(i);

			}
		});
		Button nationalDistribution = (Button) rootView
				.findViewById(R.id.nationalDistributionOffice);
		nationalDistribution.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), NationDistribution.class);
				startActivity(i);
			}
		});
		Button pd = (Button) rootView.findViewById(R.id.pdc);
		pd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(),
						PrincipalDistributionCentre.class);
				startActivity(i);
			}
		});
		Button priceShop = (Button)rootView.findViewById(R.id.fairPrice);
		priceShop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getActivity(),FairPriceShop.class);
				startActivity(i);
			}
		});
		return rootView;
	}

}

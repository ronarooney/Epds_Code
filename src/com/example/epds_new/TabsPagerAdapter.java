package com.example.epds_new;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	private boolean paging=true;

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			return new InspectorData();
		case 1:
			return new DfscFragment();
		case 2:
			return new FacebookFragment();
		case 3:
			return new RationCardFragment();
		case 4:
			return new PriceMonitoring();
		case 5:
			return new Map();
		case 6 : 
			return new ContactusFragment();
		case 7:
			return new InfoFragment();
		case 8:
			return new AboutusFragment();
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		 String tabTitle = null;
		    switch(position) {
		    case 0:
		    	  tabTitle = "Inspector's Data";
		    
		    	break;
		        case 1: 
		            tabTitle = "DFSC";
		           
		            break;
		      
		        case 2: 
		        	 tabTitle = "Facebook";
		          break;
		        case 3: 
		        	 tabTitle = "Ration Card";
		            break;
		        case 4: 
		        	 tabTitle = "Price Monitoring";
		            break;
		        case 5:
		        	 tabTitle = "Map";
		        	 break;
		        	
		        case 6:
		        	  tabTitle = "Contact Us";
				   
		        	break;
		        case 7:
		        	tabTitle="Info";
		        	break;
		        case 8:
		        	tabTitle="About Us";
		        	
		    } 
		    return tabTitle;
		
	}

}

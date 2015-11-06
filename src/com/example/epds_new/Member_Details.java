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

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;

@SuppressLint("NewApi") public class Member_Details extends FragmentActivity  implements  ActionBar.TabListener {
public ViewPager pager;
 public  int NUM_PAGES ; public  int pos=0 ;
 private PagerAdapter mPagerAdapter;
 public String url;
	@SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_member__details);
		NUM_PAGES=getIntent().getExtras().getInt("int");
		pager=(ViewPager)findViewById(R.id.pager);
		 mPagerAdapter = new MemberPageAdapter(getSupportFragmentManager());
	        pager.setAdapter(mPagerAdapter);
	        url=getIntent().getExtras().getString("url");
	    System.out.println(url+"Success");
	ActionBar bar=	getActionBar();
	bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	pager.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void onPageScrolled(int position, float arg1, int arg2) {
			// TODO Auto-generated method stub
			pos++;
			Intent i = new Intent(Member_Details.this,ScreenSlidePageFragment.class);
			i.putExtra("pos", pos);
			setIntent(i);
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.member__details, menu);
		return true;
	}
	@Override 
    public void onBackPressed() { 
        if (pager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the 
            // Back button. This calls finish() on this activity and pops the back stack. 
            super.onBackPressed(); 
        } else { 
            // Otherwise, select the previous step. 
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        } 
    } 
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter { 
        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        } 
 
        @Override 
        public android.support.v4.app.Fragment getItem(int position) {
         
           
            return new ScreenSlidePageFragment(); 
        } 
 
        @Override 
        public int getCount() { 
            return NUM_PAGES;
        } 
    } 
	public String getUrl()
	{
		return url;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		pos++;

		Intent i = new Intent(Member_Details.this,ScreenSlidePageFragment.class);
		i.putExtra("pos", pos);
		setIntent(i);
	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


}
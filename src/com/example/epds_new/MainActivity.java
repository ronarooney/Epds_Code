package com.example.epds_new;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;


@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class MainActivity extends FragmentActivity implements ActionBar.TabListener{
	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public PagerTabStrip tabStrip;
    // Tab titles
    private String[] tabs = { "", "Dfsc", "Facebook","Ration Card","Price Monoitoring", "About Us","Contact US","Info"};
    @SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
 			tabStrip=(PagerTabStrip)findViewById(R.id.pager_tab_strip);
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);        

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
				
				@Override
				public void onPageSelected(int arg0) {
					// TODO Auto-generated method stub
				mAdapter.getPageTitle(arg0);
				
				}
				
				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					// TODO Auto-generated method stub
					mAdapter.getPageTitle(arg0);
				}
				
				@Override
				public void onPageScrollStateChanged(int arg0) {
					// TODO Auto-generated method stub
					mAdapter.getPageTitle(arg0);
				}
			});
            
           SelectiveViewPager a= new SelectiveViewPager(this);
          
    }
       
        
        // Attach the view pager to the tab strip
       
    }
    public class SelectiveViewPager extends ViewPager {
    	private boolean paging = true;
    	 
    	public SelectiveViewPager(Context context) {
    	    super(context);
    	} 
    	 
    	public SelectiveViewPager(Context context, AttributeSet attributeSet){
    	    super(context, attributeSet);
    	} 
    	 
    	@Override 
    	public boolean onInterceptTouchEvent(MotionEvent e) {
    	    if (paging) {
    	        return super.onInterceptTouchEvent(e);
    	    } 
    	 
    	    return false; 
    	} 
    	 
    	public void setPaging(boolean p){ paging = p; }
    	 
    	} 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}


	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
}

package com.example.epds_new;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MemberPageAdapter extends FragmentPagerAdapter{

	public MemberPageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		
		switch (index) {
		case 0:
			return new ScreenSlidePageFragment();
		case 1:
			return new ScreenSlidePageFragment();
		case 2:
			return new ScreenSlidePageFragment();
		case 3:
			return new RationCardFragment();
		case 4:
			return new ScreenSlidePageFragment();
		case 5:
			return new ScreenSlidePageFragment();
		case 6 : 
			return new ScreenSlidePageFragment();
		case 7:
			return new ScreenSlidePageFragment();
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
